package com.petsQu.Lsp.service;

import com.petsQu.Lsp.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto create(UserDto userDto) throws Exception;
    List<UserDto> getAll();

    UserDto getByUsername(String username) throws Exception;

    List<UserDto> getAllAdmin();

    List<UserDto> getAllCustomer();

    //public UserDto getByUsername(String ) throws Exception;
}
