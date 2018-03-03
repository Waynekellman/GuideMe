package com.nyc.guideme.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.utility.ISO8601Parse;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by c4q on 3/3/18.
 */

class JobViewHoler extends RecyclerView.ViewHolder {
    private TextView businessTitle, agencyTv, locationJob, jobTypeTime, salaryJob;
    private RelativeTimeTextView dueTime;

    public JobViewHoler(View itemView) {
        super(itemView);
        businessTitle = itemView.findViewById(R.id.tv_business_title);
        agencyTv = itemView.findViewById(R.id.agency_tv);
        locationJob = itemView.findViewById(R.id.location_id);
        jobTypeTime = itemView.findViewById(R.id.full_time_part_time_indicator);
        dueTime = (RelativeTimeTextView) itemView.findViewById(R.id.post_until);
        salaryJob = itemView.findViewById(R.id.salary_id);

    }

    public void onBind(JobModels jobModels) {
        businessTitle.setText(jobModels.getBusiness_title());
        agencyTv.setText(jobModels.getAgency());
        locationJob.setText(jobModels.getWork_location());

        String timeFull = null;
        if (jobModels.getFull_time_part_time_indicator().equalsIgnoreCase("f")) {
            timeFull = "Full Time ";
        } else {
            timeFull = "Part Time";
        }
        jobTypeTime.setText(timeFull);

        StringBuilder salaryBuilder = new StringBuilder(jobModels.getSalary_range_from());
        Date date = null;
        try {
            date = ISO8601Parse.parse(jobModels.getPosting_date());
            Log.d("onBind: ", date + "");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            dueTime.setReferenceTime(date.getTime());
        }
        salaryBuilder.append(" - ").append(jobModels.getSalary_range_to()).append(" $ ");
        salaryJob.setText(salaryBuilder);

    }
}
