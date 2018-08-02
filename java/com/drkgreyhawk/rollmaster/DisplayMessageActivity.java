package com.drkgreyhawk.rollmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int rmessage = intent.getIntExtra(MainActivity.RESULT_MESSAGE,0);

        TextView m1view = findViewById(R.id.msg1view);
        m1view.setText(message);

        TextView rText = findViewById(R.id.resultText);
        rText.setText("The result was " + rmessage);
    }
}
