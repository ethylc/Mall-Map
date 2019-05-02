package com.example.ethyl.mallmapproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ethyl on 2017-11-25.
 */

public class MallBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "mallBase.db";

    public MallBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + MallDbSchema.MallTable.MALL + "(" +
                " _id integer primary key autoincrement, " +
                MallDbSchema.MallTable.Cols.NAME + ", " +
                MallDbSchema.MallTable.Cols.LAT + ", " +
                MallDbSchema.MallTable.Cols.LONG + ", " +
                MallDbSchema.MallTable.Cols.IMAGE + ")");

        db.execSQL("create table " + StoreDbSchema.StoreTable.STORE + "(" +
                " _id integer primary key autoincrement, " +
                StoreDbSchema.StoreTable.Cols.NAME + ", " +
                StoreDbSchema.StoreTable.Cols.MALLID + ", " +
                StoreDbSchema.StoreTable.Cols.LAT + ", " +
                StoreDbSchema.StoreTable.Cols.LONG + ", " +
                "foreign key (" + StoreDbSchema.StoreTable.Cols.MALLID + ") references malls(_id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
