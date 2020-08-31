package com.phantom5702.condition.config;

import com.phantom5702.condition.bean.BaseBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    BaseBean baseBean() {
        BaseBean baseBean = new BaseBean();
        baseBean.setName("被依赖的bean");
        return baseBean;
    }
}
