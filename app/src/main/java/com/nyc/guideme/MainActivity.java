package com.nyc.guideme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RetrofitClient.RetrofitNetworkListener retrofitNetworkListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitNetworkListener = new RetrofitClient.RetrofitNetworkListener() {

            @Override
            public void onSuccessModel(List<JobModels> jobModels) {
                Log.d(TAG, "onSuccessModel: " + jobModels.get(0).getBusiness_title());

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        };

        RetrofitClient.getInstance().setRetrofitNetworkListener(retrofitNetworkListener);
        RetrofitClient.getInstance().getJobModel();
    }
}
