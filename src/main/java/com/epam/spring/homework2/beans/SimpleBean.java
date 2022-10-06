package com.epam.spring.homework2.beans;

public abstract class SimpleBean {
    protected String name;
    protected int value;

    public SimpleBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


}
