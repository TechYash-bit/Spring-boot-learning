package com.techYash_bit.BankingSystem.Controller;

import com.techYash_bit.BankingSystem.Dto.AccountDto;
import com.techYash_bit.BankingSystem.Services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class ManagerBankController {

    final private AccountService accountService;

    ManagerBankController(AccountService accountService){
        this.accountService=accountService;
    }

    @GetMapping("/{accno}")
    public AccountDto getAccount(@PathVariable int accno){
        return accountService.findAccount(accno);
    }
    @PostMapping("/addAcc")

    public AccountDto addAccoutn(@RequestBody AccountDto accountDto){
        return accountService.addAccount(accountDto);
    }
    @GetMapping("/findAll")
    public List<AccountDto> findAll(){
        return accountService.findAllRecord();
    }
}
