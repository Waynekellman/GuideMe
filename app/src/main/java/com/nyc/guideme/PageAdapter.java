package com.nyc.guideme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nyc.guideme.fragment.FinancialAssistanceTab;
import com.nyc.guideme.fragment.JobTab;
import com.nyc.guideme.fragment.MedicalAssistanceTab;

/**
 * Created by c4q on 3/3/18.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;

    public PageAdapter(FragmentManager fm, int mNoOfTabs) {
        super(fm);
        this.mNoOfTabs = mNoOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                JobTab jobTab = new JobTab();
                return jobTab;
            case 1:
                FinancialAssistanceTab financialAssistanceTab = new FinancialAssistanceTab();
                return financialAssistanceTab;
            case 2:
                MedicalAssistanceTab medicalAssistanceTab = new MedicalAssistanceTab();
                return medicalAssistanceTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
