package com.app.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private String mOrderMessage;

    public static final String PRODUCT = "product";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        mOrderMessage = message;
        Toast.makeText(this, mOrderMessage,
                Toast.LENGTH_SHORT).show();
    }
    public void onDonutClicked(View view) {
            displayToast(getString(R.string.donut_order_message));
        }

    public void onIceCreamClicked(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void onFroyoClicked(View view) {
        displayToast(getString(R.string.froyo_order_message));
    }

    public void onCartCliked(View view) {
        intent = new Intent(this, OrderActivity.class);
        intent.putExtra(PRODUCT,mOrderMessage);
        startActivity(intent);
    }
}

