package com.TechYash_Bit.onlineBookStore.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "order")
    private List<CartEntity> carts;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
    private LocalDateTime orderDate;

    private double amount;

    private  String status;

}
