package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.view.StatsView;
import com.example.webrestaurantsite.service.StatService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class StatServiceImpl implements StatService {
   private final Map<Long, Long> detailsEntries = new LinkedHashMap<>();
   private Long entries;


    @Override
    public void onRequest(Long id) {
            if (detailsEntries.containsKey(id)){
               entries = detailsEntries.put(id, detailsEntries.get(id) + 1L);
            }else {
                detailsEntries.put(id, 1L);
            }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(entries);
    }

    @Override
    public void clear() {
        entries = 0L;
    }
}
