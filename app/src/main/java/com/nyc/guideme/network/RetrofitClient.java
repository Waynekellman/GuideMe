package com.nyc.guideme.network;

import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;


/**
 * Created by Wayne Kellman on 3/3/18.
 */

public class RetrofitClient {
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private JobsNetworkListener jobsNetworkListener = null;
    private MedicaidNetworkListener medicaidNetworkListener = null;


    public static RetrofitClient getInstance() {

        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
            return retrofitClient;
        }
        return retrofitClient;
    }

    public JobsNetworkListener getJobsNetworkListener() {
        return jobsNetworkListener;
    }

    public void setJobsNetworkListener(JobsNetworkListener jobsNetworkListener) {
        this.jobsNetworkListener = jobsNetworkListener;
    }

    public MedicaidNetworkListener getMedicaidNetworkListener() {
        return medicaidNetworkListener;
    }

    public void setMedicaidNetworkListener(MedicaidNetworkListener medicaidNetworkListener) {
        this.medicaidNetworkListener = medicaidNetworkListener;
    }

    public Retrofit buildRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://data.cityofnewyork.us/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
        return retrofit;
    }

    public void getJobModel() {
        NYCJobService service = buildRetrofit().create(NYCJobService.class);
        Call<JobModels> getJobsModel = service.getJobsModels();
        getJobsModel.enqueue(new Callback<JobModels>() {
            @Override
            public void onResponse(Call<JobModels> call, Response<JobModels> response) {
                if (response.isSuccessful()) {
                    Log.d("onResponse: ", "Successful");

                    if (jobsNetworkListener != null) {
                        jobsNetworkListener.onSuccesModel(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<JobModels> call, Throwable t) {
                jobsNetworkListener.onFailure(t);
            }
        });
    }

    public void getMedicaidModel() {

        NYCJobService service = buildRetrofit().create(NYCJobService.class);
        Call<MedicaidModels> getMedicaidModels = service.getMedicaidModels();
        getMedicaidModels.enqueue(new Callback<MedicaidModels>() {
            @Override
            public void onResponse(Call<MedicaidModels> call, Response<MedicaidModels> response) {

            }

            @Override
            public void onFailure(Call<MedicaidModels> call, Throwable t) {

            }
        });
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public interface JobsNetworkListener {
        void onSuccesModel(JobModels jobModels);

        void onFailure(Throwable t);
    }

    public interface MedicaidNetworkListener {

        void onSuccesModel(MedicaidModels medicaidModels);

        void onFailure(Throwable t);
    }
}
