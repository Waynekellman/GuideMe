package com.nyc.guideme.network;

import com.nyc.guideme.models.FoodStampOfficeModel;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;


/**
 * Created by Wayne Kellman on 3/3/18.
 */

public class RetrofitClient {
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private JobsNetworkListener jobsNetworkListener = null;
    private MedicaidNetworkListener medicaidNetworkListener = null;
    private FinancialNetworkListener financialNetworkListener = null;


    public static RetrofitClient getInstance() {

        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
            return retrofitClient;
        }
        return retrofitClient;
    }
    public void setJobsNetworkListener(JobsNetworkListener jobsNetworkListener) {
        this.jobsNetworkListener = jobsNetworkListener;
    }

    public void setMedicaidNetworkListener(MedicaidNetworkListener medicaidNetworkListener) {
        this.medicaidNetworkListener = medicaidNetworkListener;
    }

    public void setFinancialNetworkListener(FinancialNetworkListener financialNetworkListener) {
        this.financialNetworkListener = financialNetworkListener;
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
                jobsNetworkListener.onSuccessModel(response.body());
            }

            @Override
            public void onFailure(Call<List<JobModels>> call, Throwable t) {
                jobsNetworkListener.onFailure(t);
            }
        });
    }

    public void getMedicaidModel() {

        NYCJobService service = buildRetrofit().create(NYCJobService.class);
        Call<List<MedicaidModels>> getMedicaidModels = service.getMedicaidModels();
        getMedicaidModels.enqueue(new Callback<List<MedicaidModels>>() {
            @Override
            public void onResponse(Call<List<MedicaidModels>> call, Response<List<MedicaidModels>> response) {
                medicaidNetworkListener.onSuccessModel(response.body());

            }

            @Override
            public void onFailure(Call<List<MedicaidModels>> call, Throwable t) {
                medicaidNetworkListener.onFailure(t);
            }
        });
    }

    public void getFinancialModel() {
        NYCJobService service = buildRetrofit().create(NYCJobService.class);
        Call<List<FoodStampOfficeModel>> getFoodModel = service.getFoodOfficeModel();
        getFoodModel.enqueue(new Callback<List<FoodStampOfficeModel>>() {
            @Override
            public void onResponse(Call<List<FoodStampOfficeModel>> call, Response<List<FoodStampOfficeModel>> response) {
                financialNetworkListener.onSuccessModel(response.body());
            }

            @Override
            public void onFailure(Call<List<FoodStampOfficeModel>> call, Throwable t) {
                financialNetworkListener.onFailure(t);
            }
        });
    }

    public interface JobsNetworkListener {
        void onSuccessModel(List<JobModels> jobModels);

        void onFailure(Throwable t);
    }

    public interface MedicaidNetworkListener {

        void onSuccessModel(List<MedicaidModels> medicaidModels);

        void onFailure(Throwable t);
    }

    public interface FinancialNetworkListener {

        void onSuccessModel(List<FoodStampOfficeModel> foodStampOfficeModels);

        void onFailure(Throwable t);
    }
}
