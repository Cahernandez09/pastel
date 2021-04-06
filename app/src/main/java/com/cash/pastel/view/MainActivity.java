package com.cash.pastel.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cash.pastel.R;
import com.cash.pastel.databinding.ActivityMainBinding;
import com.cash.pastel.observable.MObservable;
import com.cash.pastel.view.adapter.ListAdapter;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    //**********************Objects*****************//
    private ActivityMainBinding activityMainBinding;
    private MObservable mObservable;

    //*****************Override methods*************************//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataBinding();
        setUpListOfResults(activityMainBinding.recyclerview);
        setUpObserver(mObservable);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof MObservable){
            ListAdapter listAdapter = (ListAdapter) activityMainBinding.recyclerview.getAdapter();
            MObservable mObservable = (MObservable) observable;
            if (listAdapter != null)listAdapter.setResultList(mObservable.getMlResultList());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mObservable.reset();
    }
    //*****************Instance methods*************************//

    // set up the list of results with recycler view
    private void setUpListOfResults(RecyclerView recyclerView) {
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mObservable = new MObservable(this);
        activityMainBinding.setViewModel(mObservable);
        mObservable.onClickSearch();
    }
}
