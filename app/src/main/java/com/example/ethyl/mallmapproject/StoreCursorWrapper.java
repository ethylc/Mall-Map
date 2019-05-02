package com.example.ethyl.mallmapproject;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by Ethyl on 2017-11-25.
 */

public class StoreCursorWrapper extends CursorWrapper {

    public StoreCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Store getStore(){
        String name = getString(getColumnIndex(StoreDbSchema.StoreTable.Cols.NAME));
        int id = getInt(getColumnIndex(StoreDbSchema.StoreTable.Cols.MALLID));
        double lat = getDouble(getColumnIndex(StoreDbSchema.StoreTable.Cols.LAT));
        double lon = getDouble(getColumnIndex(StoreDbSchema.StoreTable.Cols.LONG));

        Store store = new Store(name,id,lat,lon);
        return store;
    }
}
