package com.app.shoppinglist_challenge.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.shoppinglist_challenge.R;
import com.app.shoppinglist_challenge.dao.CartDao;
import com.app.shoppinglist_challenge.dao.CartDaoImpl;

public class ItemsListActivity extends AppCompatActivity {

    private CartDao cartDao = new CartDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
    }

    public void onItemClicked(View view) {
        TextView textView = findViewById(view.getId());
        cartDao.saveItem(textView.getText().toString());
    }
}
