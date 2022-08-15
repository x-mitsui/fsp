package com.dzq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig(){
        CorsConfiguration configuration = new CorsConfiguration();
        //设置属性
        //允许跨域请求的地址，*表示所有，SpringBoot升级后无法与setAllowCredentials(true)共同使用
        //configuration.addAllowedOrigin("*");

        // 改成用setAllowedOriginPatterns
        List<String> allowedOriginPatterns = new ArrayList<>();
        allowedOriginPatterns.add("*");
        configuration.setAllowedOriginPatterns(allowedOriginPatterns);
        //配置跨域的请求头
        configuration.addAllowedHeader("*");
        //配置跨域的请求方法
        configuration.addAllowedMethod("*");
        // 表示跨域请求的时候是否使用的是同一个session
        configuration.setAllowCredentials(true);
        return  configuration;
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }
}
