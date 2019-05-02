package com.example.ethyl.mallmapproject;

/**
 * Created by Ethyl on 2017-11-24.
 */

public class StoreDbSchema {
    public static final class StoreTable{
        public static final String STORE = "stores";

        public static final class Cols{
            public static final String NAME = "name";
            public static final String MALLID = "mall_id";
            public static final String LAT = "latitude";
            public static final String LONG = "longitude";
        }
    }
}
