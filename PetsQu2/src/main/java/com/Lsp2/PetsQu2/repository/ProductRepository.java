package com.Lsp2.PetsQu2.repository;

import com.Lsp2.PetsQu2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByNameAndCategory(String name, String category);
}
