package com.inboundrx.paulsensbeaconsapp.sourceCode.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inboundrx.paulsensbeaconsapp.R;
import com.inboundrx.paulsensbeaconsapp.sourceCode.StringConstants;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.aboutButton) ImageView mAboutButton;
    @Bind(R.id.homeButton) ImageView mHomeButton;
    @Bind(R.id.rewardsButton) ImageView mRewardsButton;
    @Bind(R.id.historyButton) ImageView mHistoryButton;
    @Bind(R.id.paulsensInfo) TextView mPaulsensInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        mAboutButton.setOnClickListener(this);
        mHomeButton.setOnClickListener(this);
        mRewardsButton.setOnClickListener(this);
        mHistoryButton.setOnClickListener(this);
        mPaulsensInfo.setText(StringConstants.PAULSENS_BIO
                            + StringConstants.PAULSENS_HOURS
                            + StringConstants.PAULSENS_WEBSITE
                            + StringConstants.PAULSENS_ADDRESS
                            + StringConstants.PAULSENS_PHONE);
    }
    @Override
    public void onClick(View v){
        if (v == mAboutButton){
            Intent intent = new Intent(AboutActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        if (v == mRewardsButton){
            Intent intent = new Intent(AboutActivity.this, RewardsActivity.class);
            startActivity(intent);
        }
        if (v == mHistoryButton){
            Intent intent = new Intent(AboutActivity.this, HistoryActivity.class);
            startActivity(intent);
        }
        if (v == mHomeButton){
            Intent intent = new Intent(AboutActivity.this, LandingActivity.class);
            startActivity(intent);
        }
    }
}
