package com.ds.product.mapper;

import com.ds.product.dto.CategoryDto;
import com.ds.product.entity.CategoryEntity;

public class CategoryMapper {
    public CategoryEntity toEntity(CategoryDto categoryDto) {
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }
}
