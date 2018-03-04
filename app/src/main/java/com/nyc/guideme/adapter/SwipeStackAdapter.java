package com.nyc.guideme.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;

import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class SwipeStackAdapter extends BaseAdapter {
    private TextView businessTitle, civicTitle, divisionWorkUnit,
            salaryFrom, salaryTo, salaryFrequency, jobCategory,
            workLocation, fpIndicator, jobDescription, minimumQualification,
            residencyReq, postUntil, postingDate, preferredSkills;
    private List<JobModels> jobModels;

    public SwipeStackAdapter(List<JobModels> jobModels) {
        this.jobModels = jobModels;
    }

    @Override
    public int getCount() {
        return jobModels.size();
    }

    @Override
    public JobModels getItem(int position) {
        return jobModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_job_details, parent, false);
        }
        initViews(convertView);
        setViews(jobModels, position);
        return convertView;
    }

    private void initViews(View convertView) {
        businessTitle = convertView.findViewById(R.id.business_title_details);
        civicTitle = convertView.findViewById(R.id.civic_title_details);
        divisionWorkUnit = convertView.findViewById(R.id.division_work_unit_details);
        salaryFrom = convertView.findViewById(R.id.salary_from_details);
        salaryTo = convertView.findViewById(R.id.salary_to_details);
        salaryFrequency = convertView.findViewById(R.id.salary_frequency_detail);
        jobCategory = convertView.findViewById(R.id.job_category_details);
        workLocation = convertView.findViewById(R.id.work_location_details);
        fpIndicator = convertView.findViewById(R.id.full_part_indicator_details);
        jobDescription = convertView.findViewById(R.id.job_description_details);
        minimumQualification = convertView.findViewById(R.id.minimum_req_details);
        residencyReq = convertView.findViewById(R.id.residency_req_details);
        postUntil = convertView.findViewById(R.id.post_until_details);
        postingDate = convertView.findViewById(R.id.post_date_details);
        preferredSkills = convertView.findViewById(R.id.prefered_skills_details);
    }

    private void setViews(List<JobModels> jobModels, int position) {
        JobModels job = jobModels.get(position);
        businessTitle.setText(job.getBusiness_title());
        civicTitle.setText(job.getCivil_service_title());
        divisionWorkUnit.setText(job.getDivision_work_unit());
        salaryFrom.setText(job.getSalary_range_from());
        salaryTo.setText(job.getSalary_range_to());
        salaryFrequency.setText(job.getSalary_frequency());
        jobCategory.setText(job.getJob_category());
        workLocation.setText(job.getWork_location());
        fpIndicator.setText(job.getFull_time_part_time_indicator());
        minimumQualification.setText(job.getMinimum_qual_requirements());
        residencyReq.setText(job.getResidency_requirement());
        postUntil.setText(job.getPost_until());
        postingDate.setText(job.getPosting_date());
        preferredSkills.setText(job.getPreferred_skills());
    }

}
