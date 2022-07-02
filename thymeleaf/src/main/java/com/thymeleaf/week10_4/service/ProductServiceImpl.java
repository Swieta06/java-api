package com.thymeleaf.week10_4.service;

import com.thymeleaf.week10_4.dto.ProductDto;
import com.thymeleaf.week10_4.entity.Product;
import com.thymeleaf.week10_4.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<ProductDto> getAll() {
        List<Product> productList = this.productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productList) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        List<Product> productList = this.productRepository.findByNameAndCategory(productDto.getName(), productDto.getCategory());
        if (productList.isEmpty()) {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            this.productRepository.save(product);
        }
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.productRepository.save(product);
    }

    @Override
    public ProductDto updateProductForm(Long id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        ProductDto productDto = new ProductDto();

        if (productOptional.isPresent()) {
            BeanUtils.copyProperties(productOptional.get(), productDto);
        }
        return productDto;
    }

    @Override
    public void deleteProduct(Long productId) {
        this.productRepository.deleteById(productId);
    }
}
