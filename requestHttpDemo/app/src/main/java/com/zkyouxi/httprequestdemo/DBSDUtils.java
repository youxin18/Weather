package com.zkyouxi.httprequestdemo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DBUtils  {
    private volatile static DBUtils dbUtils;
    private SQLiteDatabase db;
    private Context context;
    private DBUtils.DbCreate dbCreate;
   private String name;
    private int version;
    private String sql;
    private String upgrade;
   private SQLiteDatabase database;


  static class DbCreate extends SQLiteOpenHelper{
    private String sql;
    private String upgrade;

    public DbCreate(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,String sql,String upgrade)
        {

            super(context,name,factory,version);
            this.sql=sql;
            this.upgrade=upgrade;

        }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(upgrade);
    }

}
    private DBUtils(){

    }
    //要插入数据时要先open
  public SQLiteDatabase open(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,String sql,String upgrade){
      dbCreate=new DBUtils.DbCreate (context,name,null,version,sql,upgrade);
      database=dbCreate.getWritableDatabase();
    return  database;
    }

    public  static DBUtils getInstance(){
        synchronized (DBUtils.class) {
            if (dbUtils == null) {
                dbUtils=new DBUtils();
                return dbUtils;
            }
        }
        return dbUtils;
    }





    @SuppressLint("Range")
    public Cursor query(String table,String sql){
        synchronized (dbUtils){

        Cursor cursor=database.rawQuery(sql,null);
       return cursor;
        }
    }

    public void delete(String table,String whereClause,String[]whereArgs){//GreenDao
      /*  int inde=db.delete(table,"id=?",new String[Integer.parseInt(String.valueOf(id))]);
        Log.e("--Main--","======删除了====="+inde);
        return inde;*/
        synchronized (dbUtils){

            db.delete(table,whereClause,whereArgs);
        }
    }

    public void update(String table,ContentValues values,String whereClause,String[]whereArgs){

         synchronized (dbUtils){
             database.update(table,values,whereClause,whereArgs);
         }

    }
    public  void insertData(String table,ContentValues contentValues){
    synchronized (dbUtils) {

        database.insert(table, null, contentValues);
        Log.e("--Main--", "插入数据成功");

    }
    }

}
