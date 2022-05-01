package com.crud.crud.service;

import com.crud.crud.dto.UserDto;
import com.crud.crud.model.User;

import java.util.List;

public interface UserService {

   public User createUser(UserDto userDto);

   public List<User> getAllStudent();

   public  void deletUserById(int id);


    UserDto updateUser(UserDto userDto);
}
