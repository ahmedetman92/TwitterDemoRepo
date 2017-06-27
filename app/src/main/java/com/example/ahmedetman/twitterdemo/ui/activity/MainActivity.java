package com.example.ahmedetman.twitterdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.example.ahmedetman.twitterdemo.R;
import com.example.ahmedetman.twitterdemo.tweets.login.TweetsPresenter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends AppCompatActivity implements TweetsPresenter.View
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tweetsPresenter = new TweetsPresenter(MainActivity.this);
        scaleViewDown(loginButton,0f,1f,1000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * setting twitter button login, click callback
     */
    @Override
    public void setTwitterLoginButtonClick()
    {
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);

        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                tweetsPresenter.openTweetsListActivity(MainActivity.this);
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });

    }



    /**
     * scaling any view from its 0 collapsed state to normal "opened" state
     * @param v
     * @param startScale
     * @param endScale
     * @param animationDuration
     */
    public void scaleViewDown(final View v, float startScale, float endScale, long animationDuration)
    {
        Animation anim = new ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(animationDuration);
        anim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });
        v.startAnimation(anim);
    }


    public TwitterLoginButton loginButton;
    TweetsPresenter tweetsPresenter;

}
