package com.phantom5702.condition.test.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName != null && beanName.equals("person")) {
            System.out.println("BeanPostProcessor接口方法 postProcessAfterInitialization对属性进行更改！");
            System.out.println("beanName : " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName != null && beanName.equals("person")) {
            System.out.println("BeanPostProcessor接口方法 postProcessBeforeInitialization对属性进行更改！");
            System.out.println("beanName : " + beanName);
        }
        return bean;
    }
}