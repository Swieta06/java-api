package com.petsQu.Lsp.service;

import com.petsQu.Lsp.dto.ProductDto;
import com.petsQu.Lsp.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductDto saveProductToDB(MultipartFile file, String name, int price, String desc);
}
