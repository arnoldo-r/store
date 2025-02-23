package com.ds.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
}
