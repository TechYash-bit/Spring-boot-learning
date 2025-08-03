package com.TechYash_Bit.onlineBookStore.Services;

import com.TechYash_Bit.onlineBookStore.Dto.UserDto;
import com.TechYash_Bit.onlineBookStore.Entities.UserEntity;
import com.TechYash_Bit.onlineBookStore.Repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final private UserRepo userRepo;
    final private ModelMapper modelMapper;
    UserService(UserRepo userRepo,ModelMapper modelMapper){
        this.userRepo=userRepo;
        this.modelMapper=modelMapper;
    }
    public UserDto registerUser(UserDto userDto) {
        UserEntity userEntity= modelMapper.map(userDto,UserEntity.class);
        if(userRepo.findByEmail(userEntity.getEmail())!=null){
          throw new RuntimeException("User with this email Already exisr");
        }
        userRepo.save(userEntity);
        return modelMapper.map(userEntity,UserDto.class);

    }
}
