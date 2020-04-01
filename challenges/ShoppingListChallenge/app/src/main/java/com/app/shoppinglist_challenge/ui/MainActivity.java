package com.app.shoppinglist_challenge.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.shoppinglist_challenge.R;
import com.app.shoppinglist_challenge.repository.Cart;

public class MainActivity extends AppCompatActivity {

    private ListView simpleList;
    private Cart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = findViewById(R.id.list_view);
        cart = new Cart();
        if(!cart.getCartItems().isEmpty()){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.textview_for_listview, R.id.text_view, cart.getCartItems());
            simpleList.setAdapter(arrayAdapter);
        }
    }

    public void onClickItemList(View view) {
        Intent intent = new Intent(this, ItemsListActivity.class);
        startActivity(intent);
    }
}
