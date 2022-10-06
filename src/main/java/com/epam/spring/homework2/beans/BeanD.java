package com.epam.spring.homework2.beans;



public class BeanD extends SimpleBean{
    public BeanD(String name, int value) {
        super(name, value);
    }

    public void init(){
        System.out.println(this.getClass().getSimpleName() +"#initMethod()");
    }
    public void destroy(){
        System.out.println(this.getClass().getSimpleName() +"#destroyMethod()");
    }
}
