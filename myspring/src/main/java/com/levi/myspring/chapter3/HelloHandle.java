package com.levi.myspring.chapter3;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import javax.servlet.ServletRequest;

@Component
public class HelloHandle {
//    public Mono<ServerResponse> hello(ServletRequest request){
//        return (Mono<ServerResponse>) ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromObject("Hello,this is a springboot webflux Project !"));
//    }
}
