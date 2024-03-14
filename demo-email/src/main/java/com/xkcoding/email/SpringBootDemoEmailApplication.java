package com.xkcoding.email;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-04 22:38
 */
@SpringBootApplication
@EnableEncryptableProperties
public class SpringBootDemoEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoEmailApplication.class, args);
    }
}
