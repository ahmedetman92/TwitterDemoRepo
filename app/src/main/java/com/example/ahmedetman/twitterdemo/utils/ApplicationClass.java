package com.example.ahmedetman.twitterdemo.utils;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

/**
 * Created by Ahmed Etman on 6/24/2017.
 */

public class ApplicationClass extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        // configuring twitter with secretkey and consumer key that could be gotten  from twitter kit
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig
                        (Constant.CONSUMER_KEY,
                                Constant.SECRET_KEY))
                .debug(true)
                .build();
        Twitter.initialize(config);
    }
}
