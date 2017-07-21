package com.inboundrx.paulsensbeaconsapp.sourceCode.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inboundrx.paulsensbeaconsapp.R;
import com.inboundrx.paulsensbeaconsapp.sourceCode.managers.BeaconRangingManager;

public class HistoryActivity extends AppCompatActivity {
    private BeaconRangingManager beaconFinder = new BeaconRangingManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        beaconFinder.findBeacon(this);
    }
}
