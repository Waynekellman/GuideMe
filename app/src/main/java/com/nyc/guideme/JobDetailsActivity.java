package com.nyc.guideme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nyc.guideme.adapter.SwipeStackAdapter;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;
import com.nyc.guideme.network.RetrofitClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import link.fls.swipestack.SwipeStack;

public class JobDetailsActivity extends AppCompatActivity {

    private static final String TAG = "JobDetailsActivity";
    public List<JobModels> jobModelsList;
    private TextView businessTitle, civicTitle, divisionWorkUnit,
            salaryFrom, salaryTo, salaryFrequency, jobCategory,
            workLocation, fpIndicator, jobDescription, minimumQualification,
            residencyReq, postUntil, postingDate, preferredSkills;

    private GoogleMap mMap;
    private Address location;
    private SharedPreferences sharedPreferences;
    private final String SHARED_PREF_KEY = "shaered_pref_details_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_details_card);
        sharedPreferences = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);
        SwipeStack swipeStack = (SwipeStack) findViewById(R.id.swipeStack);

//        Type type = new TypeToken<List<JobModels>>() {
//        }.getType();
//        Intent intent = getIntent();
//        ArrayList<String> jobsStringArray = intent.getStringArrayListExtra("jobDetails");
//        for (String s : jobsStringArray) {
//            jobModelsList.add(new Gson().fromJson(s, JobModels.class));
//        }
        jobModelsList = JobsListSingleton.getInstance().getJobModelsArrayList();
        Log.d(TAG, "onCreate: " + jobModelsList.get(0).getBusiness_title());
        Log.d(TAG, "onCreate: " + String.valueOf(jobModelsList.size()));
        swipeStack.setAdapter(new SwipeStackAdapter(jobModelsList));
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_details);
        mapFragment.getMapAsync(this);

        */

//        initViews();
//        setViews();
    }

//    private void setViews() {
//        businessTitle.setText(jobModelsList.getBusiness_title());
//        civicTitle.setText(jobModelsList.getCivil_service_title());
//        divisionWorkUnit.setText(jobModelsList.getDivision_work_unit());
//        salaryFrom.setText(jobModelsList.getSalary_range_from());
//        salaryTo.setText(jobModelsList.getSalary_range_to());
//        salaryFrequency.setText(jobModelsList.getSalary_frequency());
//        jobCategory.setText(jobModelsList.getJob_category());
//        workLocation.setText(jobModelsList.getWork_location());
//        fpIndicator.setText(jobModelsList.getFull_time_part_time_indicator());
//        minimumQualification.setText(jobModelsList.getMinimum_qual_requirements());
//        residencyReq.setText(jobModelsList.getResidency_requirement());
//        postUntil.setText(jobModelsList.getPost_until());
//        postingDate.setText(jobModelsList.getPosting_date());
//        preferredSkills.setText(jobModelsList.getPreferred_skills());
//    }
//
//    private void initViews() {
//        businessTitle = findViewById(R.id.business_title_details);
//        civicTitle = findViewById(R.id.civic_title_details);
//        divisionWorkUnit = findViewById(R.id.division_work_unit_details);
//        salaryFrom = findViewById(R.id.salary_from_details);
//        salaryTo = findViewById(R.id.salary_to_details);
//        salaryFrequency = findViewById(R.id.salary_frequency_detail);
//        jobCategory = findViewById(R.id.job_category_details);
//        workLocation = findViewById(R.id.work_location_details);
//        fpIndicator = findViewById(R.id.full_part_indicator_details);
//        jobDescription = findViewById(R.id.job_description_details);
//        minimumQualification = findViewById(R.id.minimum_req_details);
//        residencyReq = findViewById(R.id.residency_req_details);
//        postUntil = findViewById(R.id.post_until_details);
//        postingDate = findViewById(R.id.post_date_details);
//        preferredSkills = findViewById(R.id.prefered_skills_details);
//    }

    public Address getLocationFromAddress(String strAddress) throws IOException {

        Geocoder coder = new Geocoder(this);
        List<Address> address;

        address = coder.getFromLocationName(strAddress, 5);
        if (address == null) {
            return null;
        }
        Address location = address.get(0);
        location.getLatitude();
        location.getLongitude();

        return location;
    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//        mMap = googleMap;
//        try {
//            location = getLocationFromAddress(jobModelsList.getWork_location());
//            LatLng jobMarker = new LatLng(location.getLatitude(),location.getLongitude());
//            mMap.addMarker(new MarkerOptions().position(jobMarker).title(jobModelsList.getAgency()));
//            float zoomLevel = (float) 14.0; //This goes up to 21
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jobMarker, zoomLevel));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
