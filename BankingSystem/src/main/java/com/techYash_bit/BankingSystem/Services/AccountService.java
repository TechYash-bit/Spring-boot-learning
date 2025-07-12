package com.techYash_bit.BankingSystem.Services;

import com.techYash_bit.BankingSystem.Dto.AccountDto;
import com.techYash_bit.BankingSystem.Entities.AccountEntity;
import com.techYash_bit.BankingSystem.Repositories.Accountrepo;
import com.techYash_bit.BankingSystem.exceptions.ResourseNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    final Accountrepo accountrepo;
    private ModelMapper modelMapper;
    AccountService(Accountrepo accountrepo, ModelMapper modelMapper){
        this.accountrepo=accountrepo;
        this.modelMapper=modelMapper;
    }

    public Optional<AccountDto> findAccount(int accno){
        return accountrepo.findById(accno).map(accountEntity -> modelMapper.map(accountEntity,AccountDto.class));
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

    public AccountDto updateAccountInfo(int accno, AccountDto updateAccount) {

        boolean exist=existAccount(accno);
        if(!exist) throw new ResourseNotFoundException("Account not present "+ accno);

        AccountEntity accountEntity=accountrepo.findById(accno)
                 .orElseThrow(() -> new ResourseNotFoundException("Account not present " + accno));
        accountEntity.setAcctype(updateAccount.getAcctype());
        accountEntity.setAccnm(updateAccount.getAccnm());
        accountEntity.setBalance(updateAccount.getBalance());
        accountrepo.save(accountEntity);
       return  modelMapper.map(accountEntity,AccountDto.class);
    }
    public boolean existAccount(int accno){
        return accountrepo.existsById(accno);
    }

    public boolean deleteAccountInfo(int accno) {
        boolean exist=existAccount(accno);
        if(!exist) return false;
        accountrepo.deleteById(accno);
        return true;
    }

    public AccountDto particalUpdate(int accno, Map<String, Object> updaets) {
        boolean exist=existAccount(accno);
        if(!exist) return  null;
        AccountEntity accountEntity=accountrepo.findById(accno).get();
        updaets.forEach((key,value)->{
            Field field= ReflectionUtils.findField(AccountEntity.class,key);
            if(field!=null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, accountEntity, value);
            }
        });
        return modelMapper.map(accountrepo.save(accountEntity),AccountDto.class);
    }
}
