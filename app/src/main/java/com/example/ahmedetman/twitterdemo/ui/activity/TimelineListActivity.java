package com.example.ahmedetman.twitterdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ahmedetman.twitterdemo.R;
import com.example.ahmedetman.twitterdemo.tweets.timeline.TimelineListPresenter;
import com.example.ahmedetman.twitterdemo.ui.adapter.TwitterClickableAdapter;

/**
 * Created by Ahmed Etman on 6/26/2017.
 */

public class TimelineListActivity extends AppCompatActivity implements  TimelineListPresenter.View
{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_list_layout);

        timelineListPresenter = new TimelineListPresenter(this,
                getIntent(),TimelineListActivity.this);

        bindTimelineList();
    }

    @Override
    public void bindTimelineList()
    {
        final TwitterClickableAdapter twitterClickableAdapter = timelineListPresenter.getTimelineAdapter();
        listView = (ListView) findViewById(R.id.listView_timeline);
        listView.setAdapter(twitterClickableAdapter);
    }


    TimelineListPresenter timelineListPresenter;
    ListView listView;
}
