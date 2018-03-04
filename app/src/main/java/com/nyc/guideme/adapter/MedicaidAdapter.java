package com.nyc.guideme.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.nyc.guideme.R;
import com.nyc.guideme.details.MedicaidDetailActivity;
import com.nyc.guideme.models.MedicaidModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 3/4/18.
 */

public class MedicaidAdapter extends RecyclerView.Adapter<MedicaidViewHolder>{

    // private fields:
    private List<MedicaidModels> medicaidOfficeList = new ArrayList<>();

    // default constructor:
    public MedicaidAdapter( List<MedicaidModels> medicalList){this.medicaidOfficeList = medicalList;}

    @Override
    public MedicaidViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_medical, parent, false);
            return new MedicaidViewHolder( view );
    } // ends medicaid view holder class:

    @Override
    public void onBindViewHolder( final MedicaidViewHolder holder, final int position){

        holder.onBind(medicaidOfficeList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // here to - do :

                String medicaidJSON = new Gson().toJson(medicaidOfficeList.get(position));

                // start an intent to start the activity
                Intent openMedicaidDetailActivity  = new Intent( holder.itemView.getContext(), MedicaidDetailActivity.class);
                openMedicaidDetailActivity.putExtra("medicaidDetails", medicaidJSON);
                holder.itemView.getContext().startActivity(openMedicaidDetailActivity);
            }
        });
    }

    @Override
    public int getItemCount(){
        return medicaidOfficeList.size();
    }
} // ends main activity
