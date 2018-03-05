package com.nyc.guideme;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nyc.guideme.adapter.PageAdapter;

import com.nyc.guideme.fragment.FinancialAssistanceTab;
import com.nyc.guideme.fragment.JobTab;
import com.nyc.guideme.fragment.MedicalAssistanceTab;
import com.nyc.guideme.models.FoodStampOfficeModel;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements JobTab.OnFragmentInteractionListener, FinancialAssistanceTab.OnFragmentInteractionListener, MedicalAssistanceTab.OnFragmentInteractionListener, OnMapReadyCallback{

    private static final String TAG = "MainActivity";
    private GoogleMap mMap;
    private LinearLayout mapContainer;
    private Button mapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Job"));
        tabLayout.addTab(tabLayout.newTab().setText("FoodStamps"));
        tabLayout.addTab(tabLayout.newTab().setText("Medicaid"));
        final ViewPager pager = findViewById(R.id.pager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(pageAdapter);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tabLayout.getSelectedTabPosition());
                switch (tab.getPosition()){
                    case 0:
                        Log.d(TAG, "onTabSelected: " + tab.getPosition() + tab.getText());
                        break;
                    case 1:
                        Log.d(TAG, "onTabSelected: " + tab.getPosition() + tab.getText());
                        break;
                    case 2:
                        break;
                    default:
                        Log.d(TAG, "onTabSelected: " + tab.getPosition() + tab.getText());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_activity_map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        mapContainer = findViewById(R.id.map_container);
        mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mapContainer.getVisibility() == View.GONE) {
                    mapContainer.setVisibility(View.VISIBLE);
                } else {
                    mapContainer.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        LatLng jobMarker = new LatLng(40.832906,-73.90297);
        mMap.addMarker(new MarkerOptions().position(jobMarker).title("Bronx Lebanon Hospital"));
        float zoomLevel = (float) 10.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jobMarker, zoomLevel));


        LatLng jobMarker2 = new LatLng(40.81774,-73.924156);
        mMap.addMarker(new MarkerOptions().position(jobMarker2).title("Lincoln Medical and Mental Health Center"));

        LatLng jobMarker3 = new LatLng(40.880462,-73.88164);
        mMap.addMarker(new MarkerOptions().position(jobMarker3).title("North Central Bronx Hospital"));

        LatLng jobMarker4 = new LatLng(40.835957,-73.919986);
        mMap.addMarker(new MarkerOptions().position(jobMarker4).title("Morrisania"));

        LatLng jobMarker5 = new LatLng(40.683419,-73.97898);
        mMap.addMarker(new MarkerOptions().position(jobMarker5).title("Boerum Hill"));

        LatLng jobMarker6 = new LatLng(40.681962,-73.968434);
        mMap.addMarker(new MarkerOptions().position(jobMarker6).title("Brooklyn South"));

        LatLng jobMarker7 = new LatLng(40.655749,-73.944786);
        mMap.addMarker(new MarkerOptions().position(jobMarker7).title("Kings County Hospital Medicaid Office"));

        LatLng jobMarker8 = new LatLng(40.57353,-73.987448);
        mMap.addMarker(new MarkerOptions().position(jobMarker8).title("Coney Island"));

        LatLng jobMarker9 = new LatLng(40.671977,-73.895248);
        mMap.addMarker(new MarkerOptions().position(jobMarker9).title("East New York"));

        LatLng jobMarker10 = new LatLng(40.718647,-73.993586);
        mMap.addMarker(new MarkerOptions().position(jobMarker10).title("Chinatown Medicaid Office"));

        mapContainer.setVisibility(View.GONE);

    }
}
