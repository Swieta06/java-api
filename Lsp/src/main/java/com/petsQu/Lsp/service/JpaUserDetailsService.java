package com.petsQu.Lsp.service;

import com.petsQu.Lsp.dto.JpaUserDetails;
import com.petsQu.Lsp.model.User;
import com.petsQu.Lsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=this.userRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException(username+"is not found"));

        return new JpaUserDetails(user);
    }
}
