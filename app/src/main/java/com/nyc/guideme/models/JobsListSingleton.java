package com.nyc.guideme.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wayne Kellman on 3/3/18.
 */

public class JobsListSingleton {

    private static JobsListSingleton jobsListSingleton;
    private List<JobModels> jobModelsArrayList;
    private int position;

    public static JobsListSingleton getInstance() {
        if (jobsListSingleton == null) {
            jobsListSingleton = new JobsListSingleton();
            return jobsListSingleton;
        }
        return jobsListSingleton;

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setJobModelsArrayList(List<JobModels> jobModelsArrayList) {
        this.jobModelsArrayList = jobModelsArrayList;
    }

    public List<JobModels> getJobModelsArrayList() {
        return jobModelsArrayList;
    }
}
