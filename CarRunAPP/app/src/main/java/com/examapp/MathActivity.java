package com.examapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MathActivity extends AppCompatActivity {
  //private RecyclerView recyclerView;
    //private List<RealQuestion>realQuestionList=new ArrayList<>();
    //private String title;
    private Button ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ready_math);
        ready=findViewById(R.id.ready_start);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent=new Intent(MathActivity.this,MathQuestionActivity0.class);
                startActivity(intent);*/
                dialog();
            }
        });
     //upMathQuestionData();
        //loadMathQuestionData();
        //recyclerView=findViewById(R.id.real_question_math);
        //LinearLayoutManager layoutManager=new LinearLayoutManager(this);
       // recyclerView.setLayoutManager(layoutManager);
       // RealQuestionAdapter adapter=new RealQuestionAdapter(realQuestionList);
       // recyclerView.setAdapter(adapter);


    }
    private void upMathQuestionData(){
        CreateMathQuestionHelper mathquestionHelper=new CreateMathQuestionHelper(MathActivity.this,"Math.db",null,1);
        SQLiteDatabase db=mathquestionHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id","1");
        values.put("title","2010年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","2");
        values.put("title","2011年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","3");
        values.put("title","2012年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","4");
        values.put("title","2013年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","5");
        values.put("title","2014年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","6");
        values.put("title","2015年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","7");
        values.put("title","2016年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","8");
        values.put("title","2017年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","9");
        values.put("title","2018年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","10");
        values.put("title","2019年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","11");
        values.put("title","2020年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","12");
        values.put("title","2021年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
    }
    @SuppressLint("Range")
  private void loadMathQuestionData() {
        CreateMathQuestionHelper mathQuestionHelper=new CreateMathQuestionHelper(this,"Math.db",null,1);
        SQLiteDatabase db= mathQuestionHelper.getWritableDatabase();
        Cursor cursor = db.query("Mathquestion", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                //title=cursor.getString(cursor.getColumnIndex("title"));
               // RealQuestion realQuestion=new RealQuestion(title);

                //realQuestionList.add(realQuestion);

            } while (cursor.moveToNext());

        }
        cursor.close();
    }
    private void dialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MathActivity.this,R.style.shareDialog);
        final AlertDialog dialog=builder
                .setView(R.layout.dialog_activity)
                .create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog.getWindow().findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),MathQuestionActivity0.class);
               startActivity(intent);
            }
        });
        dialog.getWindow().findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}