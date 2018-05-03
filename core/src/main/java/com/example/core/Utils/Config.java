package com.example.core.Utils;

import android.content.Context;

/**
 * Created by sauceda on 24/02/18.
 */

public class Config {
    public static SharedPreferencesUsers sharedPreferencesUsers;

    public static void init(Context context) {

        sharedPreferencesUsers = new SharedPreferencesUsers(context);

    }

}
