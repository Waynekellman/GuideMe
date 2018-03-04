package com.nyc.guideme.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
    }
}
