package com.example.core;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sauceda on 24/02/18.
 */

public interface ILotus {
    @POST("sign-up")
    Call<JsonObject> singUp(@Body Usuario usuario);

    @POST ("sign-up")
    Call<JsonObject>registro(@Query("sex")String sexo,
                             @Query("birthday")String fechaNac,
                             @Query("name")String nombre,
                             @Query("email")String correo,
                             @Query("password")String contra,
                             @Query("password_confirmation")String contraConfirm);




}
