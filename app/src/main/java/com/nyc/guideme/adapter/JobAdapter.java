package com.nyc.guideme.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.nyc.guideme.details.JobDetailsActivity;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.JobsListSingleton;

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
                JobsListSingleton.getInstance().setPosition(position);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
}
