package com.inboundrx.paulsensbeaconsapp.sourceCode.managers;

import android.content.Context;
import android.util.Log;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.inboundrx.paulsensbeaconsapp.sourceCode.BaseConstants;
import com.inboundrx.paulsensbeaconsapp.sourceCode.interfaces.BeaconCallback;
import com.inboundrx.paulsensbeaconsapp.sourceCode.interfaces.Caller;
import com.inboundrx.paulsensbeaconsapp.sourceCode.ui.LandingActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by arlen on 7/17/17.
 */

public class BeaconRangingManager {
    private LandingActivity landingActivity;
    private BeaconManager beaconManager;
    private Caller caller;
    private Region region;
    private boolean stringDecider;
    private String foundBeacon;
    public void findBeacon(Context context){
        beaconManager = new BeaconManager(context);
        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> list) {
                if (!list.isEmpty()) {
                    final String[] beacons = new String[]{"Found Beacon", "No Beacon"};
                    Log.d("Paulsons Beaon App: ", BaseConstants.BEACON_UUID);
                    Caller.main(beacons);
                }
            }
        });
        region = new Region("ranged region", UUID.fromString(BaseConstants.BEACON_UUID), null, null);
    }

    public void beaconResume(){
        beaconManager.connect(new BeaconManager.ServiceReadyCallback(){
            @Override
            public void onServiceReady(){
                beaconManager.startRanging(region);
            }
        });
    }
    public void beaconPause(){
        beaconManager.stopRanging(region);
    }
}
