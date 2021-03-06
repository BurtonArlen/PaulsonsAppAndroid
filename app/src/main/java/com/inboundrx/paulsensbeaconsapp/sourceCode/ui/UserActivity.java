package com.inboundrx.paulsensbeaconsapp.sourceCode.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.inboundrx.paulsensbeaconsapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.aboutButton) ImageView mAboutButton;
    @Bind(R.id.homeButton) ImageView mHomeButton;
    @Bind(R.id.rewardsButton) ImageView mRewardsButton;
    @Bind(R.id.historyButton) ImageView mHistoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        mAboutButton.setOnClickListener(this);
        mHomeButton.setOnClickListener(this);
        mRewardsButton.setOnClickListener(this);
        mHistoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == mAboutButton){
            Intent intent = new Intent(UserActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        if (v == mRewardsButton){
            Intent intent = new Intent(UserActivity.this, RewardsActivity.class);
            startActivity(intent);
        }
        if (v == mHistoryButton){
            Intent intent = new Intent(UserActivity.this, HistoryActivity.class);
            startActivity(intent);
        }
        if (v == mHomeButton){
            Intent intent = new Intent(UserActivity.this, LandingActivity.class);
            startActivity(intent);
        }
    }
}
