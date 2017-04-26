package com.meipan.library.net;

import com.meipan.library.api.model.Model;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by gaoyan on 17/3/10.
 */

public interface ApiService {
    String HOST = "https://test.iyuanzi.com/";

//    @Headers({"Accept:application/vnd.yuanzi.v4+json"
//            , "Content-Type: application/json",
//            "Authorization: Bearer unsign"
//    })
    @GET("circles")
    Observable<Model> getCircle();
}
