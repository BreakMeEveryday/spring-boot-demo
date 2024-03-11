package com.xkcoding.template.freemarker.controller;

import cn.hutool.core.util.ObjectUtil;
import com.xkcoding.template.freemarker.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 主页
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-19 15:07
 */
@Controller
@Slf4j
public class IndexController {

    /*
    * 第一个值"" ： 表示空字符串，表示该注解可以匹配任何请求路径，包括根路径（/)。
    * 第二个值"/"： 表示斜杠字符，表示该注解可以匹配根路径（/)。
    * */
    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        User user = (User) request.getSession().getAttribute("user");
        if (ObjectUtil.isNull(user)) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.setViewName("page/index"); // user非空可以跳转首页
            mv.addObject(user);
        }

        return mv;
    }
}
