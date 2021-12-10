package com.examapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MathQuestionActivity2 extends AppCompatActivity {
    private ImageView next2;

    private CheckBox option_1;
    private CheckBox option_2;
    private CheckBox option_3;
    private CheckBox option_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_question2);
        next2=findViewById(R.id.next2);
        option_1=findViewById(R.id.option1);
        option_2=findViewById(R.id.option2);
        option_3=findViewById(R.id.option3);
        option_4=findViewById(R.id.option4);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MathQuestionActivity2.this,MathQuestionActivity3.class);
                startActivity(intent);
            }
        });
    }


}