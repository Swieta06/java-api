package com.project.example.dto;

import com.project.example.model.Addresses;
import com.project.example.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsersDto {

    private UUID id;
    private String name;
    private String email;
    private  String password;
    private  String role;
    private List<Orders> orders;
    private Addresses addresses;
}
