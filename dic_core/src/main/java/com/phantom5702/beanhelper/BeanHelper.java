package com.phantom5702.beanhelper;

/**
 * 自定义修改bean的三个方案：
 * 1.BeanFactoryPostProcessor 的 postProcessBeanFactory 获取bean定义，然后设置bean的定义属性，
 * 2.InstantiationAwareBeanPostProcessorAdapter 的 postProcessAfterInitialization
 * 3.spring初始化之后 implements ApplicationListener<ContextRefreshedEvent>，修改bean然后再放入
 */
public class BeanHelper {
    //TODO 工具类 1.修改bean的任意field为传入的field  2.简易的前置aop
}
