package com.phantom5702.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BaseConfig {

    //注意不能用static 的 field
    @Value("${dic.test_console}")
    public  String console;

    @Value("${server.port}")
    public  String port;

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
