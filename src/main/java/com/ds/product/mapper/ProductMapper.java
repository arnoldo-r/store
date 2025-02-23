package com.ds.product.mapper;

import com.ds.product.dto.ProductDto;
import com.ds.product.entity.ProductEntity;

public class ProductMapper {
    private final CategoryMapper categoryMapper = new CategoryMapper();

    public ProductEntity toEntity(ProductDto productDto) {
        ProductEntity product = new ProductEntity();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(
                categoryMapper.toEntity(productDto.getCategory())
        );
        return product;
    }
}
