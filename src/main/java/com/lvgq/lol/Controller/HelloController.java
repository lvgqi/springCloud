package com.lvgq.lol.Controller;

import com.lvgq.lol.model.Aliyun;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.lvgq.lol.Controller
 * @ClassName: HelloController
 * @Author: lvgq
 * @CreateTime: 2021/12/2 10:38
 * @Description:
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("hello1")
    String hello1() {
        return "1111111111111111111111111";
    }


    @Value("${server.port}")
    String port;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @RequestMapping("hello2")
    public String home(String name) {
        System.out.println("==========="+password);
        return "hi " + username + ",i am from port:" + password;
    }

    @Value("${oss.appKey}")
    private String appKey;

    @Value("${oss.appSecret}")
    private String appSecret;

    @Value("${oss.bucket}")
    private String bucket;

    @Value("${oss.endPoint}")
    private String endPoint;

    @Bean
    public Aliyun aliyun() {
        return Aliyun.options().setAppKey(appKey).setAppSecret(appSecret).setBucket(bucket).setEndPoint(endPoint).build();
    }

}