package com.app.shoppinglist_challenge.dao;

import java.util.List;

public interface CartDao {

    void saveItem(String item);

    List<String> getCartItems();
}
