package com.debug.kill.server;/**
 * Created by Administrator on 2019/6/13.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/6/13 22:50
 **/
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-jdbc.xml"})
@MapperScan(basePackages = "com.debug.kill.model.mapper")
@EnableScheduling
public class MainApplication extends SpringBootServletInitializer{

    /* Note:
     * 1. 打成war包时，需要修改启动Application文件继承SpringBootServletInitializer,实现configure方法
     *
     * ps. 打成jar和打成war的区别？
     * SpringBoot 项目打包时能打成 .jar 与 .war包文件，打成 .jar 的最多，使用 java -jar xx.jar 就可以启动，而 .war 可以部署到tomcat的 webapps 中，随tomcat的启动而启动。
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }

}