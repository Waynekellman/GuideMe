package com.nyc.guideme.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.guideme.R;
import com.nyc.guideme.adapter.JobAdapter;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobTab extends Fragment {
    private static final String TAG = "JobsTab";
    private JobAdapter jobAdapter;
    private RecyclerView jobRecyclerView;
    private OnFragmentInteractionListener mListener;
    private RetrofitClient.JobsNetworkListener jobsNetworkListener;

    public JobTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_job_tab, container, false);
        jobRecyclerView = rootView.findViewById(R.id.job_recyle);
        LinearLayoutManager jobLayoutManger = new LinearLayoutManager(getActivity());
        jobRecyclerView.setLayoutManager(jobLayoutManger);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jobsNetworkListener = new RetrofitClient.JobsNetworkListener() {
            @Override
            public void onSuccessModel(List<JobModels> jobModels) {
                Log.d(TAG, "onSuccessModel: Jobs " + jobModels.get(0).getBusiness_title());
                Log.d(TAG, "onSuccessModel: " + jobModels.size());
                jobAdapter = new JobAdapter(jobModels);
                jobRecyclerView.setAdapter(jobAdapter);

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        };
        RetrofitClient.getInstance().setJobsNetworkListener(jobsNetworkListener);
        RetrofitClient.getInstance().getJobModel();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
