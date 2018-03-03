package com.nyc.guideme;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.util.Log;

import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

import com.nyc.guideme.fragment.FinancialAssistanceTab;
import com.nyc.guideme.fragment.JobTab;
import com.nyc.guideme.fragment.MedicalAssistanceTab;

public class MainActivity extends AppCompatActivity implements JobTab.OnFragmentInteractionListener, FinancialAssistanceTab.OnFragmentInteractionListener, MedicalAssistanceTab.OnFragmentInteractionListener {

//
//    private static final String TAG = "MainActivity";
//    private RetrofitClient.JobsNetworkListener jobsNetworkListener;
//    private RetrofitClient.MedicaidNetworkListener medicaidNetworkListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Job"));
        tabLayout.addTab(tabLayout.newTab().setText("FinancialAssistance"));
        tabLayout.addTab(tabLayout.newTab().setText("MedicalAssistance"));
        final ViewPager pager = findViewById(R.id.pager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(pageAdapter);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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
