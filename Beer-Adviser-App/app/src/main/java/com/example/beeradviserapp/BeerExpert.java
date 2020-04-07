package com.example.beeradviserapp;

import java.util.ArrayList;
import java.util.List;

class BeerExpert {
    List<String> get_brands(String color) {
        List<String> brands = new ArrayList<>();
        if(color.equals("Amber")) {
            brands.add("Jack Amber");
            brands.add("Red More");
        } else {
            brands.add("Jale Pale Sale");
            brands.add("Gout Stout");
        }

        return brands;
    }
}
