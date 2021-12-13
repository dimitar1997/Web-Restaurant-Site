package com.example.webrestaurantsite.repository;

import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByOwner(User owner);
}
