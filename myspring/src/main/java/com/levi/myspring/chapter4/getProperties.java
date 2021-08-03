package com.levi.myspring.chapter4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "book")
public class getProperties {

    @Value("${book.name}")
    private String bookname;

    @Value("${book.author}")
    private String bookauthor;

    @GetMapping("getproperties")
    public String getBookProperties(){
        return "本书的书名是："+bookname+",作者是："+bookauthor;
    }
}
