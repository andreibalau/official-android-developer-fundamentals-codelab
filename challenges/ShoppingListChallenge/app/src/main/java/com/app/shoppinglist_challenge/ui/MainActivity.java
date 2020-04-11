package com.app.shoppinglist_challenge.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.app.shoppinglist_challenge.R;
import com.app.shoppinglist_challenge.repository.Cart;

public class MainActivity extends AppCompatActivity {

    private ListView simpleList;
    private Cart cart;
    private EditText storeEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = findViewById(R.id.list_view);
        storeEditText = findViewById(R.id.store_editText);

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

    public void openLocation(View view) {
        if(storeEditText.equals(null)){
            return;
        }
        Uri addressUri = Uri.parse(String.format("geo:0,0?q=%s",storeEditText.getText().toString()));
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);

        if(!intent.resolveActivity(getPackageManager()).equals(null)){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
