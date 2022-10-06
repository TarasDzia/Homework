package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE extends SimpleBean{
    public BeanE(@Value("default-name") String name, @Value("0") int value) {
        super(name, value);
    }

    @PostConstruct
    public void postConstruct () throws Exception {
        System.out.println(this.getClass().getSimpleName() +"#postConstruct()");
    }

    @PreDestroy
    public void preDestroy () throws Exception {
        System.out.println(this.getClass().getSimpleName() +"#preDestroy()");
    }
}
