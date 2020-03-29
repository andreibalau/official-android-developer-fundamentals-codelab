package com.app.activitiesandintents_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String passage;

    public static final String EXTRA_PASSAGE = "com.app.android.activitiesandintents_challenge.extra.Passage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonOneClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        passage = getResources().getString(R.string.passage_one);
        intent.putExtra(EXTRA_PASSAGE,passage);
        startActivity(intent);
    }

    public void onButtonTwoClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        passage = getResources().getString(R.string.passage_two);
        intent.putExtra(EXTRA_PASSAGE,passage);
        startActivity(intent);
    }

    public void onButtonThreeClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        passage = getResources().getString(R.string.passage_three);
        intent.putExtra(EXTRA_PASSAGE,passage);
        startActivity(intent);
    }
}
