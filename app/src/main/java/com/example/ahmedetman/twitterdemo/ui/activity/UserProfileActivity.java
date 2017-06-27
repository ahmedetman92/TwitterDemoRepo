package com.example.ahmedetman.twitterdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.ahmedetman.twitterdemo.R;
import com.example.ahmedetman.twitterdemo.utils.Constant;

public class UserProfileActivity extends AppCompatActivity
{
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        setupWebviewSettings();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String userScreenId = (String) bundle.get(Constant.USER_SCREEN_ID);

        webView.loadUrl(Constant.TWITTER_URL + userScreenId);
    }

    /**
     * configuring the webview
     */
    private void setupWebviewSettings()
    {
        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
