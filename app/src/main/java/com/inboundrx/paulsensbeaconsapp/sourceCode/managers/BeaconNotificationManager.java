package com.inboundrx.paulsensbeaconsapp.sourceCode.managers;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.inboundrx.paulsensbeaconsapp.sourceCode.BaseConstants;
import com.inboundrx.paulsensbeaconsapp.sourceCode.ui.LandingActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by arlen on 7/17/17.
 */

public class BeaconNotificationManager extends Application{
    private BeaconManager beaconManager;

    public void showNotification(String title, String message){
        Intent notifyIntent = new Intent(this, LandingActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[] {notifyIntent}, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        beaconManager = new BeaconManager(getApplicationContext());

        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<com.estimote.sdk.Beacon> list) {
                showNotification(
                        "You are here",
                        "Current here information is there, "
                                + "and you have 2 minutes to midnight. "
                                + "When will train A hit train B?");
            }
            @Override
            public void onExitedRegion(Region region) {
            }
        });

        beaconManager.connect(new BeaconManager.ServiceReadyCallback(){
            @Override
            public void onServiceReady(){
                beaconManager.startMonitoring(
                        new Region("monitored region", UUID.fromString
                                (BaseConstants.BEACON_UUID), null, null));
            }
        });
    }
}
