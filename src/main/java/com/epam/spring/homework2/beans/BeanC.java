package com.epam.spring.homework2.beans;


public class BeanC extends SimpleBean{
    public BeanC(String name, int value) {
        super(name, value);
    }

    public void init(){
        System.out.println(this.getClass().getSimpleName() +"#initMethod()");
    }
    public void destroy(){
        System.out.println(this.getClass().getSimpleName() +"#destroyMethod()");
    }
}
