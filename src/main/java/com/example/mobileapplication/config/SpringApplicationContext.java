package com.example.mobileapplication.config;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;


public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }
    public static Object getBean(String beanName){
        return CONTEXT.getBean(beanName);
    }

    //
@Bean
    public SpringApplicationContext springApplicationContext(){
        return new SpringApplicationContext();
    }
//    @Bean(name = "AppProperties")
//    public AppProperties getAppProperties(){
//        return new AppProperties();
//    }


}
