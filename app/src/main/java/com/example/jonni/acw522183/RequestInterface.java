package com.example.jonni.acw522183;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jonni on 3/22/2017.
 */
public interface RequestInterface {
    @GET("php/349628/08027/acw/index.json")
    Call<JSONResponse> getJSON();


}
