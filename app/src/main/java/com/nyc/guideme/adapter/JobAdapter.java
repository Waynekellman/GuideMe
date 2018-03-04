package com.nyc.guideme.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nyc.guideme.JobDetailsActivity;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class JobAdapter extends RecyclerView.Adapter<JobViewHoler> {


    private List<JobModels> jobList = new ArrayList<>();
    private final String TAG = "JobAdapter";

    public JobAdapter(List<JobModels> jobList) {
        this.jobList = jobList;
    }

    @Override
    public JobViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_job, parent, false);
        return new JobViewHoler(view);
    }

    @Override
    public void onBindViewHolder(final JobViewHoler holder, final int position) {
        holder.onBind(jobList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jobListJSON = new Gson().toJson(jobList);
                Intent intent = new Intent(holder.itemView.getContext(), JobDetailsActivity.class);
                Log.d(TAG, "onClick: " + jobListJSON);
                JobsListSingleton.getInstance().setJobModelsArrayList(jobList);
//                ArrayList<String> jobsStringArray = new ArrayList<>();
//                for (JobModels j : jobList) {
//                    jobsStringArray.add(new Gson().toJson(j));
//                }
////                intent.putExtra("jobDetails", jobListJSON);
//                intent.putStringArrayListExtra("jobDetails",jobsStringArray);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
}
