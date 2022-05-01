package com.crud.crud.service.impl;

import com.crud.crud.dto.UserDto;
import com.crud.crud.model.User;
import com.crud.crud.repository.UserRepository;
import com.crud.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDto userDto) {
        User user=new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllStudent() {
        return this.userRepository.findAll();
    }

    @Override
    public void deletUserById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
    Optional<User>userOptional=this.userRepository.findById(userDto.getId());
    if (userOptional.isPresent()){
    User userExisting=userOptional.get();
    userExisting.setEmail(userDto.getEmail());
    userExisting.setName(userDto.getName());
    this.userRepository.save(userExisting);
    }
        return null;
    }

    /*@Override
    public UserDto updateUser(UserDto userDto) {
       Optional<User> optionalUser = this.userRepository.findById(userDto.getId());
       if(optionalUser.isPresent()){
          User existingUser=optionalUser.get();
          existingUser.setName(userDto.getName());
          existingUser.setEmail(userDto.getEmail());
          this.userRepository.save(existingUser);
          return userDto;

       }
        return null;
    }*/


}
