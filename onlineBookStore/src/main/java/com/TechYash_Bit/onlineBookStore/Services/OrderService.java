package com.TechYash_Bit.onlineBookStore.Services;

import com.TechYash_Bit.onlineBookStore.Dto.OrderDto;
import com.TechYash_Bit.onlineBookStore.Entities.BookEntity;
import com.TechYash_Bit.onlineBookStore.Entities.OrderEntity;
import com.TechYash_Bit.onlineBookStore.Entities.UserEntity;
import com.TechYash_Bit.onlineBookStore.Repositories.BookRepo;
import com.TechYash_Bit.onlineBookStore.Repositories.OrderRepo;
import com.TechYash_Bit.onlineBookStore.Repositories.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    final private OrderRepo orderRepo;
    final  private ModelMapper modelMapper;
    final private BookRepo bookRepo;
    final private UserRepo userRepo;

    OrderService(OrderRepo orderRepo,ModelMapper modelMapper,UserRepo userRepo,BookRepo bookRepo){
        this.orderRepo=orderRepo;
        this.modelMapper=modelMapper;
        this.bookRepo=bookRepo;
        this.userRepo=userRepo;
    }


}
