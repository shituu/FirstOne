package com.desigggggnn.firstone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.desigggggnn.firstone.model.Model;
import com.desigggggnn.firstone.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

private Context context;
private List<Model> models;

public RecyclerViewAdapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView txt_name;
    ImageView img;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_name = itemView.findViewById(R.id.txt_view);
        img = itemView.findViewById(R.id.img_view);
    }
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_development_work,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model model = models.get(position);

        holder.txt_name.setText(model.getName());
        holder.img.setImageResource(model.getImage());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }


}
