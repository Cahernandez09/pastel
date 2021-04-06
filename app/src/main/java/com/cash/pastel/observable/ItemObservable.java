package com.cash.pastel.observable;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.cash.pastel.model.Result;
import com.cash.pastel.view.DetailActivity;

public class ItemObservable extends BaseObservable {
    private Result result;
    private Context context;

    public ItemObservable(Result result, Context context){
        this.result = result;
        this.context = context;
    }

    public String getImage() {
        return result.getPictures().get(0).getUrl();
    }

    // Loading Image using Glide Library.
    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public String getName(){
        return result.getName();
    }

    public void onItemClick(View v){
        context.startActivity(DetailActivity.fillDetail(v.getContext(), result));
    }

    public void setResult(Result result){
        this.result = result;
        notifyChange();
    }
}
