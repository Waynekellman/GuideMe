package com.nyc.guideme.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nyc.guideme.R;
import com.nyc.guideme.details.MedicaidTipsActivity;
import com.nyc.guideme.models.JobModels;
import com.nyc.guideme.models.MedicaidModels;
import com.nyc.guideme.network.RetrofitClient;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalAssistanceTab extends Fragment {

    private static final String TAG = "MedicaidTab";
    private Button eligibilityBt;
    private OnFragmentInteractionListener mListener;
    private RetrofitClient.MedicaidNetworkListener medicaidNetworkListener;

    public MedicalAssistanceTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_medical_assistance_tab, container, false);
        eligibilityBt = rootView.findViewById(R.id.medical_tips_bt);
        eligibilityBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MedicaidTipsActivity.class));
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicaidNetworkListener = new RetrofitClient.MedicaidNetworkListener() {
            @Override
            public void onSuccessModel(List<MedicaidModels> medicaidModels) {

                Log.d(TAG, "onSuccessModel: Medicaid " + medicaidModels.get(0).getAddress());
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


//    public void eligibilityOnClick(View view) {
//
//    }

}
