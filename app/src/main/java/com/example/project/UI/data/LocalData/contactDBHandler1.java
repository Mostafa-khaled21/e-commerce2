package com.example.project.UI.data.LocalData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class contactDBHandler1 extends SQLiteOpenHelper {

    private static final String DB_NAME="CART";
    private static final int DB_VERSION= 1;
    private static final String TD_NAME="Contact";
    private static final String PRICE_COL="PRICE";
    private static final String NAME_COL="NAME";



    public contactDBHandler1(@Nullable Context context ) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+ TD_NAME + "("
                +NAME_COL+ " TEXT ,"
                +PRICE_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TD_NAME);
        onCreate(db);
    }
    public void addContact(String name,String price){
        SQLiteDatabase dp = this.getWritableDatabase();
        ContentValues v= new ContentValues();
        v.put(NAME_COL,name);
        v.put(PRICE_COL,price);
        dp.insert(TD_NAME,null,v);
        dp.close();

    }
    public Cursor getContact(){
        Log.d("anss","DB0");
        String query ="SELECT * FROM "+TD_NAME;
        Log.d("anss","DB1");
        SQLiteDatabase dp=this.getReadableDatabase();
        Cursor cursor=null;
        Log.d("anss","DB2");
        cursor=dp.rawQuery(query,null);
        Log.d("anss","DB3" + cursor);

        return cursor;
    }


}
