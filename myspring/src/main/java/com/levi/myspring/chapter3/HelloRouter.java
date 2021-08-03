package com.levi.myspring.chapter3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class HelloRouter {

//    @Bean
//    public RouterFunction<ServerResponse> routeHello (HelloHandle helloHandle){
//        return RouterFunctions
//                .route(RequestPredicates.GET("/hellowebflux")
//                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
//        helloHandle::hello);
//    }
}
