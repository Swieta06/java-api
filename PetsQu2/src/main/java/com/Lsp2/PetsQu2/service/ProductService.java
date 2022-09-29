package com.Lsp2.PetsQu2.service;

import com.Lsp2.PetsQu2.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getAll();

   public void saveProduct(ProductDto productDto);

    public void updateProduct(ProductDto productDto);

    public ProductDto updateProductForm(Long id);

    public void deleteProduct(Long productId);

}
