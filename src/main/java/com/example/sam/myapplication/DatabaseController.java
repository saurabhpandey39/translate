package com.example.sam.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.StringBuilderPrinter;

/**
 * Created by SAM on 5/30/2016.
 */
public class DatabaseController extends SQLiteOpenHelper {

    private String TABLE_NAME = "email_items";

    private String CREATE_TABLE = "CREATE TABLE if not exists " + TABLE_NAME + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, Email_Id TEXT, Passwd TEXT)";

    private String SELECT = "SELECT * FROM " + TABLE_NAME;

    SQLiteDatabase database;

    DatabaseController( Context context){
        super(context, "android.sqlite.db", null , 1);
        String databasePath = context.getDatabasePath("wl.db").getPath();
        Log.d("saurabh", " db = " + databasePath);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("saurabh","DatabaseController onCreate()");
        db.execSQL(CREATE_TABLE);
      //  database = this.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert( String email, String passwd) {
        Log.d("saurabh","DatabaseController insert()");
        database = this.getWritableDatabase();
        try {
            /*ContentValues values = new ContentValues();
            values.put(email, passwd);
            database.insert(TABLE_NAME, null, values);
            database.close();*/

            String query = "INSERT INTO " + TABLE_NAME + " (Email_Id,Passwd) VALUES('"+email+"', '"+passwd+"');";
            database.execSQL(query);

        }catch(Exception e) {
            Log.d("saurabh", "exception e = " + e);
        }
    }

    public int getCount(){
        Log.d("saurabh","DatabaseController getcount()");
        Cursor cursor = null;
        database = this.getWritableDatabase();
        try {
            cursor = database.rawQuery(SELECT, null);
        } catch(Exception e) {
            Log.d("saurabh", "exception e " + e);

        }

        Log.d("saurabh","DatabaseController cursor " + cursor );
        if(cursor != null){
            return cursor.getCount();
        }
        return -1;
    }

    public Cursor getData() throws SQLException{
        Log.d("saurabh","DatabaseController getData()" );
        Cursor cursor = null;
        database = this.getWritableDatabase();

        try {
            cursor = database.rawQuery(SELECT, null);
        } catch(Exception e) {
            Log.d("saurabh", "exception e " + e);
        }

        Log.d("saurabh","DatabaseController getData() cursor = " + cursor );

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}