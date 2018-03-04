package com.nyc.guideme.eligibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nyc.guideme.R;

public class ResumeBuilder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_builder);

        ResumeObject  resumeObject , resumeObject1, resumeObject2, resumeObject3, resumeObject4, resumeObject5, resumeObject6;

resumeObject2 = new ResumeObject();
resumeObject2.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/web-developer-resume-example-emphasis-2-expanded-2.png");
resumeObject2.setText(getString(R.string.web) +
        getString(R.string.web2) +
        getString(R.string.web3) +
        getString(R.string.web4));

        resumeObject = new ResumeObject();
        resumeObject.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/teacher-resume-example-emphasis-2-full.png");
        resumeObject.setText(getString(R.string.teacher) +
                getString(R.string.teacher2) +
                getString(R.string.teacher3));

        resumeObject1 = new ResumeObject();
        resumeObject1.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/secretary-resume-example-classic-2-full-2.png");
        resumeObject1.setText(getString(R.string.administrative_2) +
                getString(R.string.admknistative_3) +
                getString(R.string.administrative_zssisant));

        resumeObject3 = new ResumeObject();
        resumeObject3.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/business-analyst-resume-example-contemporary-5-full.png");
        resumeObject3.setText(getString(R.string.business) +
                getString(R.string.business2) +
                getString(R.string.business3));

        resumeObject4 = new ResumeObject();
        resumeObject4.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/receptionist-administration-office-support-resume-example-executive-2-full.png");
        resumeObject4.setText(getString(R.string.reception) +
                getString(R.string.reception2) +
                getString(R.string.reception3));

        resumeObject5 = new ResumeObject();
        resumeObject5.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/human-resources-manager-human-resources-contemporary-5-expanded.png");
        resumeObject5.setText(getString(R.string.human) +
                getString(R.string.human2) +
                getString(R.string.human3));

        resumeObject6 = new ResumeObject();
        resumeObject6.setURL("https://www.livecareer.com/wp-content/uploads/images/uploaded/resume-example-home/office-assistant-administration-office-support-resume-example-modern-6-full.png");
        resumeObject6.setText(getString(R.string.office) +
                getString(R.string.office2) +
                getString(R.string.office3));
    }


}


