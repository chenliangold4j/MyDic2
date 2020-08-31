package com.phantom5702.condition.config;

import com.phantom5702.condition.bean.BaseBean;
import com.phantom5702.condition.bean.WorkBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig2 {


    @Bean
    @ConditionalOnBean(BaseBean.class)
    WorkBean workBean(BaseBean baseBean) {
        WorkBean workBean = new WorkBean();
        workBean.setId(1);
        workBean.setBaseBean(baseBean);
        return workBean;
    }

    @Bean
    @ConditionalOnClass(name = "com.phantom5702.condition.controller.VerifyController")
    WorkBean workBean2() {
        WorkBean workBean = new WorkBean();
        workBean.setId(2);
        return workBean;
    }

    @Bean
    @ConditionalOnProperty(prefix = "dic", name = "test_console")
    WorkBean workBean3() {
        WorkBean workBean = new WorkBean();
        workBean.setId(3);
        return workBean;
    }


}
