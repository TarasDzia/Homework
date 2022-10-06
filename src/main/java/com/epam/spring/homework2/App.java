package com.epam.spring.homework2;

import com.epam.spring.homework2.postprocessor.BeanFactoryPostProcessorImpl;
import com.epam.spring.homework2.beans.SimpleBean;
import com.epam.spring.homework2.configs.BeanConfig1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class App {
    final List<SimpleBean> beans;

    @Autowired
    public App(List<SimpleBean> beans) {
        this.beans = beans;
    }

    public void printBeans(){
        System.out.println("\nCreated beans:");
        beans.forEach(System.out::println);
        System.out.println();
    }

    public static void printBeansConfigs(AnnotationConfigApplicationContext ctx){
        System.out.println("\nBeans configs:");
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(d -> System.out.println(ctx.getBeanDefinition(d)));
        System.out.println();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext();
        BeanFactoryPostProcessor processor = new BeanFactoryPostProcessorImpl();

        ctx.register(BeanConfig1.class);
        ctx.addBeanFactoryPostProcessor(processor);
        ctx.refresh();

        App app = ctx.getBean(App.class);
        app.printBeans();

        printBeansConfigs(ctx);
        ctx.registerShutdownHook();
    }
}
