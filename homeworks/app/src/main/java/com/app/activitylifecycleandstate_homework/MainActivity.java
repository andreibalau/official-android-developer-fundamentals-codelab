package com.app.activitylifecycleandstate_homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer count=0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.counter_text);
        if (savedInstanceState!=null){
            textView.setText(savedInstanceState.getString("counter_text"));
            count = Integer.parseInt(savedInstanceState.getString("counter_text"));
        }
        else if(textView!=null && textView.getText().equals("")){
            textView.setText(Integer.toString(count));
        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(textView!=null && !textView.getText().equals("")){
            outState.putString("counter_text",textView.getText().toString());
        }
    }

    public void onCounterClicked(View view) {
        count++;
        if(textView!=null){
            textView.setText(Integer.toString(count));
        }
    }
}
