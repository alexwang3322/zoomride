package com.example.zoomride;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovePOJO implements Serializable {

    public List<String> ads = new ArrayList<>();
    public List<String> deliveries = new ArrayList<>();
    public List<String> items = new ArrayList<>();
    public List<String> junks = new ArrayList<>();

    public MovePOJO() {
        // Mocking data
        for (int i = 0; i < 10; i++) {
            ads.add(String.valueOf(i));
            deliveries.add(String.valueOf(i));
            items.add(String.valueOf(i));
            junks.add(String.valueOf(i));
        }
    }

    public int count() {
        return 4;
    }

    public List<String> getItem(int p) {
        return ads;
    }

    public String getTitle(int p) {
        switch (p) {
            case 0: return "Featured Ads";
            case 1: return "Delivery request";
            case 2: return "Free Items";
            default: return "Junk";
        }
    }
}
