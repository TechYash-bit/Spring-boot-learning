package com.techYash_bit.BankingSystem.Dto;


import com.techYash_bit.BankingSystem.annotation.AccountTypeValidation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    @NotNull
    private int accno;
    @NotBlank
    private String accnm;
    @AccountTypeValidation
    private String acctype;
    @Min(1000)
    private  int balance;

}
