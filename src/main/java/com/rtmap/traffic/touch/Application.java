package com.rtmap.traffic.touch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring-boot 启动程序主入口
 */
@SpringBootApplication(scanBasePackages = "com.rtmap.traffic.touch")
//@EnableAutoConfiguration
//@EnableTransactionManagement
//@ComponentScan(basePackages = "com.rtmap.traffic.touch")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
