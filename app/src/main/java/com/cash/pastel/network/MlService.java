package com.cash.pastel.network;

import com.cash.pastel.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MlService {
    @GET
    Observable<Response> getMlList(@Url String url);
}
