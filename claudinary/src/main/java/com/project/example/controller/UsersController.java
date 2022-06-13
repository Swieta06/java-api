package com.project.example.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.example.dto.responseDto;
import com.project.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/controller")
    public String getImage(@RequestParam("data") String data, @RequestParam(value = "file", required = false) MultipartFile file){
        try {
            System.out.println(imporFile.getName());
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dggqgo3rw",
                "api_key", "466689723189921",
                "api_secret", "_PzqcDZmcTFu0fFtKLhs1SVnRd4"));


           Map<String,Object> response = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            System.out.println("cek response");

           return (String) response.get("url");
        } catch (Exception e) {
            return null;
        }

    }
   // @GetMapping("/"){
   // }

}
