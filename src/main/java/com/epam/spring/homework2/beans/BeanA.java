package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA extends SimpleBean implements InitializingBean, DisposableBean {

    public BeanA(@Value("default-name") String name, @Value("0") int value) {
        super(name, value);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() +"#afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() +"#destroy()");
    }
}
