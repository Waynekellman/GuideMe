package com.nyc.guideme.models;

import java.util.List;

/**
 * Created by Wayne Kellman on 3/3/18.
 */

public class JobsListSingleton {

    private static JobsListSingleton jobsListSingleton;
    private List<JobModels> jobModelsArrayList;
    private boolean checkInit;

    public static JobsListSingleton getInstance() {
        if (jobsListSingleton == null) {
            jobsListSingleton = new JobsListSingleton();
            return jobsListSingleton;
        }
        return jobsListSingleton;

    }

    public boolean isCheckInit() {
        return checkInit;
    }

    public void setCheckInit(boolean checkInit) {
        this.checkInit = checkInit;
    }

    public void setJobModelsArrayList(List<JobModels> jobModelsArrayList) {
        this.jobModelsArrayList = jobModelsArrayList;
    }

    public List<JobModels> getJobModelsArrayList() {
        return jobModelsArrayList;
    }
}
