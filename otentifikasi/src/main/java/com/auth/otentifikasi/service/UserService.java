package com.auth.otentifikasi.service;

import com.auth.otentifikasi.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public UserDto create(UserDto userDto) throws Exception;
    List<UserDto> getAll();

    UserDto getByUsername(String username) throws Exception;

    List<UserDto> getAllAdmin();

    List<UserDto> getAllCustomer();

    //public UserDto getByUsername(String ) throws Exception;
}
