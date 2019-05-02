package com.example.ethyl.mallmapproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ethyl on 2017-11-26.
 */

public class DatabaseInsert {
    private ArrayList<Mall> mMalls;
    private ArrayList<Store> mStores;
    private SQLiteDatabase mDatabase;
    private Context mContext;
    public boolean mallExists = false;

    DatabaseInsert(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new MallBaseHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getMallValues(Mall mall){
        ContentValues values = new ContentValues();
        values.put(MallDbSchema.MallTable.Cols.NAME, mall.getmMallId());
        values.put(MallDbSchema.MallTable.Cols.LAT, mall.getLat());
        values.put(MallDbSchema.MallTable.Cols.LONG, mall.getLong());
        values.put(MallDbSchema.MallTable.Cols.IMAGE, mall.getImage());
        return values;
    }

    private static ContentValues getStoreValues(Store store){
        ContentValues values = new ContentValues();
        values.put(StoreDbSchema.StoreTable.Cols.NAME, store.getStore());
        values.put(StoreDbSchema.StoreTable.Cols.MALLID, store.getMall());
        values.put(StoreDbSchema.StoreTable.Cols.LAT, store.getLat());
        values.put(StoreDbSchema.StoreTable.Cols.LONG, store.getLong());
        return values;
    }

    public void addMallToDataBase(Mall m){
        ContentValues values = getMallValues(m);
        long result = mDatabase.insert(MallDbSchema.MallTable.MALL, null, values);

        if (result == -1){
            Log.d("ADD", "FAILED");
        } else{
            Log.d("ADD", "SUCESS");
        }
        this.setMalls(this.getMalls());
    }

    public void addStoreToDataBase(Store s){
        ContentValues values = getStoreValues(s);
        long result = mDatabase.insert(StoreDbSchema.StoreTable.STORE, null, values);

        if (result == -1){
            Log.d("ADD", "FAILED");
        } else{
            Log.d("ADD", "SUCESS");
        }
        this.setStores(this.getStores());
    }

    public boolean mallCheck(){
        Cursor c = mDatabase.rawQuery("SELECT * FROM " + MallDbSchema.MallTable.MALL, null);
        if (c.moveToFirst()){
            mallExists = true;
        } else{
            mallExists = false;
        }
        return mallExists;
    }

    private MallCursorWrapper queryMalls(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                MallDbSchema.MallTable.MALL,
                null, //columns - null selects all columns
                whereClause,
                whereArgs,
                null, //group by
                null,  //having
                null  // order by
        );
        return new MallCursorWrapper(cursor);
    }

    private StoreCursorWrapper queryStores(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                StoreDbSchema.StoreTable.STORE,
                null, //columns - null selects all columns
                whereClause,
                whereArgs,
                null, //group by
                null,  //having
                null  // order by
        );
        return new StoreCursorWrapper(cursor);
    }

    public ArrayList<Mall> getMalls(){
        ArrayList<Mall> malls = new ArrayList<>();
        MallCursorWrapper cursor = queryMalls(null, null);
        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                malls.add(cursor.getMall());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        return malls;
    }

    public ArrayList<Store> getStores(){
        ArrayList<Store> stores = new ArrayList<>();
        StoreCursorWrapper cursor = queryStores(null, null);
        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                stores.add(cursor.getStore());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        return stores;
    }

    public void setMalls(ArrayList<Mall> malls) {
        mMalls = malls;
    }

    public void setStores(ArrayList<Store> stores) {
        mStores = stores;
    }

}
