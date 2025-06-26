package com.TechYash_Bit.day2;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "database.env" ,havingValue = "dev")

public class DevDb implements DataBase{
    public String getDB(){
        return "this is devlopment database";
    }
}
