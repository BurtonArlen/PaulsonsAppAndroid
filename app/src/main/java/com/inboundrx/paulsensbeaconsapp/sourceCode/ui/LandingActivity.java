package com.inboundrx.paulsensbeaconsapp.sourceCode.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;
import com.inboundrx.paulsensbeaconsapp.R;
import com.inboundrx.paulsensbeaconsapp.sourceCode.interfaces.BeaconCallback;
import com.inboundrx.paulsensbeaconsapp.sourceCode.managers.BeaconRangingManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener, BeaconCallback{
    @Bind(R.id.aboutButton) ImageView mAboutButton;
    @Bind(R.id.homeButton) ImageView mHomeButton;
    @Bind(R.id.rewardsButton) ImageView mRewardsButton;
    @Bind(R.id.historyButton) ImageView mHistoryButton;
    private BeaconRangingManager beaconFinder = new BeaconRangingManager();
    private BeaconManager beaconManager;
    private Region region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
        mAboutButton.setOnClickListener(this);
        mHomeButton.setOnClickListener(this);
        mRewardsButton.setOnClickListener(this);
        mHistoryButton.setOnClickListener(this);
        beaconFinder.findBeacon(this);
    }

    public void beaconCallBack() {
        System.out.println("I've been called back");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_account_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_user){
            Intent intent = new Intent(LandingActivity.this, UserActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v){
        if (v == mAboutButton){
            Intent intent = new Intent(LandingActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        if (v == mRewardsButton){
            Intent intent = new Intent(LandingActivity.this, RewardsActivity.class);
            startActivity(intent);
        }
        if (v == mHistoryButton){
            Intent intent = new Intent(LandingActivity.this, HistoryActivity.class);
            startActivity(intent);
        }
        if (v == mHomeButton){
            Intent intent = new Intent(LandingActivity.this, LandingActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause(){
        beaconFinder.beaconPause();
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        beaconFinder.beaconResume();
        SystemRequirementsChecker.checkWithDefaultDialogs(this);

    }
}
