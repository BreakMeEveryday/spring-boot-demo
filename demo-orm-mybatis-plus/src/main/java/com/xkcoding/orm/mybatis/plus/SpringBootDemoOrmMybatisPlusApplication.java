package com.xkcoding.orm.mybatis.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 16:48
 *
 * 启动如果报Shutdown completed，看 https://blog.csdn.net/VABTC/article/details/112008583
 */
@SpringBootApplication
public class SpringBootDemoOrmMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoOrmMybatisPlusApplication.class, args);
    }
}
