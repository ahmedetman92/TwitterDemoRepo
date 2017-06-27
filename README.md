
# Tweets Demo App
This demo allows the users to login to their accounts using Twitter Kit.
User can browse his/her timeline and also see the user’s profile who retweeted or the one who created new tweet.

# Architecture
-	Simple MVP design pattern (Model View Presenter)

# UI
Simple UI consists of three activities:
- One for the login: contains button for twitter login (also there is simple scaling animation).
- Timeline list activity, which show the user’s timeline.
- Users’ profile activity.

# Animation
```Java
 /**

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

…

# Test
Simple Unit test using Junit library

```Java
 /**
@Test
public void getUserID() throws Exception
{
    String str = "id value";
    Assert.assertTrue(!str.isEmpty());

…

# Utils
Which contains ‘ApplicationClass’ that contains Twitter KIT configurations.


