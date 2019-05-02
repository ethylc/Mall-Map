package com.example.ethyl.mallmapproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ethyl on 2017-11-23.
 */

public class Store implements Parcelable {
    private String mStoreName;
    private int mMallId;
    private double mStoreLat;
    private double mStoreLong;

    Store(String name, int id, double latitude,double longitude){
        mStoreName = name;
        mMallId = id;
        mStoreLat = latitude;
        mStoreLong = longitude;
    }

    public String getStore(){
        return mStoreName;
    }
    public int getMall(){ return mMallId; }
    public double getLat(){
        return mStoreLat;
    }
    public double getLong(){
        return mStoreLong;
    }


    public void setStore(String q){
        mStoreName = q;
    }
    public void setMall(int a){ mMallId = a; }
    public void setLat(double lat){ mStoreLat = lat; }
    public void setLong(double lon){ mStoreLong = lon; }

    public Store(Parcel in){
        this.mStoreName = in.readString();
        this.mMallId = in.readInt();
        this.mStoreLat = in.readDouble();
        this.mStoreLong = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mStoreName);
        parcel.writeInt(mMallId);
        parcel.writeDouble(mStoreLat);
        parcel.writeDouble(mStoreLong);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }
        public Store[] newArray(int size) {
            return new Store[size];
        }
    }; //Creator;
}
