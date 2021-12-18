package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class WebRestaurantImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public WebRestaurantImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return mapToUserDetails(user);
    }

    private static UserDetails mapToUserDetails(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));
        return new UserDetailsImpl(user.getUsername(),
                user.getPassword(), grantedAuthorities);
    }
}
