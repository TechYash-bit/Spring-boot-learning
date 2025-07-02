package com.techYash_bit.BankingSystem.Services;

import com.techYash_bit.BankingSystem.Dto.AccountDto;
import com.techYash_bit.BankingSystem.Entities.AccountEntity;
import com.techYash_bit.BankingSystem.Repositories.Accountrepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    final Accountrepo accountrepo;
    private ModelMapper modelMapper;
    AccountService(Accountrepo accountrepo, ModelMapper modelMapper){
        this.accountrepo=accountrepo;
        this.modelMapper=modelMapper;
    }
    public AccountDto findAccount(int accno){
        AccountEntity accountEntity=accountrepo.findById(accno).orElse(null);
        return modelMapper.map(accountEntity,AccountDto.class);
    }
}
