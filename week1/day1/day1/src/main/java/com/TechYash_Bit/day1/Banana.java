package com.TechYash_Bit.day1;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Banana {

    @PostConstruct//this will run first that is before the main method
    public  void eatBanana2(){
        System.out.println(" POST CONSTRUCTOR :a man is eating a banana");
    }

    public  void eatBanana(){
        System.out.println(" a man is eating a banana");
    }


    public void eatBanana(String name){
        System.out.println("banana is eat by "+name);
    }
}
