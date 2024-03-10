package com.xkcoding.actuator.controller;

/**
 * @ClassName: RestartController
 * @Author: 键盘国治理专家
 * @email: ?????????@qq.com
 * @Time: 2024/3/10 下午8:59
 * @Description:
 * @Version: 1.0
 */
import com.xkcoding.actuator.SpringBootDemoActuatorApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestartController {

  @Autowired
  private ConfigurableApplicationContext context;

  @GetMapping("/restart")
  public String restart() {
    Thread thread = new Thread(() -> {
      context.close();
      SpringApplication.run(SpringBootDemoActuatorApplication.class);
    });
    thread.setDaemon(false);
    thread.start();

    return "Restarting...";
  }
}
