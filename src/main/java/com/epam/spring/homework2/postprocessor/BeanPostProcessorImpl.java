package com.epam.spring.homework2.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(!isValid(bean)){
            System.out.println(beanName+" is not valid");
            throw new RuntimeException(beanName+" is not valid");
        }
        System.out.println(beanName+" is valid");

        return bean;
    }

    private boolean isValid(Object bean) {
        try {
            Field nameField = bean.getClass().getDeclaredField("nameField");
            nameField.setAccessible(true);
            Field valueField = bean.getClass().getDeclaredField("valueField");
            valueField.setAccessible(true);

            String name = (String) nameField.get(bean);
            int value = (int) valueField.get(bean);

            if(name == null || value <=0)
                return false;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return true;
        }
        return true;
    }

}
