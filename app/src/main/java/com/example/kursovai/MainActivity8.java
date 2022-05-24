package com.example.kursovai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kursovai.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity8 extends AppCompatActivity {

    Button b1, b2, b3, b4;
    TextView quest;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    DatabaseReference reference;
    String testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        quest = (TextView) findViewById(R.id.txt1);

        Bundle arguments =getIntent().getExtras();
        testName = arguments.get("testName").toString();

        updateQuestion();
    }

    private void updateQuestion(){
        total++;
        if(total > 10){
            Intent i = new Intent(MainActivity8.this, MainActivity9.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("wrong", String.valueOf(wrong));
            startActivity(i);
        }
        else{
            reference = FirebaseDatabase.getInstance().getReference().child(testName).child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Question question = snapshot.getValue(Question.class);

                    quest.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b1.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.GREEN);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b1.setBackgroundColor(Color.RED);
                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b2.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.GREEN);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b2.setBackgroundColor(Color.RED);
                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b3.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.GREEN);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b3.setBackgroundColor(Color.RED);
                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b4.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.GREEN);
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b4.setBackgroundColor(Color.RED);
                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
    }
}