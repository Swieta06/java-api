package com.auth.otentifikasi.controller;

import com.auth.otentifikasi.dto.UserDto;
import com.auth.otentifikasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto>create(@RequestBody UserDto userDto) throws Exception {
      try {
          UserDto dto = this.userService.create(userDto);
        return new ResponseEntity<UserDto>(dto, HttpStatus.CREATED);
      }catch (Exception e){
          return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
      }

    }
    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<UserDto>>getAllAdmin(){
        List<UserDto>userDtoList=this.userService.getAllAdmin();
        return  new ResponseEntity<>(userDtoList,HttpStatus.OK);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<UserDto>>getAllCustomer(){
       List<UserDto>userDtoList=this.userService.getAllCustomer();
    return  new ResponseEntity<>(userDtoList,HttpStatus.OK);
    }

    //?username=...
    /*@GetMapping("/getByusername")
    public  ResponseEntity<UserDto>getByUserName(@RequestParam String username)  {
        try {
            UserDto userDto=this.userService.getByUsername(username);
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }*/
    //get?username=...
    @GetMapping("/get")
    public ResponseEntity<UserDto>getByUsername(@RequestParam String username){

       try {
           UserDto userDto= this.userService.getByUsername(username);
           return new ResponseEntity<>(userDto,HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }

    }

}
