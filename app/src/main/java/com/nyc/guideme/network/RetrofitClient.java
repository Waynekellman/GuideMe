package com.nyc.guideme.network;

import com.nyc.guideme.models.JobModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;

import java.util.List;


/**
 * Created by Wayne Kellman on 3/3/18.
 */

public class RetrofitClient {
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private RetrofitNetworkListener retrofitNetworkListener = null;


    public static RetrofitClient getInstance() {

        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
            return retrofitClient;
        }
        return retrofitClient;
    }

    public RetrofitNetworkListener getRetrofitNetworkListener() {
        return retrofitNetworkListener;
    }

    public void setRetrofitNetworkListener(RetrofitNetworkListener retrofitNetworkListener) {
        this.retrofitNetworkListener = retrofitNetworkListener;
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
        Call<List<JobModels>> getJobsModel = service.getJobsModels();
        getJobsModel.enqueue(new Callback<List<JobModels>>() {
            @Override
            public void onResponse(Call<List<JobModels>> call, Response<List<JobModels>> response) {

                if (response.isSuccessful()) {
                    Log.d("onResponse: ", "Successful");

                    if (retrofitNetworkListener != null) {
                        retrofitNetworkListener.onSuccessModel(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<JobModels>> call, Throwable t) {
                retrofitNetworkListener.onFailure(t);
            }
        });
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public interface RetrofitNetworkListener {
        void onSuccessModel(List<JobModels> jobModels);

        void onFailure(Throwable t);
    }
}
