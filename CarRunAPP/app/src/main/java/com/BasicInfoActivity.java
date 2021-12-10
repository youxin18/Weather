package com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.examapp.CreateDbHelper;
import com.examapp.PwdLoginActivity;
import com.examapp.R;
import com.examapp.RegisterLoginActivity;

import static com.examapp.PwdLoginActivity.input_id;

public class BasicInfoActivity extends AppCompatActivity {
    private EditText nicheng;
    private EditText nianling;
    private EditText xuexiao;
    private EditText zhiye;
    private ImageView woman;
    private ImageView man;
    private Button save;
    public static String sex;
    private String a;
    private String b;
    private String sc;
    private String ps;
    private CreateDbHelper dbHelper = new CreateDbHelper(this, "a.db", null, 1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);
        nicheng = findViewById(R.id.nicheng);
        nianling = findViewById(R.id.nianling);
        xuexiao = findViewById(R.id.xuexiao);
        zhiye = findViewById(R.id.zhiye);
        woman = findViewById(R.id.xingbie_image_woman);
        man = findViewById(R.id.xingbie_image);
        save = findViewById(R.id.baocun);


        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicInfoActivity.this,"您选择了女性",Toast.LENGTH_SHORT).show();
                sex="0";

            }
        });
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicInfoActivity.this,"您选择了男性",Toast.LENGTH_SHORT).show();
                sex="1";

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=nicheng.getText().toString();
                b=nianling.getText().toString();
                sc=xuexiao.getText().toString();
                ps=zhiye.getText().toString();

               SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                String updataName="Update user set name=? where username=?";
                String updataAge="Update user set age=? where username=?";
                String updataSex="Update user set sex=? where username=?";

                String updataUserPosition="Update user set position=? where username=?";
                String updataUserSchool="Update user set school=? where username=?";
                db.execSQL(updataName,new String[]{a,input_id});
                db.execSQL(updataAge,new String[]{b,input_id});
                db.execSQL(updataSex,new String[]{sex,input_id});
                db.execSQL(updataUserPosition,new String[]{ps,input_id});
                db.execSQL(updataUserSchool,new String[]{sc,input_id});
                //db.insert("user",null,values);
                Toast.makeText(BasicInfoActivity.this,"修改成功，请重新登录！",Toast.LENGTH_SHORT).show();




                // }
                db.close();
                Intent intent=new Intent(BasicInfoActivity.this, PwdLoginActivity.class);
                startActivity(intent);
               // checkISexist(input_id);

                  /*  String query="Update user set name=a where username=input_id";
                    db.execSQL(query);*/
                    //Toast.makeText(BasicInfoActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                   // Intent intent1=new Intent(BasicInfoActivity.this, BasicInfoActivity.class);
                    //startActivity(intent1);

               // }else if(b!=null){
                   // Toast.makeText(BasicInfoActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                   // Intent intent2=new Intent(BasicInfoActivity.this, BasicInfoActivity.class);
                   // startActivity(intent2);

               // }else if(sc!=null){

                    //Toast.makeText(BasicInfoActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                   // Intent intent3=new Intent(BasicInfoActivity.this, BasicInfoActivity.class);
                   // startActivity(intent3);
                //}else if(ps!=null){
                    //Toast.makeText(BasicInfoActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                  //  Intent intent4=new Intent(BasicInfoActivity.this, BasicInfoActivity.class);
                   // startActivity(intent4);

                //}else {

            }
        });

    }
    private boolean checkISexist(String value){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String query="Select*from user where username=?";
        Cursor cursor=db.rawQuery(query,new String[]{value});
        if(cursor.getCount()>0){
            cursor.close();
            Toast.makeText(this,"该用户名已注册，请重新输入！",Toast.LENGTH_SHORT).show();
            return true;
        }else {

            cursor.close();
           //Intent intent=new Intent(BasicInfoActivity.this, BasicInfoActivity.class);
           // startActivity(intent);
            //registerUserInfo(a, b);
           /* values=new ContentValues();

            values.put("username",iduser);
            values.put("pwd",idpwd);
            values.put("name",a);

            values.put("age",b);

            values.put("position",ps);

            values.put("school",sc);

            values.put("sex",sex);*/
            String updataName="Update user set name=? where name=?";
            String updataAge="Update user set name=? where age=?";
            String updataSex="Update user set name=? where sex=?";

            String updataUserPosition="Update user set name=? where position=?";
            String updataUserSchool="Update user set name=? where school=?";
            db.execSQL(updataName,new String[]{a,input_id});
            db.execSQL(updataAge,new String[]{b,input_id});
            db.execSQL(updataSex,new String[]{sex,input_id});
            db.execSQL(updataUserPosition,new String[]{ps,input_id});
            db.execSQL(updataUserSchool,new String[]{sc,input_id});
            //db.insert("user",null,values);
            Toast.makeText(this,"修改成功，请重新登录！",Toast.LENGTH_SHORT).show();




            // }
            db.close();
            Intent intent=new Intent(BasicInfoActivity.this, PwdLoginActivity.class);
            startActivity(intent);
            return false;
        }
    }

}