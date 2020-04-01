package com.example.android.hellotoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView countTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String count = getIntent().getStringExtra(MainActivity.EXTRA_COUNT);
        countTextView = findViewById(R.id.count_text);
        countTextView.setText(count);
    }
}
