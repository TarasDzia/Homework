package com.epam.spring.homework2.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String methodName = configurableListableBeanFactory.getBeanDefinition("beanB").getInitMethodName();
        System.out.println("BeanFactoryPostProcessor start changing init method from \""+ methodName  + "\" to \"" + "anotherInit\"");

        configurableListableBeanFactory.getBeanDefinition("beanB").setInitMethodName("anotherInit");

        methodName = configurableListableBeanFactory.getBeanDefinition("beanB").getInitMethodName();
        System.out.println("BeanFactoryPostProcessor end changing... Current initMethod name = \""+ methodName + "\"");
    }
}
