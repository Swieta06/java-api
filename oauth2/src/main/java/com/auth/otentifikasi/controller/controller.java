package com.auth.otentifikasi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class controller {


    public String home(){
        return "home page";
    }
}
