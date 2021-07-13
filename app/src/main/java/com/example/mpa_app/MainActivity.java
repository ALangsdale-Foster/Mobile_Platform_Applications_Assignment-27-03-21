package com.example.mpa_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDB(View view) {
        Intent intent = new Intent(getApplicationContext(), DatabaseActivity.class);
        startActivity(intent);
    }

    public void playerOneMode(View view) {
        Intent intent = new Intent(getApplicationContext(), OnePlayerActivity.class);
        startActivity(intent);
    }

    public void playerTwoMode(View view) {
        Intent intent = new Intent(getApplicationContext(), TwoPlayerActivity.class);
        startActivity(intent);
    }
}
