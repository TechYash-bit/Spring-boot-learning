package com.techYash_bit.BankingSystem.Controller;

import com.techYash_bit.BankingSystem.Dto.AccountDto;
import com.techYash_bit.BankingSystem.Services.AccountService;
import com.techYash_bit.BankingSystem.exceptions.ResourseNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/account")
public class ManagerBankController {

    final private AccountService accountService;

    ManagerBankController(AccountService accountService){
        this.accountService=accountService;
    }

    @GetMapping("/{accno}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int accno){
        Optional<AccountDto> accountDto= accountService.findAccount(accno);
        return accountDto
                .map(accountDto1 -> ResponseEntity.ok(accountDto1))
                .orElseThrow(()-> new ResourseNotFoundException("Account not present in the bank "+accno));
    }



    @PostMapping("/addAcc")
    public ResponseEntity<AccountDto> addAccoutn(@RequestBody @Valid AccountDto accountDto){
        AccountDto accountDto1=accountService.addAccount(accountDto);
        return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(accountService.findAllRecord());
    }
    @DeleteMapping(path = "/{accno}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable int accno){

         boolean getDeleted= accountService.deleteAccountInfo(accno);
         if(getDeleted) return ResponseEntity.ok(true);
         return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{accno}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable int accno,@RequestBody @Valid AccountDto updateAccount){
        return ResponseEntity.ok(accountService.updateAccountInfo(accno,updateAccount));
    }

    @PatchMapping(path = "/{accno}")
    public ResponseEntity<AccountDto> partialUpdate(@PathVariable int accno, @RequestBody Map<String, Object> updates ){
        AccountDto accountDto= accountService.particalUpdate(accno,updates);
        if(accountDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(accountDto);
    }
}
