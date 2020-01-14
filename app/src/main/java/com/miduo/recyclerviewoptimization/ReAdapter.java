package com.miduo.recyclerviewoptimization;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.RViewHolder> {

    private Context context;
    private List<Desc> datas;

    public ReAdapter(Context context,List<Desc> datas)
    {
        this.context=context;
        this.datas=datas;
    }
    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,null);
        RViewHolder viewHolder=new RViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {

        Desc desc=datas.get(position);
        Glide.with(context).load(desc.getPic()).into(holder.iv_pic);
        holder.tv.setText(desc.getText());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class RViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv_pic;
        TextView tv;

        public RViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_pic=itemView.findViewById(R.id.iv_pic);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}


