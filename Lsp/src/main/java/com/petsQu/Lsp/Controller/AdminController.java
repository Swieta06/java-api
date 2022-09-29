package com.petsQu.Lsp.Controller;

import com.petsQu.Lsp.dto.ProductDto;
import com.petsQu.Lsp.dto.UserDto;
import com.petsQu.Lsp.model.Product;
import com.petsQu.Lsp.service.ProductService;
import com.petsQu.Lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<UserDto>> getAllAdmin(){
        List<UserDto>userDtoList=this.userService.getAllAdmin();
        return  new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> saveProduct(@RequestParam("file") MultipartFile file,
                                               @RequestParam("pname") String name,
                                               @RequestParam("price") int price,
                                               @RequestParam("desc") String desc)
    {
        ProductDto productdto=productService.saveProductToDB(file, name, price,desc);
        return new ResponseEntity<>(productdto, HttpStatus.CREATED);
    }
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<UserDto>>getAllCustomer(){
        List<UserDto>userDtoList=this.userService.getAllCustomer();
        return  new ResponseEntity<>(userDtoList,HttpStatus.OK);
    }
}
