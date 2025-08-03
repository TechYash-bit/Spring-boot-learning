package com.TechYash_Bit.onlineBookStore.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDto {
    private int id;
    private int userId;
    private int bookId;
    private int quantity;
    private double price;
}
