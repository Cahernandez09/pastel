package com.cash.pastel.application;

import android.app.Application;
import android.content.Context;

import com.cash.pastel.network.ApiFactory;
import com.cash.pastel.network.MlService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AppController extends Application {

    private MlService mlService;
    private Scheduler scheduler;

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }


    public MlService getMlService(){
        if (mlService == null) mlService = ApiFactory.create();
        return mlService;
    }

    public Scheduler subscribeScheduler(){
        if (scheduler == null) scheduler = Schedulers.io();
        return scheduler;
    }
}
