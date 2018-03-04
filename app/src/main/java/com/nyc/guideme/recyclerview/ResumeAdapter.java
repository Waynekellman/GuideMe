package com.nyc.guideme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.guideme.R;
import com.nyc.guideme.eligibility.ResumeObject;

import java.util.ArrayList;

/**
 * Created by c4q on 3/4/18.
 */

public class ResumeAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<ResumeObject> resumeObjects ;

    public ResumeAdapter(ArrayList<ResumeObject> resumeObjects){
        this.resumeObjects = resumeObjects ;
    }



    /*

    from my jets app


    private ArrayList<Play> practicePB;

    public AdapterSon(ArrayList<Play> practicePB) {
        this.practicePB = practicePB;
    }

        @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.o_practice_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(practicePB.get(position));
    }

    @Override
    public int getItemCount() {
        return practicePB.size();
    }
}


     */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_resume, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(resumeObjects.get(position));

    }

    @Override
    public int getItemCount() {
        return resumeObjects.size();
    }

}
