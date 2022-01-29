package com.example.webrestaurantsite.web.interceptor;


import com.example.webrestaurantsite.service.StatService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DetailsStatsEntriesInterceptor implements HandlerInterceptor {
    private StatService statService;
    private Long id;

    public DetailsStatsEntriesInterceptor(StatService statService) {
        this.statService = statService;

    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          statService.onRequest(this.id);
        return true;
    }
}
