package com.cash.pastel.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.cash.pastel.R;
import com.cash.pastel.databinding.ActivityDetailBinding;
import com.cash.pastel.model.Result;
import com.cash.pastel.observable.MDetailObservable;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_RESULT = "EXTRA_RESULT";
    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        getExtrasFromIntent();
    }

    public static Intent fillDetail(Context context, Result result) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_RESULT, result);
        return intent;
    }

    private void getExtrasFromIntent(){
        Result result = (Result) getIntent().getSerializableExtra(EXTRA_RESULT);
        MDetailObservable detailViewModel = new MDetailObservable(result);
        activityDetailBinding.setDetailViewModel(detailViewModel);
    }
}
