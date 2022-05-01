package com.crud.crud.controller;

import com.crud.crud.dto.UserDto;
import com.crud.crud.model.User;
import com.crud.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

@Autowired
    private UserService userService;

    @GetMapping("/test")
    public String cobaa(){
        return "test masuk";
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserDto userDto){
     return userService.createUser(userDto);
    }
    @GetMapping("all")
        public List<User> getAllUser(){
            List<User> getUsers=userService.getAllStudent();
            return getUsers;
    }

    //http://localhost:8080/api/v1/user/delete/1
    @DeleteMapping("/delete/{id}")
    public void deletUser(@PathVariable int id){
       this.userService.deletUserById(id);
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userDto){
     this.userService.updateUser(userDto);
        return null;
    }

}
