package com.project.example.service.impl;

import com.project.example.repository.UsersRepository;
import com.project.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UsersRepository usersRepository;
}
