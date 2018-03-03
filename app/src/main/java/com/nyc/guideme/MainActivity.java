package com.nyc.guideme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//
//    private static final String TAG = "MainActivity";
//    private RetrofitClient.JobsNetworkListener jobsNetworkListener;
//    private RetrofitClient.MedicaidNetworkListener medicaidNetworkListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

//        jobsNetworkListener = new RetrofitClient.JobsNetworkListener() {
//            @Override
//            public void onSuccessModel(List<JobModels> jobModels) {
//                Log.d(TAG, "onSuccessModel: Jobs " + jobModels.get(0).getBusiness_title());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                t.printStackTrace();
//            }
//        };
//        RetrofitClient.getInstance().setJobsNetworkListener(jobsNetworkListener);
//        RetrofitClient.getInstance().getJobModel();
//
//        medicaidNetworkListener = new RetrofitClient.MedicaidNetworkListener() {
//            @Override
//            public void onSuccessModel(List<MedicaidModels> medicaidModels) {
//                Log.d(TAG, "onSuccessModel: medicaid " + medicaidModels.get(0).getAddress());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                t.printStackTrace();
//            }
//        };
//
//        RetrofitClient.getInstance().setMedicaidNetworkListener(medicaidNetworkListener);
//        RetrofitClient.getInstance().getMedicaidModel();
//
//


    }
}
