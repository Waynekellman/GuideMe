package com.nyc.guideme.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.nyc.guideme.R;
import com.nyc.guideme.eligibility.ResumeObject;
import com.squareup.picasso.Picasso;

/**
 * Created by c4q on 3/4/18.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    PhotoView imageView ;
    TextView textView;
    Context context;

    public ViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_view_resume);


       // textView = itemView.findViewById(R.id.text_view_resume);
        context = itemView.getContext();

    }

    public void onBind(ResumeObject resumeObject) {

//        Glide.with(context)
//                .load(resumeObject.getURL())
//                .into(imageView);
//        textView.setText(resumeObject.getText());

        Picasso.with(context)
                .load(resumeObject.getURL())
                .into(imageView);

    }


    }

