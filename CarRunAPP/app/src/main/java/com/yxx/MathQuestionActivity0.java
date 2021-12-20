package com.yxx.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.examapp.MathQuestionActivity1;

import static com.examapp.R.drawable.error;

public class MathQuestionActivity0 extends AppCompatActivity {
    private ImageView next;

    private CheckBox option_1;
    private CheckBox option_2;
    private CheckBox option_3;
    private CheckBox option_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_question0);
        next=findViewById(R.id.next);

        option_1=findViewById(R.id.option1);
        option_2=findViewById(R.id.option2);
        option_3=findViewById(R.id.option3);
        option_4=findViewById(R.id.option4);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MathQuestionActivity0.this, MathQuestionActivity1.class);
                startActivity(intent);
            }
        });
    }


}