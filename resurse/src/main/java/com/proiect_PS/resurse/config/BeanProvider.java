package com.proiect_PS.resurse.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanProvider implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static void autowire(Object object){
        applicationContext.getAutowireCapableBeanFactory().autowireBean(object);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext){
        BeanProvider.applicationContext=applicationContext;
    }
}
