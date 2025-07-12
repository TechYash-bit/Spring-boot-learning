package com.techYash_bit.BankingSystem.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class AccountTypeValidator implements ConstraintValidator<AccountTypeValidation,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        if(inputRole == null) return false;
        List<String> accType = List.of("saving", "current","fixed deposite","salary");
        return accType.contains(inputRole);
    }
}
