package com.kimganteng.myapplication;

import static android.content.ContentValues.TAG;
import static com.kimganteng.myapplication.SettingsAlien.AppIDViewAds;
import static com.kimganteng.myapplication.SettingsAlien.BackupIntertitial;
import static com.kimganteng.myapplication.SettingsAlien.BackupReward;
import static com.kimganteng.myapplication.SettingsAlien.Backup_Initialize;
import static com.kimganteng.myapplication.SettingsAlien.MainIntertitial;
import static com.kimganteng.myapplication.SettingsAlien.MainRewards;
import static com.kimganteng.myapplication.SettingsAlien.Select_Backup_Ads;
import static com.kimganteng.myapplication.SettingsAlien.Select_Main_Ads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aliendroid.alienads.AlienGDPR;
import com.aliendroid.alienads.AliendroidInitialize;
import com.aliendroid.alienads.AliendroidIntertitial;
import com.aliendroid.alienads.AliendroidReward;
import com.aliendroid.alienads.interfaces.interstitial.admob.OnFullScreenContentCallbackAdmob;
import com.aliendroid.alienads.interfaces.interstitial.load.OnLoadInterstitialAdmob;
import com.aliendroid.alienads.interfaces.interstitial.show.OnShowInterstitialAdmob;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsAdmob;
import com.aliendroid.sdkads.config.AppPromote;
import com.aliendroid.sdkads.config.InitializeAlienAds;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppPromote.initializeAppPromote(this);
        InitializeAlienAds.LoadSDK();
        /*
        if (SettingsAlien.Select_Open_Ads.equals("2")) {

            AlienViewAds.OpenApp(MainActivity.this,AppIDViewAds);
        }
         */
        AliendroidInitialize.SelectAdsUnity(this,Select_Backup_Ads,SettingsAlien.Main_Initialize, Backup_Initialize);

        AlienGDPR.loadGdpr(this,Select_Main_Ads,true);
        AliendroidIntertitial.LoadIntertitialUnity(MainActivity.this,Select_Backup_Ads,MainIntertitial
                ,BackupIntertitial);
        AliendroidReward.LoadRewardUnity(this,Select_Backup_Ads,MainRewards,BackupReward);

    }

    public void BANNER(View view){
        Intent open = new Intent(MainActivity.this,BannerActivity.class);
        startActivity(open);

    }

    public void VIEWADS(View view){
        Intent open = new Intent(MainActivity.this,ViewAdsActivity.class);
        startActivity(open);

    }

    public void NATIVES(View view){
        Intent open = new Intent(MainActivity.this,NativeActivity.class);
        startActivity(open);

    }


    public void MEDIATION(View view){
        Intent open = new Intent(MainActivity.this,MediationAdsActivity.class);
        startActivity(open);

    }

    public void INTERSTITIAL(View view){
        AliendroidIntertitial.ShowIntertitialUnity(MainActivity.this,
                Select_Backup_Ads,MainIntertitial,BackupIntertitial,0
       );
    }

    public void REWARD(View view){
        AliendroidReward.ShowRewardUnity(MainActivity.this,Select_Backup_Ads,MainRewards,BackupReward);
    }

    public void onBackPressed(){
        finishAffinity();
        System.exit(0);
    }
}