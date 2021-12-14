package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.RegisterBidingModel;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.RegisterServiceModel;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addUser(RegisterBidingModel registerBidingModel) {
        RegisterServiceModel registerServiceModel = modelMapper.map(registerBidingModel, RegisterServiceModel.class);
        User user = modelMapper.map(registerServiceModel, User.class);
        userRepository.save(user);
    }
}
