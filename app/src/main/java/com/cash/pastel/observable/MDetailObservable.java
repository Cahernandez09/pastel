package com.cash.pastel.observable;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.cash.pastel.model.Result;

public class MDetailObservable {
    private Result result;

    public MDetailObservable(Result result){
        this.result = result;
    }

    public String getName(){
        return result.getName();
    }

    public String getPictureUrl() {
        return result.getPictures().get(0).getUrl();
    }
   @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }
}
