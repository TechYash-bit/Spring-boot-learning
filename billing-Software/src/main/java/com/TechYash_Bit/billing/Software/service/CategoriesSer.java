package com.TechYash_Bit.billing.Software.service;

import com.TechYash_Bit.billing.Software.dto.CategoryRequest;
import com.TechYash_Bit.billing.Software.dto.CategoryResponse;

import java.util.List;

public interface CategoriesSer {
    CategoryResponse addCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategory();
    void delete(String categoryId);
}
