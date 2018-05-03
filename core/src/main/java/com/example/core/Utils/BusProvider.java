package com.example.core.Utils;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by sauceda on 24/02/18.
 */

public class BusProvider {

    public static final Bus BUS=new Bus(ThreadEnforcer.ANY);

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider() {
    }
}
