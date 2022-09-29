package com.Lsp2.PetsQu2.service.impl;

import com.Lsp2.PetsQu2.dto.ProductDto;
import com.Lsp2.PetsQu2.entity.Product;
import com.Lsp2.PetsQu2.repository.ProductRepository;
import com.Lsp2.PetsQu2.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
