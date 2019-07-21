package com.example.varun.cfg;


import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<LectureItem> listItems;
    private Context context;


    public MyAdapter(List<LectureItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecture_card,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d("hi", "inflating ");

        final LectureItem listItem = listItems.get(position);

        viewHolder.heading.setText(listItem.getId());
        viewHolder.desc.setText(listItem.getDesc());

//        Glide.with(context)
//                .asBitmap()
//                .load(listItem.getImgUrl())
//                .into(viewHolder.img);

        int resID = context.getResources().getIdentifier(listItem.getImgUrl() , "drawable", context.getPackageName());

        viewHolder.img.setImageResource(resID);

        viewHolder.parentPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,listItem.getId(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,LectureDetailsAactivity.class);
                intent.putExtra("image",listItem.getImgUrl());
                intent.putExtra("heading",listItem.getId());
                intent.putExtra("desc",listItem.getDesc());
                intent.putExtra("ar",listItem.getArUrl());
                intent.putExtra("video",listItem.getVideoUrl());
                intent.putExtra("audio",listItem.getAudioUrl());
                intent.putExtra("pdf",listItem.getPdfUrl());
                intent.putExtra("tag",listItem.getTagText());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heading, desc, price;
        public ImageView img;
        public LinearLayout parentPanel;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.lectureHeading);
            desc = itemView.findViewById(R.id.lectureDescription);
            img = itemView.findViewById(R.id.lectureImage);
            parentPanel = itemView.findViewById(R.id.parentPanel);
        }
    }


}