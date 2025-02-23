package com.ds.product.service;

import com.ds.product.dto.ProductDto;
import com.ds.product.entity.ProductEntity;
import com.ds.product.mapper.CategoryMapper;
import com.ds.product.mapper.ProductMapper;
import com.ds.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private final ProductMapper productMapper = new ProductMapper();
    private final CategoryMapper categoryMapper = new CategoryMapper();

    public ProductEntity save(ProductDto productDto) {
        ProductEntity product = productMapper.toEntity(productDto);
        return productRepository.save(product);
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity update(Long id, ProductDto productDto) {
        ProductEntity product = findById(id);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(
                categoryMapper.toEntity(productDto.getCategory())
        );
        return productRepository.save(product);
    }

    public void delete(Long id) {
        ProductEntity product = findById(id);
        productRepository.delete(product);
    }
}
