package com.xkcoding.actuator.security;

/**
 * @ClassName: ApiSecurity
 * @Author: 键盘国治理专家
 * @email: ?????????@qq.com
 * @Time: 2024/3/10 下午9:08
 * @Description:
 * @Version: 1.0
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;

/*
 * 加了这个后允许shutdown
 * https://stackoverflow.com/questions/50689032/spring-boot-actuator-shutdown-endpoint-forbidden
 */
@Configuration
public class ApiSecurity extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().
      requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests().anyRequest().permitAll();
  }

}
