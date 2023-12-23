package com.example.home.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    // 数据库名称和版本
    public static final String DATABASE_NAME = "my_database.db";
    public static final int DATABASE_VERSION = 1;

    // 表名称和列名称
    public static final String TABLE_NAME = "phone";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "phone";
    public static final String COLUMN_AGE = "name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_KEYWORD = "keyword";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<String> getType(SQLiteDatabase db, String sql) {
        ArrayList<String> type = new ArrayList<String>();

        Cursor cursor=db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            type.add(cursor.getString(0));
        }
        return type;
    }

    public ArrayList<Map<String, String>> getData(SQLiteDatabase db, String sql, String[] str){
        ArrayList<Map<String, String>> children=new ArrayList<Map<String,String>>();
        Cursor cursor=db.rawQuery(sql,str);
        while(cursor.moveToNext()){
            Map<String,String> item=new HashMap<String, String>();
            item.put("name",cursor.getString(0));
            item.put("phone",cursor.getString(1));
            children.add(item);

        }
        return children;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_TYPE + " TEXT NOT NULL, "
                + COLUMN_KEYWORD + " TEXT NOT NULL, "
                + COLUMN_AGE + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_TABLE);
        init(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

    public void init(SQLiteDatabase db) {
        db.execSQL("insert into phone_tb values (null,'工商管理学院','83816813','学院号码','工商管理学院83816813')");
        db.execSQL("insert into phone_tb values (null,'会计学院','83823181','学院号码','会计学院83823181')");
        db.execSQL("insert into phone_tb values (null,'经济学院','83816532','学院号码','经济学院83816532')");
        db.execSQL("insert into phone_tb values (null,'金融学院','83816792','学院号码','金融学院83816792')");
        db.execSQL("insert into phone_tb values (null,'统计学院','83816428','学院号码','统计学院83816428')");
        db.execSQL("insert into phone_tb values (null,'信息管理学院','83983891','学院号码','信息管理学院83983891')");
        db.execSQL("insert into phone_tb values (null,'软件与通信工程学院','83845851','学院号码','软件与通信工程学院83845851')");
        db.execSQL("insert into phone_tb values (null,'钟元生教授','13367090022','老师号码','钟元生13367090022')");
        db.execSQL("insert into phone_tb values (null,'朱文强老师','13870689628','老师号码','朱文强13870689628')");
        db.execSQL("insert into phone_tb values (null,'李普聪老师','18970862951','老师号码','李普聪老师18970862951')");
        db.execSQL("insert into phone_tb values (null,'大食头','18970862952','订餐热线','大食头18970862952')");
        db.execSQL("insert into phone_tb values (null,'蜀味','18970862953','订餐热线','蜀味18970862953')");
        db.execSQL("insert into phone_tb values (null,'小四川','18970862955','订餐热线','小四川18970862955')");
    }

    // 插入数据
    public void insertData(SQLiteDatabase db, String name, int age) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);

        db.insert(TABLE_NAME, null, values);
    }

    // 查询数据
    public Cursor queryData(SQLiteDatabase db, String name) {
        String selection = COLUMN_NAME + " = ?";
        String[] args = {name};

        Cursor cursor = db.query(TABLE_NAME, null, selection, args, null, null, null);
        return cursor;
    }

    // 更新数据
    public void updateData(SQLiteDatabase db, int id, String name, int age) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);

        String selection = COLUMN_ID + " = ?";
        String[] args = {Integer.toString(id)};
        //TODO
//        db.update(TABLE_NAME, null, selection, args, values);
    }

    // 删除数据
    public void deleteData(SQLiteDatabase db, int id) {
        String selection = COLUMN_ID + " = ?";
        String[] args = {Integer.toString(id)};

        db.delete(TABLE_NAME, selection, args);
    }
}
