package com.inboundrx.paulsensbeaconsapp.sourceCode.interfaces;

import com.inboundrx.paulsensbeaconsapp.sourceCode.managers.BeaconRangingManager;
import com.inboundrx.paulsensbeaconsapp.sourceCode.ui.LandingActivity;

/**
 * Created by arlen on 7/19/17.
 */

public class Caller {
    private void register(BeaconCallback callback) {
        callback.beaconCallBack();
    }
    public static void main(String[] args) {
        Caller caller = new Caller();
        BeaconCallback callBack = new LandingActivity();
        caller.register(callBack);
    }
}
