package com.epam.spring.homework1.config;

import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Spider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "com.epam.spring.homework1.pet",
        excludeFilters = {@ComponentScan.Filter(value = Spider.class, type = FilterType.ASSIGNABLE_TYPE)})
public class PetConfig {

    @Bean
    @Primary
    public Cheetah cheetah1(){
        return new Cheetah();
    }

    @Bean
    @Qualifier("secondary")
    public Cheetah cheetah2(){
        return cheetah1();
    }

}
