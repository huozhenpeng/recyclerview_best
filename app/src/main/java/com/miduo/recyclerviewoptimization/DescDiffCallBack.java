package com.miduo.recyclerviewoptimization;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class DescDiffCallBack extends DiffUtil.Callback {

    private List<Desc> oldList;
    private List<Desc> newList;

    public DescDiffCallBack(List<Desc> newList,List<Desc> oldList)
    {
        this.newList=newList;
        this.oldList=oldList;
    }
    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    //这个方法返回true才会执行下面的areContentsTheSame方法
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId()==newList.get(newItemPosition).getId();
    }

    //这个方法返回false才会执行getChangePayload方法
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Desc oldItem=oldList.get(oldItemPosition);
        Desc newItem=newList.get(newItemPosition);
        return(oldItem.getId()==newItem.getId())&&(oldItem.getPic().equals(newItem.getPic()));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Desc oldItem=oldList.get(oldItemPosition);
        Desc newItem=newList.get(newItemPosition);
        Bundle payload=new Bundle();
        if(!oldItem.getText().equals(newItem.getText()))
        {
            payload.putString("desc",newItem.getText());
        }

        if(!oldItem.getPic().equals(newItem.getPic()))
        {
            payload.putString("pic",newItem.getPic());
        }

        if(payload.size()==0)
        {
            return null;
        }

        return payload;
    }
}
