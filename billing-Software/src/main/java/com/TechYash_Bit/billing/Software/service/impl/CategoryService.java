package com.TechYash_Bit.billing.Software.service.impl;

import com.TechYash_Bit.billing.Software.dto.CategoryRequest;
import com.TechYash_Bit.billing.Software.dto.CategoryResponse;
import com.TechYash_Bit.billing.Software.entity.CategoryEntity;
import com.TechYash_Bit.billing.Software.repository.CategoryRepo;
import com.TechYash_Bit.billing.Software.service.CategoriesSer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoriesSer {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        return modelMapper
                .map(categoryRepo.save(modelMapper
                        .map(categoryRequest, CategoryEntity.class)),CategoryResponse.class);
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> list=categoryRepo.findAll();
        return list
                .stream()
                .map(categoryEntity -> modelMapper
                        .map(categoryEntity,CategoryResponse.class)).toList();
    }

    @Override
    public void delete(String categoryId) {
        CategoryEntity entity=categoryRepo.findByCategoryId(categoryId)
                .orElseThrow(()->new RuntimeException("the category with id: "+categoryId+" not found"));
    categoryRepo.delete(entity);
    }
}
