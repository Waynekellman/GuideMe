package com.nyc.guideme.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.nyc.guideme.R;
import com.nyc.guideme.models.MedicaidModels;

public class MedicaidDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    // private fields:
    private MedicaidModels medicaidOffice;
    private GoogleMap mMap;
    private TextView medicalOfficeName, medicalOfficeAddress, medicalOfficeBorough, medicaidOfficeZipCode, medicaidOfficeNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaid_detail);


        medicalOfficeName = (TextView)findViewById(R.id.medical_office_name_tv);
        medicalOfficeAddress = (TextView)findViewById(R.id.medical_office_address_tv);
        medicalOfficeBorough = (TextView)findViewById(R.id.medicaid_office_borough_tv);
        medicaidOfficeZipCode = (TextView)findViewById(R.id.medicaid_office_zip_code_tv);
        medicaidOfficeNumber = (TextView)findViewById(R.id.medicaid_office_phonenumber_tv);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.medicaid_map_details);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        Intent intent = getIntent();
        medicaidOffice = new Gson().fromJson(intent.getStringExtra("medicaidDetails"), MedicaidModels.class);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng jobMarker = new LatLng(Double.parseDouble(medicaidOffice.getLatitude()), Double.parseDouble(medicaidOffice.getLongitude()));
        mMap.addMarker(new MarkerOptions().position(jobMarker).title(medicaidOffice.getName_of_medicaid_offices()));
        float zoomLevel = (float) 14.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jobMarker, zoomLevel));
    }
}
