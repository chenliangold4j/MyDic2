package com.phantom5702.condition.test.bean;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * 二、InstantiationAwareBeanPostProcessor与BeanPostProcessor对比
 * 1、BeanPostProcessor 执行时机为bean初始化（Initialization）阶段，日常可以拓展该接口对bean初始化进行定制化处理。
 * 2、InstantiationAwareBeanPostProcessor 执行时机bean实例化（Instantiation）阶段，
 * 典型用于替换bean默认创建方式，例如aop通过拓展接口生成代理对应，主要用于基础框架层面。
 * 如果日常业务中需要拓展该，spring推荐使用适配器类InstantiationAwareBeanPostProcessorAdapter。
 * 3、所有bean创建都会进行回调。
 */
@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    // 接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,
                                                 String beanName) throws BeansException {
        if (beanName != null && beanName.equals("person"))
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName != null && beanName.equals("person"))
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        return bean;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,
                                                    PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if (beanName != null && beanName.equals("person")) {
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
            System.out.println(JSONUtil.toJsonStr(pvs));
        }
        return pvs;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if (beanName != null && beanName.equals("person"))
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessProperties方法");
        return null;
    }
}