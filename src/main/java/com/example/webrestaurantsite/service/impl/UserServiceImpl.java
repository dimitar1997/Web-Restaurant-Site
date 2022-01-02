package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.RegisterBidingModel;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.RegisterServiceModel;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void addUser(RegisterBidingModel registerBidingModel) {
        RegisterServiceModel registerServiceModel = modelMapper.map(registerBidingModel, RegisterServiceModel.class);
        User user = modelMapper.map(registerServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(registerServiceModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean isUserNameFree(String username) {
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }
}
