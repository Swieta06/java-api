package com.auth.otentifikasi.service.impl;

import com.auth.otentifikasi.dto.UserDto;
import com.auth.otentifikasi.model.ERole;
import com.auth.otentifikasi.model.Role;
import com.auth.otentifikasi.model.User;
import com.auth.otentifikasi.repository.RoleRepository;
import com.auth.otentifikasi.repository.UserRepository;
import com.auth.otentifikasi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    //add field bcrypt(jwt)
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto create(UserDto userDto) throws Exception {
        ERole name;
        if(userDto.getRoles().equalsIgnoreCase("admin")){
            name=ERole.ROLE_ADMIN;
        }else if(userDto.getRoles().equalsIgnoreCase("customer")){
            name=ERole.ROLE_CUSTOMER;
        }else {
            throw  new Exception(userDto.getRoles()+"is unknown");
        }

        Role role=this.roleRepository.findByName(name).orElseThrow(()->{
            return new Exception(name.name()+"Cannot found In database");
        });

        Set<Role> roles=new HashSet<>();
        roles.add(role);

        User user =new User();
        user.setUsername(userDto.getUsername());

        //add bcrypt to set password
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        //---------------------------//

        user.setEmail(userDto.getEmail());
        user.setRoles(roles);

        User userSave=this.userRepository.save(user);
        userDto.setId(userSave.getId());
        //to encrypt in postman
        //userDto.setPassword(user.getPassword());
        //give null pass in frontend
        userDto.setPassword(null);
        return userDto;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList=this.userRepository.findAll();
        List<UserDto> userDtoList=new ArrayList<>();
         for (User user:userList){

             UserDto dto=new UserDto();
             dto.setEmail(user.getEmail());
             dto.setUsername(user.getUsername());
             dto.setPassword(user.getPassword());
             dto.setId(user.getId());

             List<Role>roles=new ArrayList<>(user.getRoles());
             dto.setRoles(roles.get(0).getName().name());

             userDtoList.add(dto);
         }
        return userDtoList;
    }

    @Override
    public UserDto getByUsername(String username) throws Exception {
        User user= this.userRepository.findByUsername(username).orElseThrow(()-> new Exception(username+"not found"));
        UserDto dto=new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        List<Role>roleList=new ArrayList(user.getRoles());
        dto.setRoles(roleList.get(0).getName().name());

        return dto;
    }

    @Override
    public List<UserDto> getAllAdmin() {
        List<User> userList=this.userRepository.findAll();
        List<UserDto> userDtoList=new ArrayList<>();
        for (User user:userList){

            UserDto dto=new UserDto();
            dto.setEmail(user.getEmail());
            dto.setUsername(user.getUsername());
            dto.setPassword(user.getPassword());
            dto.setId(user.getId());

            List<Role>roles=new ArrayList<>(user.getRoles());
            dto.setRoles(roles.get(0).getName().name());

            //make validation
            if(roles.get(0).getName().name().equalsIgnoreCase("ROLE_ADMIN")) {
                userDtoList.add(dto);
            }
        }
        return userDtoList;
    }

    @Override
    public List<UserDto> getAllCustomer() {
        List<User> userList=this.userRepository.findAll();
        List<UserDto> userDtoList=new ArrayList<>();
        for (User user:userList){

            UserDto dto=new UserDto();
            dto.setEmail(user.getEmail());
            dto.setUsername(user.getUsername());
            dto.setPassword(user.getPassword());
            dto.setId(user.getId());

            List<Role>roles=new ArrayList<>(user.getRoles());
            dto.setRoles(roles.get(0).getName().name());

            if(roles.get(0).getName().name().equalsIgnoreCase("ROLE_CUSTOMER")) {
                userDtoList.add(dto);
            }
        }
        return userDtoList;
    }

   /* @Override
    public UserDto getByUsername(String username) throws Exception {
        User user=this.userRepository.findbyName(username).orElseThrow(()->new Exception(username+"not found"));


        UserDto dto =new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        //string dengan balikan set<list>
        List<Role>roleList=new ArrayList(user.getRoles());
        dto.setRoles(roleList.get(0).getName().name());


        return dto;
    }*/
}
