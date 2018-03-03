package com.nyc.guideme.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.guideme.R;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalAssistanceTab extends Fragment {

    private static final String TAG = "MedicaidTab";
    private OnFragmentInteractionListener mListener;
    private RetrofitClient.MedicaidNetworkListener medicaidNetworkListener;

    public MedicalAssistanceTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medical_assistance_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicaidNetworkListener = new RetrofitClient.MedicaidNetworkListener() {
            @Override
            public void onSuccessModel(List<MedicaidModels> medicaidModels) {

                Log.d(TAG, "onSuccessModel: Jobs " + medicaidModels.get(0).getAddress());
                // TODO: Set the adapter in here
            }

            @Override
            public void onFailure(Throwable t) {

            }
        };
        RetrofitClient.getInstance().setMedicaidNetworkListener(medicaidNetworkListener);
        RetrofitClient.getInstance().getMedicaidModel();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
