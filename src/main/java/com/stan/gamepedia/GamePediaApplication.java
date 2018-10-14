package com.stan.gamepedia;

import com.alibaba.druid.pool.DruidDataSource;
import com.stan.gamepedia.filter.RestFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
@ComponentScan(basePackages = "com.stan")
@ServletComponentScan
@SpringBootApplication
public class GamePediaApplication extends SpringBootServletInitializer {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;


    @Bean     //声明其为Bean实例
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(jdbcUrl);
        datasource.setUsername(jdbcUsername);
        datasource.setPassword(jdbcPassword);
        datasource.setDriverClassName(jdbcDriverClassName);

        return datasource;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new RestFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("RestFilter");

        registration.setOrder(1);

        return registration;
    }





    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GamePediaApplication.class);
    }

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(GamePediaApplication.class);
        Environment environment = app.run(args).getEnvironment();

    }

}
