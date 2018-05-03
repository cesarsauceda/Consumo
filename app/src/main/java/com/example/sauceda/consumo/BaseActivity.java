package com.example.sauceda.consumo;

import android.support.v7.app.AppCompatActivity;

import com.example.core.Utils.BusProvider;
import com.squareup.otto.Subscribe;

/**
 * Created by sauceda on 24/02/18.
 */

public class BaseActivity extends AppCompatActivity {

    @Subscribe

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }
    @Subscribe

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }
}
