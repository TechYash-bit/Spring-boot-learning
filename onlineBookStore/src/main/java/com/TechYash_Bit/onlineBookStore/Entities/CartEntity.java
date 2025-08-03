package com.TechYash_Bit.onlineBookStore.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bookId",nullable = false)
    private BookEntity book;

    private int quantity;
    private double price;

    @ManyToOne()
    @JoinColumn(name = "orderId",nullable = false)
    private OrderEntity order;
}
