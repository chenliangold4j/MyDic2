package com.phantom5702.condition.test;

import cn.hutool.json.JSONUtil;
import com.phantom5702.condition.test.bean.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Test implements CommandLineRunner {

    @Bean
    Person person() {
        Person person = new Person();
        person.setName("test");
        person.setAddress("est");
        return person;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Test.class).web(WebApplicationType.NONE).run(args);
    }

    /**
     * InstantiationAwareBeanPostProcessor的触发入口从AbstractAutowireCapableBeanFactory#createBean开始。
     * bean实例化之前会检测是否存在该类型的接口，并触发前置postProcessBeforeInstantiation。注册多个实例时会依次执行回调，
     * 任何一个返回非null则直接执行BeanPostProcessor#postProcessAfterInitialization完成初始化。
     * 返回的bean直接返回容器，生命周期缩短。
     * 后置postProcessAfterInstantiation会在实例化之后，依赖注入和初始化方法之前。
     * 注册多个接口只要其中一个返回false，即停止后续执行。 返回结果会影响后续执行流程，通过此定制化bean属性注入等操作。
     * 优先回调postProcessProperties，spring-5.1之后新增回调接口 用以替代标注过时的postProcessPropertyValues方法。
     * InstantiationAwareBeanPostProcessor设计主要给基础性框架使用，
     * 日常应用spring推荐使用适配器类InstantiationAwareBeanPostProcessorAdapter。
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("runner:"+JSONUtil.toJsonStr(person()));
    }
}
