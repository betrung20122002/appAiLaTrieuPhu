package com.example.appailatrieuphu.object;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class DiemDatabase extends SQLiteOpenHelper {

    public DiemDatabase(Context context) {
        super(context, "Diem3.db", null, 1);

    }
    private static String TABLE_NAME="Diem_So";
    private static String COLUMN_ID="id";
    private static String COLUMN_TEN="ten";
    private static String COLUMN_TIEN_THUONG="tien_thuong";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+ TABLE_NAME + " ( "
                +COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +COLUMN_TEN + " TEXT NOT NULL,"
                +COLUMN_TIEN_THUONG + " BIGINT NOT NULL"
                +" )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertDiemSo(Diem diem){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_TEN,diem.getTen());
        contentValues.put(COLUMN_TIEN_THUONG,diem.getTienThuong());
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result;
    }
    public List<Diem> getTopDiem(){
        List<Diem> list=new ArrayList<>();
        int i=0;
        long k=0;
        long m=0;
        String sql="SELECT * FROM "+TABLE_NAME + " ORDER BY " +COLUMN_TIEN_THUONG +" DESC";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                //int id=cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range")
                String ten=cursor.getString(cursor.getColumnIndex(COLUMN_TEN));
                @SuppressLint("Range")
                Long tienThuong=cursor.getLong(cursor.getColumnIndex(COLUMN_TIEN_THUONG));
                k=tienThuong;
                if(k!=m){
                    i++;
                }
                Diem diem=new Diem(i,ten,tienThuong);
                if(i==12){
                    break;
                }
                cursor.moveToNext();
                list.add(diem);
                m=k;
            }
            sqLiteDatabase.close();
        }
        return list;
    }
    public List<Diem> getAllDiem(){
        List<Diem> list=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                @SuppressLint("Range")
                int id=cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range")
                String ten=cursor.getString(cursor.getColumnIndex(COLUMN_TEN));
                @SuppressLint("Range")
                Long tienThuong=cursor.getLong(cursor.getColumnIndex(COLUMN_TIEN_THUONG));
                Diem diem=new Diem(id,ten,tienThuong);
                cursor.moveToNext();
                list.add(diem);
            }
            sqLiteDatabase.close();
        }
        return list;
    }
    public boolean CheckTen(String ten){
        List<Diem> list=list=getAllDiem();
        for (Diem diem:list ){
            if(diem.getTen().equals(ten)){
                return false;
            }
        }
        return true;
    }
    public long deleteDiem(Integer id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        long result=sqLiteDatabase.delete(TABLE_NAME,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        return result;
    }

}
