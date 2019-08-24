package com.example.administrator.copyothersd.service;

import com.example.administrator.copyothersd.entity.NewsEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ShowService {
    @GET("index")
    Observable<NewsEntity> getnews(@Query("type") String type,@Query("key") String key);//工作计划
}
