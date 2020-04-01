package com.app.activitiesandintents_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.scrollView_text);
        textView.setText(getIntent().getStringExtra(MainActivity.EXTRA_PASSAGE));
    }
}
