package com.nyc.guideme.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.nyc.guideme.R;
import com.nyc.guideme.models.FoodStampOfficeModel;

public class FoodStampsDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FoodStampOfficeModel foodStampOfficeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stamps_details);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.financial_map_details);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        Intent intent = getIntent();
        foodStampOfficeModel = new Gson().fromJson(intent.getStringExtra("FoodStamps"), FoodStampOfficeModel.class);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng jobMarker = new LatLng(Double.parseDouble(foodStampOfficeModel.getLatitude()), Double.parseDouble(foodStampOfficeModel.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(jobMarker).title(foodStampOfficeModel.getFacility_name()));
        float zoomLevel = (float) 14.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jobMarker, zoomLevel));
    }
}
