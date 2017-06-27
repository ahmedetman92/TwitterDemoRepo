package com.example.ahmedetman.twitterdemo.tweets.login;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by Ahmed Etman on 6/26/2017.
 */

public class TweetsModel
{

    public TweetsModel()
    {
        getTwitterSession();
    }


    /**
     * getting valid twitter session in order to use it for getting user timeline
     * @return
     */
    public TwitterSession getTwitterSession()
    {
          return TwitterCore.getInstance().getSessionManager().getActiveSession();
    }
}
