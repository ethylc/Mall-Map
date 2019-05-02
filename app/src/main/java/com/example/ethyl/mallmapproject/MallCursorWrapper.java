package com.example.ethyl.mallmapproject;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by Ethyl on 2017-11-25.
 */

public class MallCursorWrapper extends CursorWrapper {
    public MallCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Mall getMall(){
        String id = getString(getColumnIndex(MallDbSchema.MallTable.Cols.NAME));
        double lat = getDouble(getColumnIndex(MallDbSchema.MallTable.Cols.LAT));
        double lon = getDouble(getColumnIndex(MallDbSchema.MallTable.Cols.LONG));
        String image = getString(getColumnIndex(MallDbSchema.MallTable.Cols.IMAGE));

        Mall mall = new Mall(id,lat,lon,image);
        return mall;
    }
}
