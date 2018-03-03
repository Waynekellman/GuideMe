package com.nyc.guideme.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class JobAdapter extends RecyclerView.Adapter<JobViewHoler> {


    private List<JobModels> jobList = new ArrayList<>();

    public JobAdapter(List<JobModels> jobList) {
        this.jobList = jobList;
    }

    @Override
    public JobViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_job, parent, false);
        return new JobViewHoler(view);
    }

    @Override
    public void onBindViewHolder(JobViewHoler holder, int position) {
        holder.onBind(jobList.get(position));

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
}
