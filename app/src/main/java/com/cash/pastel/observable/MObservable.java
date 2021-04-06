package com.cash.pastel.observable;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.cash.pastel.application.AppController;
import com.cash.pastel.model.Response;
import com.cash.pastel.model.Result;
import com.cash.pastel.network.MlService;
import com.cash.pastel.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.cash.pastel.utils.Information.URL;

public class MObservable extends Observable {
    public ObservableInt progressBar;
    public ObservableInt mlRecycler;
    private List<Result> mlList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MObservable(@NonNull Context context){
        this.context = context;
        this.mlList = new ArrayList<>();
        progressBar = new ObservableInt(View.GONE);
        mlRecycler = new ObservableInt(View.GONE);
    }

    public void onClickSearch(){
        initViews();
        validateOperation();
    }

    public void initViews(){
        mlRecycler.set(View.GONE);
        progressBar.set(View.VISIBLE);
    }

    public void validateOperation(){

        if (Util.isConnected(context)) getMlList();
        else {
            Toast.makeText(context, "Por favor verifica tu conexión a internet", Toast.LENGTH_LONG).show();
            progressBar.set(View.GONE);
        }
    }

    private void getMlList(){
        AppController appController = AppController.create(context);
        MlService mlService = appController.getMlService();

        Disposable disposable = mlService.getMlList(URL)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response>() {
                    @Override
                    public void accept(Response response) throws Exception {
                        updateMlList(response.getResults());
                        progressBar.set(View.GONE);
                        mlRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        progressBar.set(View.GONE);
                        mlRecycler.set(View.GONE);
                        Toast.makeText(context, "Error descargando la información", Toast.LENGTH_SHORT).show();
                    }
                });
        compositeDisposable.add(disposable);
    }

    private void updateMlList(List<Result> results){
        mlList.addAll(results);
        setChanged();
        notifyObservers();
    }

    public List<Result> getMlResultList(){
        return mlList;
    }

    private void unSubscribeFromObservable(){
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset(){
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
