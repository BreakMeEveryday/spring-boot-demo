package com.xkcoding.rbac.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-10 11:28
 * Spring-Security 与 Shiro的对比
 * (1) https://blog.csdn.net/weixin_69084736/article/details/126715274
 * (2) https://stackoverflow.com/questions/11500646/spring-security-vs-apache-shiro
 * 本项目的数据库表结构设计和B站视频上讲的完全一致
 * 【【IT老齐217】简单粗暴讲解RBAC四级角色权限模型】 https://www.bilibili.com/video/BV1YT411N76n
 *  users, roles, --> user_roles
 *  permissions,  --> role_permissions
 */
@SpringBootApplication
public class SpringBootDemoRbacSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoRbacSecurityApplication.class, args);
    }
}
