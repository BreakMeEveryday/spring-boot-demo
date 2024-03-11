package com.xkcoding.exception.handler.handler;

import com.xkcoding.exception.handler.exception.JsonException;
import com.xkcoding.exception.handler.exception.PageException;
import com.xkcoding.exception.handler.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * <p>
 * 统一异常处理
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-02 21:26
 *
 * @ControllerAdvice是 Spring 框架中的一个注解，用于全局异常处理和全局数据绑定。它可以被用于标记一个类，该类被视为全局控制器的增强器。其主要作用包括：
 * 全局异常处理：通过在@ExceptionHandler注解标记的方法中捕获异常，并对异常进行处理，可以统一处理应用中的异常情况，返回统一的错误响应或者执行其他操作，例如记录日志等。
 * 全局数据绑定：通过在@ModelAttribute注解标记的方法中定义全局的模型属性，可以在多个控制器中共享相同的模型数据。
 * 全局数据预处理：将一些公共的数据定义在添加了@ControllerAdvice注解的类中，这样，在每一个 Controller 的接口中，就都能够访问导致这些数据。
 * 总的来说，@ControllerAdvice是一个非常有用的注解，它可以提高应用程序的稳定性和可维护性，也可以减少代码重复和冗余。
 */
@ControllerAdvice
@Slf4j
public class DemoExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一 json 异常处理
     *
     * @param exception JsonException
     * @return 统一返回 json 格式
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(JsonException exception) {
        log.error("【JsonException】:{}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }

    /**
     * 统一 页面 异常处理
     *
     * Spring MVC架构 model - view - controller
     * (1)官网：https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
     * (2)https://pdai.tech/md/spring/spring-x-framework-springmvc.html
     * ModelAndView中的model用法具体看modelAndView.addObject()，已经封装了
     * @param exception PageException
     * @return 统一跳转到异常页面
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageErrorHandler(PageException exception) {
        log.error("【DemoPageException】:{}", exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        // 可以看到，数据其实都存储在model里
        modelAndView.addObject("message", exception.getMessage()); // 页面里的一些值信息，用key-value形式存起来
        log.info("查看model"+modelAndView.getModel().toString());
        // model部分处理完成
        modelAndView.setViewName(DEFAULT_ERROR_VIEW); // 跳转的view页面名字为error，也就是error.html
        return modelAndView;
    }
}
