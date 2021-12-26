package com.example.webrestaurantsite.repository;

import com.example.webrestaurantsite.models.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
Town findByCity(String name);
}
