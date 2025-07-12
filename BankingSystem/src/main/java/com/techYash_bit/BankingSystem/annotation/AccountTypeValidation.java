package com.techYash_bit.BankingSystem.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {AccountTypeValidator.class})
public @interface AccountTypeValidation {
    String message() default "Accoutn type must be saving current salary fixed ";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}

