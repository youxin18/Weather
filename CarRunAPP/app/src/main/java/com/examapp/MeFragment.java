package com.examapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.BasicInfoActivity;

import static com.BasicInfoActivity.sex;
import static com.examapp.PwdLoginActivity.input_id;

public class MeFragment extends Fragment {
    private Context context;
    private String username;
    private String my_age;
    private String my_school;
    private String my_sex;
    private String my_position;
    private TextView position;
    private CreateDbHelper createDbHelper;

    @SuppressLint("Range")
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.me_fragment,container,false);
        LinearLayout jianliLayout=view.findViewById(R.id.jianli);
        LinearLayout certifice=view.findViewById(R.id.wenzhang);
        TextView name=view.findViewById(R.id.name);
        TextView school=view.findViewById(R.id.my_school);
        TextView name_text=view.findViewById(R.id.names_text);
        ImageView sex=view.findViewById(R.id.sex);
        ImageView setting=view.findViewById(R.id.setting);

        position=view.findViewById(R.id.position_my);
        TextView age=view.findViewById(R.id.my_age);


        context=view.getContext();
        createDbHelper=new CreateDbHelper(context,"a.db",null,1);
        SQLiteDatabase db=createDbHelper.getWritableDatabase();
        String query="Select*from user where username=?";
        Cursor cursor=db.rawQuery(query,new String[]{input_id});

      if (cursor.moveToFirst()) {
            do {
                username=cursor.getString(cursor.getColumnIndex("name"));
                my_age=cursor.getString(cursor.getColumnIndex("age"));

                my_position=cursor.getString(cursor.getColumnIndex("position"));
                my_school=cursor.getString(cursor.getColumnIndex("school"));
                my_sex=cursor.getString(cursor.getColumnIndex("sex"));

                name.setText(username);
                name_text.setText(username);
                school.setText(my_school);
                age.setText(my_age);
                position.setText(my_position);
                if(my_sex.equals("0")){
                   sex.setImageDrawable(getResources().getDrawable(R.drawable.woman));
                }else {
                    sex.setImageDrawable(getResources().getDrawable(R.drawable.man));
                }

            } while (cursor.moveToNext());

        }
        cursor.close();

        jianliLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ResumeActivity.class);
                startActivity(intent);
            }
        });
        certifice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,certificeActivity.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BasicInfoActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
    @SuppressLint("Range")
    private void querySex(String value){
        createDbHelper=new CreateDbHelper(context,"a.db",null,1);
        SQLiteDatabase db=createDbHelper.getWritableDatabase();
        String query = "Select*from user where sex=?";
        Cursor cursor = db.rawQuery(query, new String[]{sex});
        if (cursor.moveToFirst()) {
            do {
                sex = cursor.getString(cursor.getColumnIndex("username"));
                if (sex.equals("0")) {

                }
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

}
