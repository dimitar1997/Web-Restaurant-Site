package com.example.webrestaurantsite.models.view;

public class StatsView {
    private Long entries;

    public StatsView(Long entries) {
        this.entries = entries;
    }

    public Long getEntries() {
        return entries;
    }

    public StatsView setEntries(Long entries) {
        this.entries = entries;
        return this;
    }
}
