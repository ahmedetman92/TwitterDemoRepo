package com.example.ahmedetman.twitterdemo.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.Timeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;


public class TwitterClickableAdapter extends TweetTimelineListAdapter {

    private final TwitterAdapterClickListener twitterAdapterClickListener;
    Context context;
    /**
     * Constructs a TweetTimelineListAdapter for the given Tweet Timeline.
     *
     * @param context  the context for row views.
     * @param timeline a Timeline&lt;Tweet&gt; providing access to Tweet data items.
     * @throws IllegalArgumentException if timeline is null
     */
    public TwitterClickableAdapter(Context context, Timeline<Tweet> timeline,
                                   TwitterAdapterClickListener twitterAdapterClickListener) {
        super(context, timeline);
        this.context = context;
        this.twitterAdapterClickListener = twitterAdapterClickListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rootView = super.getView(position, convertView, parent);

        final Tweet tweet = getItem(position);

        if(rootView instanceof ViewGroup){
            disableChildListeners((ViewGroup) rootView);
        }

        //enable root view and attach custom listener
        rootView.setEnabled(true);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(twitterAdapterClickListener != null){
                    twitterAdapterClickListener.onItemClicked(position, tweet);
                }
            }
        });

        return rootView;
    }

    private void disableChildListeners(ViewGroup parent){
        parent.setEnabled(false);

        for(int x =0; x < parent.getChildCount() ; x++){

            View view = parent.getChildAt(x);

            if(view instanceof ViewGroup){
                disableChildListeners((ViewGroup) view);
            }else{
                view.setEnabled(false);
                view.setClickable(false);
                view.setLongClickable(false);
            }
        }
    }

    public interface TwitterAdapterClickListener{
        void onItemClicked(int position, Tweet tweet);
    }
}
