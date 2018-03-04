package com.nyc.guideme.details;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;

import java.io.IOException;
import java.util.List;

import link.fls.swipestack.SwipeStack;


public class JobDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private JobModels job;
    private TextView businessTitle, civicTitle, divisionWorkUnit,
            salaryFrom, salaryTo, salaryFrequency, jobCategory,
            workLocation, fpIndicator, jobDescription, minimumQualification,
            residencyReq, postUntil, postingDate, preferredSkills, jobId;
    private ScrollView scrollView;

    private GoogleMap mMap;
    private Address location;
    private SharedPreferences sharedPreferences;
    private final String SHARED_PREF_KEY = "shaered_pref_details_activity";
    private final String TAG = "JobsDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        sharedPreferences = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);
        SwipeStack swipeStack = (SwipeStack) findViewById(R.id.swipeStack);


        Intent intent = getIntent();
        if (intent.hasExtra("jobDetails")) {
            job = new Gson().fromJson(intent.getStringExtra("jobDetails"), JobModels.class);
            Log.d(TAG, "onCreate: " + job.getBusiness_title());
            //            swipeStack.setAdapter(new SwipeStackAdapter(jobModelsTest));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.putString("jobDetails", intent.getStringExtra("jobDetails"));
        }

        if (!sharedPreferences.getString("jobDetails", "").equals("")) {
            job = new Gson().fromJson(sharedPreferences.getString("jobDetails", ""), JobModels.class);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_details);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }


        initViews();
        setViews();
    }

    private void setViews() {
        businessTitle.setText(job.getBusiness_title());
        civicTitle.setText(job.getCivil_service_title());
        divisionWorkUnit.setText(job.getDivision_work_unit());
        salaryFrom.setText(job.getSalary_range_from());
        salaryTo.setText(job.getSalary_range_to());
        salaryFrequency.setText(job.getSalary_frequency());
        jobCategory.setText(job.getJob_category());
        workLocation.setText(job.getWork_location());
        fpIndicator.setText(job.getFull_time_part_time_indicator());
        minimumQualification.setText(job.getMinimum_qual_requirements());
        residencyReq.setText(job.getResidency_requirement());
        postUntil.setText(job.getPost_until());
        postingDate.setText(job.getPosting_date());
        preferredSkills.setText(job.getPreferred_skills());
        String jobIdString = "JobID: " + job.getJob_id();
        jobId.setText(jobIdString);
        jobId.setMovementMethod(LinkMovementMethod.getInstance());
        //
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView != null) {
                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                        jobId.setVisibility(View.VISIBLE);
                        jobId.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String url = "https://a127-jobs.nyc.gov/";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        });
                        //scroll view is at bottom
                    } else {
                        jobId.setVisibility(View.INVISIBLE);
                        //scroll view is not at bottom
                    }
                }
            }
        });


        //

    }

    private void initViews() {
        businessTitle = findViewById(R.id.business_title_details);
        civicTitle = findViewById(R.id.civic_title_details);
        divisionWorkUnit = findViewById(R.id.division_work_unit_details);
        salaryFrom = findViewById(R.id.salary_from_details);
        salaryTo = findViewById(R.id.salary_to_details);
        salaryFrequency = findViewById(R.id.salary_frequency_detail);
        jobCategory = findViewById(R.id.job_category_details);
        workLocation = findViewById(R.id.work_location_details);
        fpIndicator = findViewById(R.id.full_part_indicator_details);
        jobDescription = findViewById(R.id.job_description_details);
        minimumQualification = findViewById(R.id.minimum_req_details);
        residencyReq = findViewById(R.id.residency_req_details);
        postUntil = findViewById(R.id.post_until_details);
        postingDate = findViewById(R.id.post_date_details);
        preferredSkills = findViewById(R.id.prefered_skills_details);
        jobId = findViewById(R.id.job_id_details);
        scrollView=findViewById(R.id.scrollView);
        jobId.setVisibility(View.INVISIBLE);
    }

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

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        try {
            location = getLocationFromAddress(job.getWork_location());
            LatLng jobMarker = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(jobMarker).title(job.getAgency()));
            float zoomLevel = (float) 14.0; //This goes up to 21
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jobMarker, zoomLevel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

