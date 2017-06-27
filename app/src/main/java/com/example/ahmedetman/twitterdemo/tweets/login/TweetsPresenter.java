package com.example.ahmedetman.twitterdemo.tweets.login;

import android.content.Context;
import android.content.Intent;

import com.example.ahmedetman.twitterdemo.ui.activity.TimelineListActivity;
import com.example.ahmedetman.twitterdemo.utils.Constant;

/**
 * Created by Ahmed Etman on 6/26/2017.
 */

public class TweetsPresenter
{

    View mView;
    TweetsModel tweetsModel;

    /**
     * constructor that takes view
     * @param view
     */
    public TweetsPresenter(View view)
    {
        this.mView = view;
        tweetsModel = new TweetsModel();
        mView.setTwitterLoginButtonClick();
    }

    /**
     * creating new intent and opening tweets list activity with specific user id
     * @param context
     */
    public void openTweetsListActivity(Context context)
    {
        Intent intent = new Intent(context, TimelineListActivity.class);
        intent.putExtra(Constant.USER_ID, tweetsModel.getTwitterSession().getUserName());
        context.startActivity(intent);
    }

    public interface View
    {
        void setTwitterLoginButtonClick();
    }
}
