package com.example.bottomnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCviewHolder> {

    Context context;
    ArrayList<RCModel> modelArrayList;

    public RCAdapter(Context context, ArrayList<RCModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }



    @NonNull
    @Override
    public RCviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_item, parent, false);
        return new RCviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCviewHolder holder, int position) {
        RCModel rcModel = modelArrayList.get(position);
        holder.rc_title.setText(rcModel.title);
        holder.rc_image.setImageResource(rcModel.image);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class RCviewHolder extends RecyclerView.ViewHolder{

        ImageView rc_image;
        TextView rc_title;

        public RCviewHolder(@NonNull View itemView) {
            super(itemView);


            rc_image = itemView.findViewById(R.id.rc_image);
            rc_title = itemView.findViewById(R.id.rc_title);
        }
    }
}
