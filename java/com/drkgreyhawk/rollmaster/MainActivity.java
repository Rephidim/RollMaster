package com.drkgreyhawk.rollmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.drkgreyhawk.rollmaster.MESSAGE";
    public static final String RESULT_MESSAGE = "com.drkgreyhawk.rollmaster.RMESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.nodSpinner);
        makeSpinnerObj(spinner,R.array.dice_numbers_array);

        Spinner spinner1 = findViewById(R.id.todSpinner);
        makeSpinnerObj(spinner1,R.array.type_of_dice_array);
    }

    private int generateRandom() {
        Random r;
        Spinner todSpinner = findViewById(R.id.todSpinner);
        Spinner nodSpinner = findViewById(R.id.nodSpinner);
        int total = 0;
        for (int i = 0; i < Integer.parseInt(nodSpinner.getSelectedItem().toString()); i++) {
            r = new Random();
            total += r.nextInt(Integer.parseInt(todSpinner.getSelectedItem().toString())) + 1;
        }
        return total;
    }

    private String getSendableMessage() {
        Spinner tspinner = findViewById(R.id.todSpinner);
        Spinner nspinner = findViewById(R.id.nodSpinner);
        String message = "You rolled " + nspinner.getSelectedItem().toString() + " d " +
                tspinner.getSelectedItem().toString();

        return message;
    }

    private void makeSpinnerObj(Spinner spinner, int s) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, s,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getSendableMessage());
        intent.putExtra(RESULT_MESSAGE, generateRandom());
        startActivity(intent);
    }
}
