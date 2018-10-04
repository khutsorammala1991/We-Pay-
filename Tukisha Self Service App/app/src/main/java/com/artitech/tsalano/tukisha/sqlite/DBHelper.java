package com.artitech.tsalano.tukisha.sqlite;

/**
 * Created by solly on 2017/09/28.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "settings.db";
    public static final String MUNICIPALITIES_TABLE_NAME = "municipalities";
    public static final String MUNICIPALITIES_COLUMN_ID = "id";
    public static final String MUNICIPALITIES_COLUMN_PREVEND = "PreVend";
    public static final String MUNICIPALITIES_COLUMN_TOKEN = "Token";
    public static final String MUNICIPALITIES_COLUMN_NAME = "name";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table municipalities " +
                        "(id integer primary key, name text,prevend text,token text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS municipalities");
        onCreate(db);
    }

    public boolean insertMunicipality (String name, String prevend, String token) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("prevend", prevend);
        contentValues.put("token", token);
        db.insert("municipalities", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from municipalities where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, MUNICIPALITIES_TABLE_NAME);
        return numRows;
    }

    public boolean updateMunicipality (Integer id, String name, String prevend, String token) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("prevend", prevend);
        contentValues.put("token", token);
        db.update("municipalities", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteMunicipality (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("municipalities",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllMunicipality() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from municipalities", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(MUNICIPALITIES_TABLE_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
