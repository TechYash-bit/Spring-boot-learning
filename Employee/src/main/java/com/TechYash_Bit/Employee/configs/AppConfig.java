package com.TechYash_Bit.Employee.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
