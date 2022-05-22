package com.auth.otentifikasi.repository;

import com.auth.otentifikasi.model.ERole;
import com.auth.otentifikasi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Optional<Role>findByName(ERole name);
}
