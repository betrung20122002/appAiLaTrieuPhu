package com.example.appailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Huongdan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huongdan);
    }

    public void luatchoi(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}