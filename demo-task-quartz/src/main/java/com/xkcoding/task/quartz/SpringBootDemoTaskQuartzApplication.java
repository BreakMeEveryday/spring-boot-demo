package com.xkcoding.task.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-23 20:33
 *
 * 启动的时候，如果出现了大小写的问题，可以参考下面的文章取消大小写，或者干脆点，把脚本里的表名都改成大写：
 * https://blog.csdn.net/qq_40064118/article/details/111381229
 * SET GLOBAL lower_case_table_names = 1; // 全局
 * SET SESSION lower_case_table_names = 1; // 会话
 */
@MapperScan(basePackages = {"com.xkcoding.task.quartz.mapper"})
@SpringBootApplication
public class SpringBootDemoTaskQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoTaskQuartzApplication.class, args);
    }
}
