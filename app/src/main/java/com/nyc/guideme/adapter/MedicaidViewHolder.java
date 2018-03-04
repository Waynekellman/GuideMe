package com.nyc.guideme.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nyc.guideme.R;
import com.nyc.guideme.models.MedicaidModels;

/**
 * Created by c4q on 3/4/18.
 */

public class MedicaidViewHolder extends RecyclerView.ViewHolder {

    // private fields:
    private TextView medicaidOfficeName_tv, medicaidOfficeAddress_tv,officeNumber_tv, officeBorough_tv, officePostCode_tv;

    // default constructor that is the super:
    public MedicaidViewHolder(View itemView) {

        super(itemView);
        medicaidOfficeName_tv = itemView.findViewById(R.id.medical_office_name_tv);
        medicaidOfficeAddress_tv = itemView.findViewById(R.id.medical_office_address_tv);
        officeNumber_tv = itemView.findViewById(R.id.medicaid_office_phonenumber_tv);
        officeBorough_tv = itemView.findViewById(R.id.medicaid_office_borough_tv);
        officePostCode_tv = itemView.findViewById(R.id.medicaid_office_zip_code_tv);

    }

    public void onBind(MedicaidModels medicaidModels ){

        medicaidOfficeName_tv.setText(medicaidModels.getName_of_medicaid_offices());
        medicaidOfficeAddress_tv.setText(medicaidModels.getAddress());
        officeNumber_tv.setText(medicaidModels.getTelephone_number());
        officeBorough_tv.setText(medicaidModels.getBorough());
        officePostCode_tv.setText(medicaidModels.getPostcode());
    } // ends onbind
} // ends Medicaid view holder class
