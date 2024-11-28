package com.metacoding.authblog._core.config;

import com.metacoding.authblog._core.filter.AuthenticationFilter;
import com.metacoding.authblog._core.filter.MerongFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class FilterConfig {
//
//    @Bean // 빈으로 등록하면 return 값이 IoC에 등록됨
//    public FilterRegistrationBean addAuthFilter(){
//        FilterRegistrationBean rg = new FilterRegistrationBean();
//        rg.setFilter(new AuthenticationFilter());
//        rg.addUrlPatterns("/board/*");
//        rg.addUrlPatterns("/user/*");
//        rg.setOrder(1);
//
//        return rg;
//    }
//
//    @Bean
//    public FilterRegistrationBean addAuthFilter2(){
//        FilterRegistrationBean rg = new FilterRegistrationBean();
//        rg.setFilter(new MerongFilter());
//        rg.addUrlPatterns("/*"); // 특정 경로로 제한
//        rg.setOrder(2);
//
//        return rg;
//    }
//}
