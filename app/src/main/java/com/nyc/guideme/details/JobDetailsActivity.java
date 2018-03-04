package com.nyc.guideme.details;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Filter;
import android.widget.Toast;

import com.nyc.guideme.adapter.SwipeStackAdapter;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;

import java.io.IOException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import link.fls.swipestack.SwipeStack;

public class JobDetailsActivity extends AppCompatActivity {

    private static final String TAG = "JobDetailsActivity";
    private CircleImageView circleImageView;
    public List<JobModels> jobModelsList;
    private SwipeStack swipeStack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_details_card);
        circleImageView = findViewById(R.id.circle_id);
        circleImageView.setVisibility(View.INVISIBLE);
        swipeStack = (SwipeStack) findViewById(R.id.swipeStack);


        swipeStack.setSwipeProgressListener(new SwipeStack.SwipeProgressListener() {
            @Override
            public void onSwipeStart(int position) {

            }

            @Override
            public void onSwipeProgress(int position, float progress) {

                if (progress >= 0) {
                    circleImageView.setVisibility(View.VISIBLE);
                    circleImageView.setBackground(getResources().getDrawable(R.drawable.applynow));
                } else if (progress < 0) {
                    circleImageView.setVisibility(View.VISIBLE);
                    circleImageView.setBackground(getResources().getDrawable(R.drawable.dismiss));
                }

            }

            @Override
            public void onSwipeEnd(int position) {
                circleImageView.setVisibility(View.INVISIBLE);
            }
        });

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
