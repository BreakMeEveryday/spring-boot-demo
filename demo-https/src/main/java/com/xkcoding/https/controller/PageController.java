package com.xkcoding.https.controller;

/**
 * @ClassName: PageController
 * @Author: 键盘国治理专家
 * @email: ?????????@qq.com
 * @Time: 2024/3/14 下午8:22
 * @Description:
 * @Version: 1.0
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 页面跳转 Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-19 19:57
 */
@Controller
@RequestMapping("/page")
public class PageController {
  /**
   * 如果注释掉ssl，可以请求下列两种地址，实际上都没有走https
   * (1) http://localhost:8081/demo/page/index
   * (2) http://localhost:8082/demo/page/index
   * 如果开启ssl，可以请求下列两种地址，最终都会是https请求
   * (1) http://localhost:8081/demo/page/index  --> 会自动跳转到(2)地址
   * (2) https://localhost:8082/demo/page/index
   * 跳转到 首页
   *
   * @param request 请求
   */
  @GetMapping("/index")
  public ModelAndView index(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");
    return mv;
  }

}
