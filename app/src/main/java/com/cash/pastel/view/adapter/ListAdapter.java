package com.cash.pastel.view.adapter;

import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.cash.pastel.R;
import com.cash.pastel.databinding.ItemLayoutBinding;
import com.cash.pastel.model.Result;
import com.cash.pastel.observable.ItemObservable;
import java.util.Collections;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MLibreHolder> {

    private List<Result> seeResultList;

    public ListAdapter() {
        this.seeResultList = Collections.emptyList();
    }

    @NonNull
    @Override
    public MLibreHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemLayoutBinding itemV = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
        R.layout.item_layout, viewGroup, false);
        return new MLibreHolder(itemV);
    }

    @Override
    public void onBindViewHolder(@NonNull MLibreHolder mlHolder, int i) {
        mlHolder.bindResult(seeResultList.get(i));
    }

    @Override
    public int getItemCount() {
        Log.d("ListAdapter" , "Size is " + seeResultList.size());
        return seeResultList.size();
    }

    public void setResultList(List<Result> resultList){
        this.seeResultList = resultList;
        notifyDataSetChanged();
    }

    static class MLibreHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding itemV;

        public MLibreHolder(ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            this.itemV = itemView;
        }

        void bindResult(Result result){
            if( itemV.getItemViewModel() == null){
                itemV.setItemViewModel(new ItemObservable(result, itemView.getContext()));
            } else {
                itemV.getItemViewModel().setResult(result);
            }
        }

    }
}
