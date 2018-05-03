package com.example.core.managers;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.core.ApiController;
import com.example.core.ILotus;
import com.example.core.Usuario;
import com.example.core.Utils.BusProvider;
import com.example.core.Utils.Config;
import com.example.core.events.ErrorEvent;
import com.example.core.events.SignUpEvent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sauceda on 24/02/18.
 */

public class UserManager {

    public static void singUp(Usuario usuario) {
        Call<JsonObject> callResponse= ApiController
                .createService(ILotus.class)
                .singUp(usuario);
        callResponse.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){

                    Gson gson=new Gson();
                    JsonObject respuesta=response.body();
                    JsonElement token=respuesta.get("auth_token");
                    Config.sharedPreferencesUsers.saveSession(token.toString());
                    String mensaje=token.toString();
                    BusProvider.getInstance().post(new SignUpEvent(token.toString()));
                }
                else {
                    BusProvider.getInstance().post(new ErrorEvent(response.message(),0));

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                BusProvider.getInstance().post(new ErrorEvent(t.getMessage(),0));

            }
        });


    }
}
