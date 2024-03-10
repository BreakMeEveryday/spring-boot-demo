package com.xkcoding.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-9-29 14:27
 *
 * Spring Boot Actuator是Spring Boot框架的一部分，它提供了一组内置的端点（endpoint），用于监控和管理Spring Boot应用程序。
 * 这些端点可以提供应用程序的健康状态、指标、日志、配置等信息，并允许你执行一些管理操作，如重新启动应用程序、更新配置等。
 * Spring Boot Actuator的主要作用是提供了一种标准的方式来监控和管理Spring Boot应用程序，帮助你更好地理解和控制应用程序的运行状态。
 * 以下是Spring Boot Actuator的一些主要功能：
 * 健康检查端点：提供了获取应用程序健康状态的端点，包括应用程序的启动时间、内存使用情况、线程信息等。
 * 指标端点：提供了获取应用程序指标信息的端点，包括请求率、响应时间、错误率等。
 * 日志端点：提供了获取应用程序日志信息的端点，可以查看应用程序的日志输出。
 * 配置端点：提供了获取和更新应用程序配置信息的端点，可以查看和修改应用程序的配置。
 * 其他管理端点：提供了一些其他管理端点，如重新启动应用程序、查看线程信息、查看堆内存信息等。
 * 通过使用Spring Boot Actuator，你可以方便地监控和管理Spring Boot应用程序，了解应用程序的运行状态和性能，帮助你及时发现和解决问题。
 */
@SpringBootApplication
public class SpringBootDemoActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoActuatorApplication.class, args);
        System.out.println("----- http://localhost:8082/demo/ -----");
        System.out.println("----- 请访问该地址查看监控信息 http://localhost:8090/sys/actuator -----");
        System.out.println("----- 重启应用 http://localhost:8082/demo/restart -----");
        System.out.println("----- 使用post请求关闭应用: ----- \ncurl -XPOST http://localhost:8090/sys/actuator/shutdown ");
    }
}
