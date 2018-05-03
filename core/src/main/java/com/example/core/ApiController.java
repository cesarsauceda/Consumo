package com.example.core;

import com.example.core.Utils.JSONKeys;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sauceda on 24/02/18.
 */

public class ApiController {

    public ApiController() {

    }

    public static <S> S createService(Class<S> serviceClass){

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(JSONKeys.KEY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

}
