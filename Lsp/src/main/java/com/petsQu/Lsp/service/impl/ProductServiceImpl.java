package com.petsQu.Lsp.service.impl;

import com.petsQu.Lsp.dto.ProductDto;
import com.petsQu.Lsp.model.Product;
import com.petsQu.Lsp.repository.ProductRepository;
import com.petsQu.Lsp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto saveProductToDB(MultipartFile file, String name,  int price,String desc) {
        Product p = new Product();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setDescription(desc);

        p.setName(name);
        p.setPrice(price);

        Product productSave=productRepository.save(p);
        ProductDto productDto=new ProductDto();
        productDto.setId(productSave.getId());
        productDto.setName(productSave.getName());
        productDto.setPrice(productSave.getPrice());
        productDto.setImage(productSave.getImage());
        productDto.setDescription(productSave.getDescription());
        //Product product=productRepository.save(p);
        return productDto;
    }

}
