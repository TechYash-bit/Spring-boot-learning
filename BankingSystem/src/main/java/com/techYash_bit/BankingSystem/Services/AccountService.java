package com.techYash_bit.BankingSystem.Services;

import com.techYash_bit.BankingSystem.Dto.AccountDto;
import com.techYash_bit.BankingSystem.Entities.AccountEntity;
import com.techYash_bit.BankingSystem.Repositories.Accountrepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public AccountDto addAccount(AccountDto accountDto){
       AccountEntity accountEntity=modelMapper.map(accountDto,AccountEntity.class);
       accountrepo.save(accountEntity);
       return modelMapper.map(accountEntity,AccountDto.class);
    }
    public List<AccountDto> findAllRecord(){
        List<AccountEntity> accountEntity=accountrepo.findAll();
        return accountEntity.stream()
                .map(entity-> modelMapper.map(entity,AccountDto.class))
                .collect(Collectors.toList());
    }
}
