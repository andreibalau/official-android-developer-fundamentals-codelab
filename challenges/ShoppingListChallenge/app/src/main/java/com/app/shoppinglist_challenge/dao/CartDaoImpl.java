package com.app.shoppinglist_challenge.dao;

import com.app.shoppinglist_challenge.repository.Cart;

import java.util.List;

public class CartDaoImpl implements CartDao{
    private Cart cart = new Cart();
    @Override
    public void saveItem(String item) {
        cart.getCartItems().add(item);
    }

    @Override
    public List<String> getCartItems() {
        return cart.getCartItems();
    }
}
