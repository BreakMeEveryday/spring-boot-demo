package com.xkcoding.exception.handler.controller;

import com.xkcoding.exception.handler.constant.Status;
import com.xkcoding.exception.handler.exception.JsonException;
import com.xkcoding.exception.handler.exception.PageException;
import com.xkcoding.exception.handler.model.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-02 20:49
 */
@Controller
public class TestController {

    @GetMapping("/json")
    @ResponseBody //有@RequestBody，也有@ResponseBody
    public ApiResponse jsonException() { // 按照正常逻辑，要返回一个ApiResponse类，但是这里手动抛出了一个JsonException异常
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page") // 对于Spring MVC就没有ResponseBody了，而是一个页面
    public ModelAndView pageException() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }
}
