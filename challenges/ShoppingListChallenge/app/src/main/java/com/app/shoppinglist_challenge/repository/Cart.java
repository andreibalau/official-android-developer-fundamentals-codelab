package com.app.shoppinglist_challenge.repository;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static List<String> cartItems = new ArrayList<>();

    public List<String> getCartItems() {
        return cartItems;
    }
}
