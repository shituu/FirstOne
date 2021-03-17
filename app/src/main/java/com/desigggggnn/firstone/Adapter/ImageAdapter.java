package com.desigggggnn.firstone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.desigggggnn.firstone.model.ImageModel;
import com.desigggggnn.firstone.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private Context context;
    private List<ImageModel> imageModels;

    public ImageAdapter(Context context, List<ImageModel> imageModels) {
        this.context = context;
        this.imageModels = imageModels;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView Imagee;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Imagee = itemView.findViewById(R.id.img_top);
        }
    }

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_images,parent,false);

        return new ImageAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, int position) {

        ImageModel imageModel = imageModels.get(position);
        holder.Imagee.setImageResource(imageModel.getImagee());
    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }


}
