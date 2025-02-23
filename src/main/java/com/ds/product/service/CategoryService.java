package com.ds.product.service;

import com.ds.product.dto.CategoryDto;
import com.ds.product.entity.CategoryEntity;
import com.ds.product.mapper.CategoryMapper;
import com.ds.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = new CategoryMapper();

    public CategoryEntity save(CategoryDto categoryDto) {
        CategoryEntity category = new CategoryEntity();
        category = categoryMapper.toEntity(categoryDto);
        return categoryRepository.save(category);
    }

    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found")
        );
    }

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryEntity update(Long id, CategoryDto categoryDto) {
        CategoryEntity category = findById(id);
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        CategoryEntity category = findById(id);
        categoryRepository.delete(category);
    }
}
