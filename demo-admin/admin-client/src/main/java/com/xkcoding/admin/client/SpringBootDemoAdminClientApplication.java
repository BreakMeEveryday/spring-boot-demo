package com.xkcoding.admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-8 14:16
 */
@SpringBootApplication
public class SpringBootDemoAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAdminClientApplication.class, args);
      System.out.println("请访问服务端查看Client的情况：http://localhost:8000/");
    }
}
