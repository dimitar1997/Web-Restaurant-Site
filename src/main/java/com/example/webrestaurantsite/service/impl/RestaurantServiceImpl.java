package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.AddPictureBidingModel;
import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.AddPictureServiceModel;
import com.example.webrestaurantsite.models.service.AddRestaurantServiceModel;
import com.example.webrestaurantsite.models.service.RestaurantUpdateServiceModel;
import com.example.webrestaurantsite.models.view.RestaurantArticleViewModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.repository.PictureRepository;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.TownRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.PictureService;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.web.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;
    private final PictureService pictureService;
    private final PictureRepository pictureRepository;


    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository, ModelMapper modelMapper, TownRepository townRepository, PictureService pictureService, PictureRepository pictureRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.pictureService = pictureService;
        this.pictureRepository = pictureRepository;
    }


    @Override
    public RestaurantViewDetailsModel details(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new ObjectNotFoundException("Restaurant whit id " + restaurantId + "not found!"));
        RestaurantViewDetailsModel restaurantViewDetailsModel = modelMapper.map(restaurant, RestaurantViewDetailsModel.class);
        restaurantViewDetailsModel.setImgUrl(pictureRepository.findByRestaurantId(restaurantId).getImageUrl());
        restaurantViewDetailsModel.setCity(restaurant.getCity().getCity());
        return restaurantViewDetailsModel;
    }

    @Override
    public void addRestaurant(AddRestaurantBidingModel addRestaurantBidingModel, UserDetailsImpl currentUser, AddPictureBidingModel addPictureBidingModel) throws IOException {
        AddRestaurantServiceModel addRestaurantServiceModel = modelMapper.map(addRestaurantBidingModel, AddRestaurantServiceModel.class);
        Restaurant restaurant = modelMapper.map(addRestaurantServiceModel, Restaurant.class);
        User owner = userRepository.findByUsername(currentUser.getUserIdentifier());
        restaurant.setOwner(owner);
        Town town = townRepository.findByCity(addRestaurantServiceModel.getCity());
        restaurant.setCity(town);

        restaurantRepository.save(restaurant);
        AddPictureServiceModel addPictureServiceModel = modelMapper.map(addPictureBidingModel, AddPictureServiceModel.class);
        pictureService.addPicture(addPictureServiceModel, restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<RestaurantArticleViewModel> allRestaurant(UserDetailsImpl currentUser) {
        User user = userRepository.findByUsername(currentUser.getUsername());
        List<Restaurant> restaurants = restaurantRepository.findAllByOwner(user);
        List<RestaurantArticleViewModel> restaurantArticleViewModels = new ArrayList<>();

        for (Restaurant r : restaurants) {
            RestaurantArticleViewModel rAVM = modelMapper.map(r, RestaurantArticleViewModel.class);
            Picture picture = pictureRepository.findByRestaurantId(r.getId());
            rAVM.setImageUrl(picture.getImageUrl());
            restaurantArticleViewModels.add(rAVM);

        }


        return restaurantArticleViewModels;
    }

    @Override
    public RestaurantViewDetailsModel findRestaurantById(Long updateId) {
        Restaurant restaurant = restaurantRepository.findById(updateId).orElseThrow(() -> new ObjectNotFoundException("Restaurant whit id " + updateId + " not found!"));
        return modelMapper.map(restaurant, RestaurantViewDetailsModel.class);
    }

    @Override
    public void update(RestaurantUpdateServiceModel rUpdateServiceModel) {
        Restaurant restaurant = restaurantRepository.
                findById(rUpdateServiceModel.getId()).
                orElseThrow(() ->
                        new ObjectNotFoundException("Restaurant whit id " + rUpdateServiceModel.getId() + " not found!"));
        restaurant.setName(rUpdateServiceModel.getName())
                .setDescription(rUpdateServiceModel.getDescription())
                .setAddress(rUpdateServiceModel.getAddress())
                .setCapacity(rUpdateServiceModel.getCapacity());
        restaurantRepository.save(restaurant);

    }


    public boolean isOwner(String userName, Long id) {
        User user = userRepository.findByUsername(userName);
        Restaurant restaurant = restaurantRepository.getById(id);
        return user.getUsername().equals(restaurant.getOwner().getUsername());
    }
}
