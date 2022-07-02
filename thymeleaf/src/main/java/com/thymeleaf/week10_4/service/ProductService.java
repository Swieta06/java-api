package com.thymeleaf.week10_4.service;

import com.thymeleaf.week10_4.dto.ProductDto;
import com.thymeleaf.week10_4.entity.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAll();

    public void saveProduct(ProductDto productDto);

    public void updateProduct(ProductDto productDto);

    public ProductDto updateProductForm(Long id);

    public void deleteProduct(Long productId);
}
