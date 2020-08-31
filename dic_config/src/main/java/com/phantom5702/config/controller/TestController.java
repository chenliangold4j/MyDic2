package com.phantom5702.config.controller;

import com.phantom5702.config.config.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    BaseConfig baseConfig;

    @RequestMapping("/getConsole")
    public String myTest() {
        return baseConfig.getConsole() + ":" + baseConfig.getPort();
    }

}
