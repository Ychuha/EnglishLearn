package com.example.kursovai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity7 extends AppCompatActivity implements View.OnClickListener{

    String testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener((View.OnClickListener) this);

        Bundle arguments =getIntent().getExtras();
        testName = arguments.get("testName").toString();
    }
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, MainActivity8.class);
        i.putExtra("testName", testName);
        startActivity(i);
    }
}