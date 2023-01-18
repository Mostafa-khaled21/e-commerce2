package com.example.project.UI.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

public class MainActivity extends AppCompatActivity {
Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(MainActivity.this, onboard1.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {startActivity(intent);
            finish();}
        },3000);
    }

}