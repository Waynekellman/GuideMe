package com.nyc.guideme.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wayne Kellman on 3/3/18.
 */

public class JobsListSingleton {

    private static JobsListSingleton jobsListSingleton;
    private List<JobModels> jobModelsArrayList;
    public static JobsListSingleton getInstance() {
        if (jobsListSingleton == null) {
            jobsListSingleton = new JobsListSingleton();
            return jobsListSingleton;
        }
        return jobsListSingleton;

    }

    public void setJobModelsArrayList(List<JobModels> jobModelsArrayList) {
        this.jobModelsArrayList = jobModelsArrayList;
    }

    public List<JobModels> getJobModelsArrayList() {
        return jobModelsArrayList;
    }
}
