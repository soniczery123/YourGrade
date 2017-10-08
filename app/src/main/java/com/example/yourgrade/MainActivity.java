package com.example.yourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText editName, editScore;
    Button cal, exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editText);
        editScore = (EditText) findViewById(R.id.editText2);
        cal = (Button) findViewById(R.id.button);
        exit = (Button) findViewById(R.id.button2);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(editName.getText().toString());
                String textScore = String.valueOf(editScore.getText().toString());

                if (name.length() == 0) {
                    editName.setError("ป้อนชื่อ");
                }
                if (textScore.length() == 0) {
                    editScore.setError("ป้อนคะแนน");
                }
                if(name.length() != 0 && textScore.length() != 0){
                    int score = Integer.valueOf(editScore.getText().toString());
                    String grade = calGrade(score);
                    Intent intent = new Intent(MainActivity.this, grade.class);
                    intent.putExtra("name", name);
                    intent.putExtra("grade", grade);
                    startActivity(intent);

                }



            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Comfirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ยกเลิก", null);
                dialog.setNegativeButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dialog.show();
            }
        });


    }

    String calGrade(int score) {
        if (score >= 80) {
            return "A";
        } else if (score >= 70) {
            return "B";
        } else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }
}
