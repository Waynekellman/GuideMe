package com.nyc.guideme.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by c4q on 3/3/18.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView ;
    TextView textView;
    Context context;

    public ViewHolder(View itemView) {
        super(itemView);
    }


}
