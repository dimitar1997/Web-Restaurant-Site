package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.view.StatsView;
import org.springframework.stereotype.Service;


public interface StatService {
    void onRequest(Long id);
   StatsView getStats();
   void clear();
}
