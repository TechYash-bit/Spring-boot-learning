package com.TechYash_Bit.onlineBookStore.Services;

import com.TechYash_Bit.onlineBookStore.Dto.CartDto;
import com.TechYash_Bit.onlineBookStore.Entities.BookEntity;
import com.TechYash_Bit.onlineBookStore.Entities.CartEntity;
import com.TechYash_Bit.onlineBookStore.Entities.UserEntity;
import com.TechYash_Bit.onlineBookStore.Repositories.BookRepo;
import com.TechYash_Bit.onlineBookStore.Repositories.CartRepo;
import com.TechYash_Bit.onlineBookStore.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepo cartRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public CartDto addCart(CartDto cartDto) {
        UserEntity user=userRepo.findById(cartDto.getUserId()).orElseThrow(()->new RuntimeException("User Invalid : "+cartDto.getUserId()));
        BookEntity book=bookRepo.findById(cartDto.getBookId()).orElseThrow(()-> new RuntimeException("book invalid : "+cartDto.getBookId()));

        CartEntity cart =modelMapper.map(cartDto,CartEntity.class);
        cart.setUser(user);
        cart.setBook(book);

        return modelMapper.map(cart,CartDto.class);

    }
}
