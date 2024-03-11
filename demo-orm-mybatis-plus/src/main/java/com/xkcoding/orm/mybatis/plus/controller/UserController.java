package com.xkcoding.orm.mybatis.plus.controller;

import com.xkcoding.orm.mybatis.plus.entity.User;
import com.xkcoding.orm.mybatis.plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Author: 键盘国治理专家
 * @email: ?????????@qq.com
 * @Time: 2024/3/11 下午8:15
 * @Description:
 * @Version: 1.0
 */
@RestController
@Slf4j
public class UserController {
  private final UserService userService;
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  public void insertUser(@RequestBody User user){
    userService.save(user);
  }

}
