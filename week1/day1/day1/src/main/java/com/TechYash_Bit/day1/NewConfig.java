package com.TechYash_Bit.day1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewConfig {
    @Bean
    Apple eatApple(){
        return new Apple();
    }
}
