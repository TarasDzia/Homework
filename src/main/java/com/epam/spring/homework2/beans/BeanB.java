package com.epam.spring.homework2.beans;



public class BeanB extends SimpleBean{
    public BeanB(String name, int value) {
        super(name, value);
    }

    public void init(){
        System.out.println(this.getClass().getSimpleName() +"#initMethod()");
    }
    public void anotherInit(){
        System.out.println(this.getClass().getSimpleName() +"#anotherInitMethod()");
    }
    public void destroy(){
        System.out.println(this.getClass().getSimpleName() +"#destroyMethod()");
    }
}
