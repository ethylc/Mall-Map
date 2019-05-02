package com.example.ethyl.mallmapproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private double latitude,longitude;
    private ArrayList<Store> storeArrayList;
    private static final int REQUEST_LOCATION = 0, REQUEST_DESTINATION = 1;
    private Store locationName, destinationName;
    private TextView mTextLocation, mTextDestination;
    private ImageView mImageL, mImageD;
    Marker locationMarker = null, destinationMarker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mTextLocation = (TextView)findViewById(R.id.textLocation);
        mTextDestination = (TextView)findViewById(R.id.textDestination);
        mImageL = (ImageView) findViewById(R.id.imageClearL);
        mImageD = (ImageView) findViewById(R.id.imageClearD);

        if (savedInstanceState != null){
            locationName = savedInstanceState.getParcelable("LOCATION_STORE");
            destinationName = savedInstanceState.getParcelable("DESTINATION_STORE");
        }

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            latitude = 0;
            longitude = 0;
            storeArrayList = null;
        } else {
            latitude = extras.getDouble("LATITUDE");
            longitude = extras.getDouble("LONGITUDE");
            storeArrayList = extras.getParcelableArrayList("STORES");
        }
        if (mMap == null){
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("LOCATION_STORE", locationName);
        outState.putParcelable("DESTINATION_STORE", destinationName);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLngBounds BOUNDARY = new LatLngBounds(
                new LatLng(latitude - 0.0018, longitude-0.0014), new LatLng(latitude+0.002, longitude-(-0.00229999999)));
        mMap.setLatLngBoundsForCameraTarget(BOUNDARY);
        LatLng mall = new LatLng(latitude, longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mall));
        mMap.setMinZoomPreference(17);
        if (locationName != null){
            setUpLocation();
            mTextLocation.setText(locationName.getStore());
        }
        if (destinationName != null){
            setUpDestination();
            mTextDestination.setText(destinationName.getStore());
        }
    }

    private void setUpLocation(){
        locationMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(locationName.getLat(),locationName.getLong())).title(locationName.getStore()));
        locationMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location));
    }

    private void setUpDestination(){
        destinationMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(destinationName.getLat(),destinationName.getLong())).title(destinationName.getStore()));
        destinationMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.destination));
    }

    public void searchClickLocation(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putParcelableArrayListExtra("STORES",storeArrayList);
        startActivityForResult(intent,REQUEST_LOCATION);
    }

    public void searchClickDestination(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putParcelableArrayListExtra("STORES",storeArrayList);
        startActivityForResult(intent,REQUEST_DESTINATION);
    }

    public void clearLocation(View view){
        mTextLocation.setText("Store you are nearby");
        locationMarker.remove();
        mImageL.setVisibility(View.INVISIBLE);

    }

    public void clearDestination(View view){
        mTextDestination.setText("Store you are looking for");
        destinationMarker.remove();
        mImageD.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode ==  REQUEST_LOCATION) {
            if (data == null) {
                return;
            }
            locationName = data.getParcelableExtra("STORE_NAME");
            if (locationMarker != null){
                locationMarker.remove();
                locationMarker = null;
            }
            setUpLocation();
            mTextLocation.setText(locationName.getStore());
            if (mTextLocation.getText() != "Store you are nearby"){
                mImageL.setVisibility(View.VISIBLE);
            }
        }
        if (requestCode ==  REQUEST_DESTINATION) {
            if (data == null) {
                return;
            }
            destinationName = data.getParcelableExtra("STORE_NAME");
            if (destinationMarker != null){
                destinationMarker.remove();
                destinationMarker = null;
            }
            setUpDestination();
            mTextDestination.setText(destinationName.getStore());
            if (mTextDestination.getText() != "Store you are looking for"){
                mImageD.setVisibility(View.VISIBLE);
            }
        }
    } //onActivityResult
}
