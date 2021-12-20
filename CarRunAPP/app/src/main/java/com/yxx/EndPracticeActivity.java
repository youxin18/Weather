package com.yxx.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yxx.examapp.MainActivity;
import com.yxx.examapp.MathActivity;
import com.yxx.R;

public class EndPracticeActivity extends AppCompatActivity {
    private Button again;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_practice);
        again=findViewById(R.id.again);
        exit=findViewById(R.id.exit);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EndPracticeActivity.this, MathActivity.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EndPracticeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}