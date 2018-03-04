package com.nyc.guideme.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.nyc.guideme.R;
import com.nyc.guideme.models.MedicaidModels;

public class MedicaidDetailActivity extends AppCompatActivity {

    // private fields:
    private MedicaidModels medicaidOffice;

    private TextView medicalOfficeName, medicalOfficeAddress, medicalOfficeBorough, medicaidOfficeZipCode, medicaidOfficeNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaid_detail);


        medicalOfficeName = (TextView)findViewById(R.id.medical_office_name_tv);
        medicalOfficeAddress = (TextView)findViewById(R.id.medical_office_address_tv);
        medicalOfficeBorough = (TextView)findViewById(R.id.medicaid_office_borough_tv);
        medicaidOfficeZipCode = (TextView)findViewById(R.id.medicaid_office_zip_code_tv);
        medicaidOfficeNumber = (TextView)findViewById(R.id.medicaid_office_phonenumber_tv);









    }
}
