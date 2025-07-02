package com.techYash_bit.BankingSystem.Repositories;

import com.techYash_bit.BankingSystem.Entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Accountrepo extends JpaRepository<AccountEntity,Integer> {
}
