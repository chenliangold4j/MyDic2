package com.phantom5702.entry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.phantom5702")
public class MyDic {

    public static void main(String[] args) {
        SpringApplication.run(MyDic.class, args);
    }
}
