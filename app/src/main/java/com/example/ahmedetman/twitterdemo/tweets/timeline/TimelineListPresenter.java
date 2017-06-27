package com.example.ahmedetman.twitterdemo.tweets.timeline;

import android.content.Context;
import android.content.Intent;

import com.example.ahmedetman.twitterdemo.ui.activity.UserProfileActivity;
import com.example.ahmedetman.twitterdemo.ui.adapter.TwitterClickableAdapter;
import com.example.ahmedetman.twitterdemo.utils.Constant;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.UserTimeline;

/**
 * Created by Ahmed Etman on 6/27/2017.
 */

public class TimelineListPresenter
{
    TimelineListPresenter.View mView;
    TimelineListModel timelineListModel;
    Intent mIntent;
    Context mContext;

    public TimelineListPresenter(View view, Intent intent, Context context)
    {
        this.mView =  view;
        this.mIntent = intent;
        this.mContext = context;
        timelineListModel =  new TimelineListModel();
    }


    /**
     * getting timeline adapter for specific user
     * @return TwitterClickableAdapter object, in order to set it as adapter for the listview
     */
    public TwitterClickableAdapter getTimelineAdapter()
    {

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(getUserID())
                .build();
        final TwitterClickableAdapter adapter = new TwitterClickableAdapter(mContext, userTimeline,
                new TwitterClickableAdapter.TwitterAdapterClickListener()
                {
                    @Override
                    public void onItemClicked(int position, Tweet tweet)
                    {
                        openAuthorProfile(tweet,mContext);
                    }
                });

        return adapter;
    }


    /**
     * open new activity that includes author profile
     * @param tweet
     */
   public void openAuthorProfile(Tweet tweet, Context context)
    {
        Intent intent = new Intent(context, UserProfileActivity.class);
        intent.putExtra(Constant.USER_SCREEN_ID, tweet.user.screenName);
        context.startActivity(intent);
    }


    /**
     * getting the user id of the authorized user
     * @return
     */
    public String getUserID()
    {
       return timelineListModel.getUserId(mIntent);
    }

    public interface View
    {
        void bindTimelineList();
    }
}
