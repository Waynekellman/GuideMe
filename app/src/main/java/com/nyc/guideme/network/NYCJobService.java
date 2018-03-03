package com.nyc.guideme.network;

import com.nyc.guideme.models.JobModels;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wayne Kellman on 3/3/18.
 */

public interface NYCJobService {

    @GET("resource/swhp-yxa4.json")
    Call<JobModels> getJobsModels();
}
