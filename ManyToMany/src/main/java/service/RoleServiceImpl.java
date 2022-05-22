package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService{
@Autowired
    private RoleRepository roleRepository;

}
