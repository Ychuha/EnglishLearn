package com.example.kursovai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kursovai.Model.Test;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity{

    ArrayList<String> testsName = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ListView testList;
    String testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ImageButton exitbtn = (ImageButton) findViewById(R.id.imbtm4);
        testList = (ListView) findViewById(R.id.testlist);

        updateTests();
        testList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                testList.getItemAtPosition(i);
                testName = testsName.get(i);
                Intent j = new Intent(MainActivity5.this, MainActivity7.class);
                j.putExtra("testName", testName);
                startActivity(j);
            }
        });
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity5.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }

    private void updateTests() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Tests");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Test testObj = dataSnapshot.getValue(Test.class);
                    testsName.add(testObj.getTestName());
                }
                arrayAdapter = new ArrayAdapter<String>(MainActivity5.this, android.R.layout.simple_list_item_1, testsName){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        TextView textView =(TextView)view.findViewById(android.R.id.text1);
                        textView.setSingleLine(true);
                        textView.setMaxLines(1);
                        textView.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                testList.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

