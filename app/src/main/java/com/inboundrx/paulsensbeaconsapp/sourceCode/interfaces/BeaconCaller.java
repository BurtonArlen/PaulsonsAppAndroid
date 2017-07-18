package com.inboundrx.paulsensbeaconsapp.sourceCode.interfaces;

import com.inboundrx.paulsensbeaconsapp.sourceCode.ui.LandingActivity;

/**
 * Created by arlen on 7/17/17.
 */

public class BeaconCaller {
    public void register(BeaconCallback callback) {
        callback.beaconCallBack();
    }
    public static void main(String[] args) {
        BeaconCaller caller = new BeaconCaller();
        BeaconCallback callBack = new LandingActivity();
        caller.register(callBack);
    }
}
