package com.app.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textUriMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        textUriMessage = findViewById(R.id.text_uri_message);
        if(!textUriMessage.equals(null) && !uri.equals(null)){
            textUriMessage.setText(uri.toString());
        }
    }
}
