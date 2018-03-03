package com.nyc.guideme.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.guideme.R;
import com.nyc.guideme.models.FoodStampOfficeModel;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinancialAssistanceTab extends Fragment {

      // private RecyclerView recyclerView ;

    private static final String TAG = "FinancialAssistanceTab";
    private OnFragmentInteractionListener mListener;
    private RetrofitClient.FinancialNetworkListener financialNetworkListener;


    public FinancialAssistanceTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_financial_assistance_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        financialNetworkListener = new RetrofitClient.FinancialNetworkListener() {
            @Override
            public void onSuccessModel(List<FoodStampOfficeModel> foodStampOfficeModels) {
                Log.d(TAG, "onSuccessModel: Food " + foodStampOfficeModels.get(0).getFacility_name());

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        };

        RetrofitClient.getInstance().setFinancialNetworkListener(financialNetworkListener);
        RetrofitClient.getInstance().getFinancialModel();

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
