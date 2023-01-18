package com.example.project.UI.data.LocalData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class contacDBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME="FAV";
    private static final int DB_VERSION= 1;
    private static final String TD_NAME="Contacts";
    private static final String PRICE_COL="PRICE";
    private static final String NAME_COL="NAME";
    private static final String IMAGE_COL="IMAGE";





    public contacDBHandler(Context context) {super(context, DB_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query ="CREATE TABLE "+ TD_NAME + "("
                +NAME_COL+ " TEXT ,"
                +PRICE_COL + " TEXT ,"
                +IMAGE_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TD_NAME);
        onCreate(sqLiteDatabase);

    }
    public void addContact(String name,String price,String image){
        SQLiteDatabase dp = this.getWritableDatabase();
        ContentValues v= new ContentValues();
        v.put(NAME_COL,name);
        v.put(PRICE_COL,price);
        v.put(IMAGE_COL,image);
        dp.insert(TD_NAME,null,v);
        dp.close();

    }
    public Cursor getContact(){
        Log.d("anss","DB0");

        String query ="SELECT * FROM "+TD_NAME;
        Log.d("anss","DB1");

        SQLiteDatabase dp=this.getReadableDatabase();
//        Cursor cursor= dp.query(
//                TD_NAME,
//                new String[]{NAME_COL,PRICE_COL,IMAGE_COL},
//                NAME_COL + "=?",
//                new String[]{},null,null,null);
        Cursor cursor=null;

        Log.d("anss","DB2");



         cursor=dp.rawQuery(query,null);

//       contact contact=new contact(
//               cursor.getString(0),
//               cursor.getString(1),
//               cursor.getString(2));
        Log.d("anss","DB3");

        return cursor;
    }
}
