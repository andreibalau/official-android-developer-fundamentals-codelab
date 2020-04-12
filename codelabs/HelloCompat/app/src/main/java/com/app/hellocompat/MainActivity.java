package com.app.hellocompat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private List<String> mColorList = Arrays.asList("red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = findViewById(R.id.hello_textview);
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColorList.get(random.nextInt(20));
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int colorRes = getResources().getColor(colorResourceName, this.getTheme());
            mHelloTextView.setTextColor(colorRes);
        }
        Toast.makeText(getApplicationContext(),"Your android SDK version not supporting: getResources()",Toast.LENGTH_SHORT).show();
    }
}
