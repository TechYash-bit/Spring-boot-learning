package com.TechYash_Bit.billing.Software.repository;

import com.TechYash_Bit.billing.Software.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity , Long> {
}
