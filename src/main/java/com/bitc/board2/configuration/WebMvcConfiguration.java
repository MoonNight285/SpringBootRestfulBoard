package com.bitc.board2.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    
    // addResourceHandlers : 스프링 내에서 사용할 폴더명을 설정, 여러개의 폴더명을 설정하고자 할 경우
    // addResourceHandlers()를 여러개 사용하면 된다.
    // addResourceLocations : 실제 시스템 내의 폴더 위치를 설정, 스프링 내에서는 1개의 폴더로 설정하고 실제 폴더는 여러개의
    // 폴더를 등록하고자 할 경우 addResourceLocations()에 여러개의 경로를 입력함
    // 주의사항 : 경로의 마지막에 /를 반드시 붙여야 함
    // file:/// => 시스템이 윈도우일 경우 
    // file:/ => 리눅스, 맥 시스템일 경우

    @Value("${resources.images.location}")
    private String imagesLocation;
    
    @Value("${resources.images.location1}")
    private String imagesLoaction1;
    
    @Value("${resources.images.location2}")
    private String imagesLocation2;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imgPath = "file:///" + imagesLocation;
        registry.addResourceHandler("/img/**").addResourceLocations(imgPath);
    }
}
