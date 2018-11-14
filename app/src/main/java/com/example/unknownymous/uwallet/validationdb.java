package com.example.unknownymous.uwallet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class validationdb {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String TABLE_NAME = "usertable";
    public static final String DB_NAME = "mydatabase";
    public static final int DB_VERSION = 1;
    public static final String DB_CREATE = "create table usertable(uniqueid integer primary key autoincrement,username text not null, password text not null)";

    DatabaseHelper dbhelper;
    Context ctx;
    SQLiteDatabase db;

    public validationdb(Context ctx)
    {
        this.ctx = ctx;
        dbhelper = new DatabaseHelper(ctx);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        public DatabaseHelper(Context ctx)
        {
            super(ctx, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {
                db.execSQL(DB_CREATE);
            }
            finally
            {

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int arg1, int arg2)
        {
            db.execSQL("DROP TABLE IF EXISTS usertable");
            onCreate(db);
        }
    }

    public validationdb open()
    {
        db = dbhelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        dbhelper.close();
    }

    public long insertData(String usern, String passw)
    {
        ContentValues content = new ContentValues();
        content.put(USERNAME, usern);
        content.put(PASSWORD, passw);
        return db.insertOrThrow(TABLE_NAME, null, content);
    }

    public Cursor showdata()
    {
        String sql = "SELECT * FROM usertable";
        return db.rawQuery(sql,null);
    }

    public void deleteContact(int id)
    {
        String sql = "DELETE FROM phonetable WHERE phoneid="+id;
        db.execSQL(sql);
    }



}