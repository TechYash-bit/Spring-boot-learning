package com.techYash_bit.BankingSystem.Controller;

import com.techYash_bit.BankingSystem.Dto.AccountDto;
import com.techYash_bit.BankingSystem.Services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class Accounts {

    final private AccountService accountService;

    Accounts(AccountService accountService){
        this.accountService=accountService;
    }

    @GetMapping("/{accno}")
    public AccountDto getAccount(@PathVariable int accno){
        return accountService.findAccount(accno);
    }
}
