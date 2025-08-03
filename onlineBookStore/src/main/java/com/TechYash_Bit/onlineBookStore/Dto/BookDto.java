package com.TechYash_Bit.onlineBookStore.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private int id;

    private String title;
    private String author;
    private String description;
    private String isbn;
    private double price;
    private int quantity;
    private String category;

}
