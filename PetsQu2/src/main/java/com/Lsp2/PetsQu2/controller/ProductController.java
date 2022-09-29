package com.Lsp2.PetsQu2.controller;

import com.Lsp2.PetsQu2.dto.ProductDto;
import com.Lsp2.PetsQu2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/about")
    public ModelAndView about(){
        ModelAndView modelAndView = new ModelAndView("about");
        return modelAndView;
    }
    @GetMapping("/admin")
    public ModelAndView loginAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

    @GetMapping({"/list", "/"})
    public ModelAndView getProducts() {
        ModelAndView modelAndView = new ModelAndView("productList");
        List<ProductDto> productDtoList = productService.getAll();
        modelAndView.addObject("productList", productDtoList);
        return modelAndView;
    }

    @GetMapping("/addProductForm")
    public ModelAndView addProductForm() {
        ModelAndView modelAndView = new ModelAndView("addProductForm");
        ProductDto productDto = new ProductDto();
        modelAndView.addObject("productDto", productDto);
        return modelAndView;
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute ProductDto productDto) {
        this.productService.saveProduct(productDto);
        return "redirect:/api/product/list";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute ProductDto productDto) {
        this.productService.updateProduct(productDto);
        return "redirect:/api/product/list";
    }

    @GetMapping("/updateProductForm")
    public ModelAndView updateProductForm(@RequestParam Long productId) {
        ModelAndView modelAndView = new ModelAndView("updateProductForm");
        modelAndView.addObject("productDto", productService.updateProductForm(productId));
        return modelAndView;
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);
        return "redirect:/api/product/list";
    }

}
