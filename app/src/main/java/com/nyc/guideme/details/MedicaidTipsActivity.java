package com.nyc.guideme.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nyc.guideme.R;

public class MedicaidTipsActivity extends AppCompatActivity {

    // fields:
    private TextView nyStateHealth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaid_tips);


        nyStateHealth = (TextView)findViewById(R.id.ny_state_of_health);

        openBrowser();
    }

    // TO - DO : code to open a url in the browser
    public void openBrowser(){

        nyStateHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                } catch ( Exception e ){
                      e.printStackTrace();
                }
            }
        });
    }
}
