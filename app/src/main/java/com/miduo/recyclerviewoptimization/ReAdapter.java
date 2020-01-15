package com.miduo.recyclerviewoptimization;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

    private String TAG="ReAdapter";
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
        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(callBackListener!=null)
                {
                    callBackListener.onClick((Integer) v.getTag());
                }

            }
        });
        RViewHolder viewHolder=new RViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {

        holder.itemView.setTag(position);
        Desc desc=datas.get(position);
        Glide.with(context).load(desc.getPic()).into(holder.iv_pic);
        holder.tv.setText(desc.getText());
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position, @NonNull List<Object> payloads) {

        if(payloads.isEmpty())
        {
            super.onBindViewHolder(holder, position, payloads);
        }
        else
        {
            Bundle bundle= (Bundle) payloads.get(0);
            for(String key:bundle.keySet())
            {
                switch (key)
                {
                    case "desc":
                        holder.tv.setText(bundle.getString("desc"));
                        break;
                    case "pic":
                        Log.e(TAG,"pic:"+bundle.getString("pic"));
                        Glide.with(context).load(bundle.getString("pic")).into(holder.iv_pic);
                        break;
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class RViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv_pic;
        TextView tv;
        View itemView;

        public RViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            iv_pic=itemView.findViewById(R.id.iv_pic);
            tv=itemView.findViewById(R.id.tv);
        }
    }

    CallBackListener callBackListener;

    public void setCallBackListener(CallBackListener callBackListener)
    {
        this.callBackListener=callBackListener;
    }

    interface CallBackListener
    {
        void onClick(int position);
    }

    /**
     * 可以做广告统计
     * 但是有一点，每次调用notifyDataSetChanged当前页面所有的item都会调用一次
     * @param holder
     */
    @Override
    public void onViewAttachedToWindow(@NonNull RViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        Log.e(TAG,holder.tv.getText().toString());
    }
}


