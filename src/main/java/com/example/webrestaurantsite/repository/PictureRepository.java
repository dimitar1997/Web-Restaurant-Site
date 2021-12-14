package com.example.webrestaurantsite.repository;

import com.example.webrestaurantsite.models.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    List<Picture> findAllByRestaurantId(long restaurant_id);
}
