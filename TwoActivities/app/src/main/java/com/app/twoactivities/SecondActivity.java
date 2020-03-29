package com.app.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText mReply;
    public static final String EXTRA_REPLY = "com.app.android.twoactivities.extra.Reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReply(View view) {
        Intent replyIntent =  new Intent(this, MainActivity.class);
        mReply = findViewById(R.id.editText_second);
        replyIntent.putExtra(EXTRA_REPLY, mReply.getText().toString());
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
