package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanF extends SimpleBean{
    public BeanF(@Value("default-name") String name, @Value("0") int value) {
        super(name, value);
    }
}
