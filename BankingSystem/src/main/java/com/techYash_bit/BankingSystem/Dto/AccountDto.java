package com.techYash_bit.BankingSystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private int accno;
    private String accnm;
    private String acctype;
    private  int balance;

}
