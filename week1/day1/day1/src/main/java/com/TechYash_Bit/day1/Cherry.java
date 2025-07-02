package com.TechYash_Bit.day1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Cherry {

    @PreDestroy//this will run after he project will stop
    public void eatcherry(){
        System.out.println(" PRE DESTROY :cherry is eatten by men");
    }
}
