package com.example.yourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class grade extends AppCompatActivity {
    TextView textName,textGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Intent intent =  getIntent();
        String name = intent.getStringExtra("name");
        String grade = intent.getStringExtra("grade");
        textName = (TextView) findViewById(R.id.NAME);
        textGrade = (TextView) findViewById(R.id.GRADE);
        textName.setText(name);
        textGrade.setText(grade);
    }
}
