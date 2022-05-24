package com.example.kursovai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        TextView txt1 = (TextView) findViewById(R.id.total);
        TextView txt2 = (TextView) findViewById(R.id.correct);
        TextView txt3 = (TextView) findViewById(R.id.wrong);
        Button btn = (Button) findViewById(R.id.btnres);

        Intent i = getIntent();

        String questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("wrong");

        txt1.setText(questions);
        txt2.setText(correct);
        txt3.setText(wrong);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity9.this, MainActivity5.class);
                startActivity(i);
            }
        });

    }
}