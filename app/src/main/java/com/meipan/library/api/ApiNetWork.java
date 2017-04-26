package com.meipan.library.api;

import com.meipan.library.api.model.Model;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gaoyan on 17/2/25.
 */

public interface ApiNetWork {

    boolean FORMAL = false;


    String API_SERVER_URL = "http://baidu.com";
    String API_TEST_URL = "http://baidu.com";

    @GET("circles")
    Observable<Model> getCircle();
}
