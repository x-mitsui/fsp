package com.dzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class FamilyServicePlatform2Application {

    public static void main(String[] args) {
        SpringApplication.run(FamilyServicePlatform2Application.class, args);
    }

}
