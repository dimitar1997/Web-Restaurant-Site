package com.example.webrestaurantsite.repository;

import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByOwner(User owner);
    Optional<Restaurant> findById(Long id);
    Restaurant findByOwnerUsername(String ownerUsername);
    List<Restaurant> findAllByOwner(User owner);
    List<Restaurant> findAllByCity(Town city);

}
