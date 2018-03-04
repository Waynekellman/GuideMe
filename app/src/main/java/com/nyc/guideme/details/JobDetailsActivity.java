package com.nyc.guideme.details;

import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.nyc.guideme.adapter.SwipeStackAdapter;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;
import java.io.IOException;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class JobDetailsActivity extends AppCompatActivity {

    private static final String TAG = "JobDetailsActivity";
    public List<JobModels> jobModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_details_card);
        SwipeStack swipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        jobModelsList = JobsListSingleton.getInstance().getJobModelsArrayList();
        Log.d(TAG, "onCreate: " + jobModelsList.get(0).getBusiness_title());
        Log.d(TAG, "onCreate: " + String.valueOf(jobModelsList.size()));
        swipeStack.setAdapter(new SwipeStackAdapter(jobModelsList));

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
}
