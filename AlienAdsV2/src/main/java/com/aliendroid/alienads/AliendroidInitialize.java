package com.aliendroid.alienads;

import android.app.Activity;
import android.util.Log;

import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.mediation.IInitializationListener;
import com.unity3d.mediation.InitializationConfiguration;
import com.unity3d.mediation.UnityMediation;
import com.unity3d.mediation.errors.SdkInitializationError;


import java.util.Map;


public class AliendroidInitialize {

    public static boolean tesMode;

    public static void SelectAdsAdmob(Activity activity, String selectAdsBackup, String idInitialize) {
        InitializationConfiguration configuration = InitializationConfiguration.builder()
                .setGameId(idInitialize)
                .setInitializationListener(new IInitializationListener() {
                    @Override
                    public void onInitializationComplete() {

                    }
                    @Override
                    public void onInitializationFailed(SdkInitializationError errorCode, String msg) {
                    }
                }).build();
        UnityMediation.initialize(configuration);
    }

    public static void SelectAdsGoogleAds(Activity activity, String selectAdsBackup, String idInitialize) {

    }

    public static void SelectAdsApplovinDis(Activity activity, String selectAdsBackup, String idInitialize) {

    }

    public static void SelectAdsApplovinMax(Activity activity, String selectAdsBackup, String idInitialize) {

    }

    public static void SelectAdsMopub(Activity activity, String selectAdsBackup, String idInitialize, String idInitializeBackupAds) {

    }

    public static void SelectAdsStartApp(Activity activity, String selectAdsBackup, String idInitialize, String idInitializeBackupAds) {
    }

    public static void SelectAdsIron(Activity activity, String selectAdsBackup, String idInitialize, String idInitializeBackupAds) {

    }

    public static void SelectAdsUnity(Activity activity, String selectAdsBackup, String idInitialize, String idInitializeBackupAds) {
        if (BuildConfig.DEBUG) {
            tesMode = true;
        } else {
            tesMode = false;
        }

        IUnityAdsInitializationListener listener = new IUnityAdsInitializationListener() {
            @Override
            public void onInitializationComplete() {

            }

            @Override
            public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {

            }
        };
        UnityAds.initialize(activity, idInitialize, tesMode, listener);

    }


    public static void SelectAdsFAN(Activity activity, String selectAdsBackup, String idInitializeBackupAds) {

    }

    public static void SelectAdsAlienView(Activity activity, String selectAdsBackup, String idInitializeBackupAds) {

    }

    public static void SelectAdsAlienMediation(Activity activity, String selectAdsBackup, String idInitialize, String idInitializeBackupAds) {

    }

}
