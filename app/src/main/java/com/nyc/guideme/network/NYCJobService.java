package com.nyc.guideme.network;

import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wayne Kellman on 3/3/18.
 */

public interface NYCJobService {

    @GET("resource/swhp-yxa4.json")
    Call<List<JobModels>> getJobsModels();

    @GET("resource/vydn-n796.json")
    Call<List<MedicaidModels>> getMedicaidModels();
}
