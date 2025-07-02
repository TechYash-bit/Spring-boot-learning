package com.TechYash_Bit.day1;

import org.springframework.stereotype.Component;


public class Apple {

    public void eatApple(){
        System.out.println("WITHOUT : A man eating a apple");
    }

    public void eatApple(String name){
        System.out.println("WITH : "+name+" is eating apple");
    }
}
