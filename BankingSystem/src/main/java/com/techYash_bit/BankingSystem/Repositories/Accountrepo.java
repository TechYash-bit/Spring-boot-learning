package com.techYash_bit.BankingSystem.Repositories;

import com.techYash_bit.BankingSystem.Entities.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface Accountrepo extends JpaRepository<AccountEntity,Integer> {
    List<AccountEntity> findByAcctype(String acctype);

    Page<AccountEntity> findByAcctype(String acctype, Pageable page);
}
