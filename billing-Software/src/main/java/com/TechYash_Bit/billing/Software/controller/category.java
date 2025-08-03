package com.TechYash_Bit.billing.Software.controller;


import com.TechYash_Bit.billing.Software.dto.CategoryRequest;
import com.TechYash_Bit.billing.Software.dto.CategoryResponse;
import com.TechYash_Bit.billing.Software.service.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
@RequiredArgsConstructor
public class category {
    private final Category category;

    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(category.addCategory(categoryRequest) ,HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAllCategory(){
        return ResponseEntity.ok(category.getAllCategory());
    }
}
