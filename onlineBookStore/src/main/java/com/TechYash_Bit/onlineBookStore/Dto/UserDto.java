package com.TechYash_Bit.onlineBookStore.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;

    private String name;

    private String email;


    private LocalDateTime createdAt;
    private List<OrderDto> orders;
//    @JsonProperty("isAdmin")
//    private boolean isAdmin;

}
