package com.petsQu.Lsp.repository;

import com.petsQu.Lsp.model.ERole;
import com.petsQu.Lsp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Optional<Role> findByName(ERole name);
}
