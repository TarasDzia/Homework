package com.epam.spring.homework2.configs;

import com.epam.spring.homework2.App;
import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.beans.SimpleBean;
import com.epam.spring.homework2.postprocessor.BeanPostProcessorImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@Import(BeanConfig2.class)
public class BeanConfig1 {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB beanB(@Value("${data.beanB.name}") String name, @Value("${data.beanB.value}") int value){
        return new BeanB(name, value);
    }

    @DependsOn("beanB")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanC beanC(@Value("${data.beanC.name}") String name, @Value("${data.beanC.value}") int value){
        return new BeanC(name, value);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD(@Value("${data.beanD.name}") String name, @Value("${data.beanD.value}") int value){
        return new BeanD(name, value);
    }
    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessorImpl();
    }

    @Bean
    public App app(List<SimpleBean> beans){
        return new App(beans);
    }
}
