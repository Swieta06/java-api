package com.petsQu.Lsp.service.impl;

import com.petsQu.Lsp.dto.RoleDto;
import com.petsQu.Lsp.model.ERole;
import com.petsQu.Lsp.model.Role;
import com.petsQu.Lsp.repository.RoleRepository;
import com.petsQu.Lsp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleDto create(RoleDto roleDto) throws Exception {
        Role role=new Role();
        ERole name;

        //validation to avoid unknown role
        if(roleDto.getName().equalsIgnoreCase("admin")){
            role.setName(ERole.ROLE_ADMIN);
            name=ERole.ROLE_ADMIN;
        }else if (roleDto.getName().equalsIgnoreCase("customer")){
            role.setName(ERole.ROLE_CUSTOMER);
            name=ERole.ROLE_CUSTOMER;
        }else {
            throw  new Exception(roleDto.getName()+"is unknown");

        }
        // validation to avoid duplicate
        Optional<Role> roleOptional= roleRepository.findByName(name);
        if (roleOptional.isPresent()){
            throw  new Exception(roleDto.getName()+" has duplicate in database");
        }

        Role roleSave= roleRepository.save(role);
        RoleDto newRoleDto=new RoleDto();
        newRoleDto.setId(roleSave.getId());
        newRoleDto.setName(roleSave.getName().name());
        return newRoleDto;
    }
}
