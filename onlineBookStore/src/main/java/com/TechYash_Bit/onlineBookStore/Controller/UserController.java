package com.TechYash_Bit.onlineBookStore.Controller;

import com.TechYash_Bit.onlineBookStore.Dto.BookDto;
import com.TechYash_Bit.onlineBookStore.Dto.UserDto;
import com.TechYash_Bit.onlineBookStore.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    final private UserService userService;
    UserController(UserService userService){
        this.userService=userService;
    }

@PostMapping(path = "/add")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        UserDto userDto1=userService.registerUser(userDto);
        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
//
}
}
