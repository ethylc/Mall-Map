package com.example.ethyl.mallmapproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ethyl on 2017-11-23.
 */

public class Mall implements Parcelable{
    private String mMallId;
    private double mMallLat;
    private double mMallLong;
    private String mMallImage;

    public Mall(String id, double latitude,double longitude, String image){
        mMallId = id;
        mMallLat = latitude;
        mMallLong = longitude;
        mMallImage = image;
    }

    public String getmMallId(){
        return mMallId;
    }
    public double getLat(){ return mMallLat; }
    public double getLong(){
        return mMallLong;
    }
    public String getImage(){
        return mMallImage;
    }


    public Mall(Parcel in){
        this.mMallId = in.readString();
        this.mMallLat = in.readFloat();
        this.mMallLong = in.readFloat();
        this.mMallImage = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mMallId);
        parcel.writeDouble(mMallLat);
        parcel.writeDouble(mMallLong);
        parcel.writeString(mMallImage);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Mall createFromParcel(Parcel in) {
            return new Mall(in);
        }
        public Mall[] newArray(int size) {
            return new Mall[size];
        }
    }; //Creator;
}