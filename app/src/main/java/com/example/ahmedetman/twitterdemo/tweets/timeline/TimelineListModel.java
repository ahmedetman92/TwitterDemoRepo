package com.example.ahmedetman.twitterdemo.tweets.timeline;

import android.content.Intent;
import android.os.Bundle;

import com.example.ahmedetman.twitterdemo.utils.Constant;

/**
 * Created by Ahmed Etman on 6/27/2017.
 */

public class TimelineListModel
{
    public TimelineListModel()
    {
    }


    /**
     * getting the current authorized user id
     * @param intent
     * @return
     */
    public String getUserId(Intent intent)
    {
        Bundle bundle = intent.getExtras();
        return  (String) bundle.get(Constant.USER_ID);
    }
}
