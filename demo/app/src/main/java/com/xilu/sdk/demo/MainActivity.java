package com.xilu.sdk.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.xilu.sdk.demo.activity.ad.banner.BannerAdActivity;
import com.xilu.sdk.demo.activity.ad.draw.DrawVodActivity;
import com.xilu.sdk.demo.activity.ad.feed.NativeExpressActivity;
import com.xilu.sdk.demo.activity.ad.feed.NativeExpressListActivity;
import com.xilu.sdk.demo.activity.ad.feed.NativeSelfRenderActivity;
import com.xilu.sdk.demo.activity.ad.feed.NativeSelfRenderListActivity;
import com.xilu.sdk.demo.activity.ad.fullscreen.FullScreenVodAdActivity;
import com.xilu.sdk.demo.activity.ad.interstitial.InterstitialAdActivity;
import com.xilu.sdk.demo.activity.ad.reward.RewardVodAdActivity;
import com.xilu.sdk.demo.activity.ad.splash.SplashAdSettingActivity;
import com.xilu.sdk.demo.util.SPUtil;
import com.xilu.sdk.ADXiluSdk;

/**
 * Created by zhangqinglou on 2025/4/12.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnSplashAd).setOnClickListener(this);
        findViewById(R.id.btnBannerAd).setOnClickListener(this);
        findViewById(R.id.btnNativeExpressLayout).setOnClickListener(this);
        findViewById(R.id.btnNativeSelfRenderLayout).setOnClickListener(this);
        findViewById(R.id.btnNativeExpressList).setOnClickListener(this);
        findViewById(R.id.btnNativeSelfRenderList).setOnClickListener(this);
        findViewById(R.id.btnRewardVodAd).setOnClickListener(this);
        findViewById(R.id.btnFullScreenAd).setOnClickListener(this);
        findViewById(R.id.btnInterstitialAd).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.btnSplashAd){
//            startActivity(SplashAdSettingActivity.class);
////            ToolsUtil.start(this);
//
//        } else if (v.getId() == R.id.btnBannerAd) {
//            //调用初始化
//            TTAdManagerHolder.init(this);
//        } else if (v.getId() == R.id.btnNativeExpressLayout) {
//            ToolsUtil.start(this);
//
//        } else if (v.getId() == R.id.btnNativeSelfRenderLayout) {
//            Intent intent = new Intent(this, CSJSplashActivity.class);
//            intent.putExtra("splash_rit", "887420801");
//            intent.putExtra("is_express", false);
//            intent.putExtra("is_half_size", false);
//            startActivity(intent);
//        }
        int id = v.getId();
        if (id == R.id.btnSplashAd) {
            startActivity(SplashAdSettingActivity.class);
        } else if (id == R.id.btnBannerAd) {
            startActivity(BannerAdActivity.class);
        } else if (id == R.id.btnNativeExpressLayout) {
            startActivity(NativeExpressActivity.class);
        } else if (id == R.id.btnNativeSelfRenderLayout) {
            startActivity(NativeSelfRenderActivity.class);
        } else if (id == R.id.btnNativeExpressList) {
            startActivity(NativeExpressListActivity.class);
        } else if (id == R.id.btnNativeSelfRenderList) {
            startActivity(NativeSelfRenderListActivity.class);
        } else if (id == R.id.btnRewardVodAd) {
            startActivity(RewardVodAdActivity.class);
        } else if (id == R.id.btnInterstitialAd) {
            startActivity(InterstitialAdActivity.class);
        } else if (id == R.id.btnFullScreenAd) {
            startActivity(FullScreenVodAdActivity.class);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.toolbar_setting:
//                startActivity(SettingActivity.class);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
        return super.onOptionsItemSelected(item);
    }


    private void startActivity(Class<? extends Activity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}

