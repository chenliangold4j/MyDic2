package com.phantom5702.condition.controller;

import cn.hutool.json.JSONUtil;
import com.phantom5702.condition.bean.WorkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class VerifyController {

    @Autowired
    ApplicationContext applicationContext;


    @Autowired(required = false)
    @Qualifier("workBean")
    WorkBean workBean;

    @Autowired(required = false)
    @Qualifier("workBean2")
    WorkBean workBean2;

    @Autowired(required = false)
    @Qualifier("workBean3")
    WorkBean workBean3;

    @Autowired(required = false)
    @Qualifier("workBeanT")
    WorkBean workBeanT;

    @GetMapping("/test")
    public void verify() {
        System.out.println("workBean" + JSONUtil.toJsonStr(workBean));
        System.out.println("workBean2" + JSONUtil.toJsonStr(workBean2));
        System.out.println("workBean3" + JSONUtil.toJsonStr(workBean3));
        System.out.println("workBeanT" + JSONUtil.toJsonStr(workBeanT));
    }


}
