package com.varunest.sample;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.joaquimley.faboptions.FabOptions;
import com.varunest.sample.sparkbutton.R;
import com.varunest.sparkbutton.SparkButton;

import java.io.IOException;

public class DemoActivity extends AppCompatActivity {
    private ViewPager showcaseViewpager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private HTextView heart_textView, textView, starTextView1, happyBirthday;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(DemoActivity.this, R.raw.happybirthday);
                if(mp.isPlaying())
                {
                    mp.stop();
                }
                else {
                    mp.start();
                    /*fab.setClickable(false);
                    mp.start();*/
                }
            }
        });


        /*FabOptions fab = (FabOptions) findViewById(R.id.fab_options);

        fab.setButtonsMenu(this, R.menu.menu_faboptions);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                MediaPlayer mp = MediaPlayer.create(DemoActivity.this, R.raw.happybirthday);
                if(mp.isPlaying())
                {
                    mp.stop();
                }
                else {
                    mp.start();
                }

            }
        });*/

        initWidgets();
        initAnimation();



    }

    private void initAnimation() {
        showcaseViewpager.postDelayed(new Runnable() {
            @Override
            public void run() {
                View starLayout = getViewFromPosition(0);
                if (starLayout != null) {
                    playStarAnimation(starLayout);
                }
            }
        }, 500);
    }

    private void initWidgets() {
        showcaseViewpager = (ViewPager) findViewById(R.id.showcase_viewpager);
        pagerAdapter = new ScreenSlidePagerAdapter(DemoActivity.this);
        showcaseViewpager.setAdapter(pagerAdapter);
        showcaseViewpager.addOnPageChangeListener(getOnPageChangeListener());
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        /*setSupportActionBar(toolbar);*/
        tabLayout.setupWithViewPager(showcaseViewpager);



    }

    @NonNull
    private ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                View view = getViewFromPosition(position);
                if (view != null) {
                    switch (position) {
                        case 0:
                            playStarAnimation(view);
                            break;
                        case 1:
                            playHeartAnimation(view);
                            break;
                        case 2:
                            playFacebookAnimation(view);
                            break;
                        case 3:
                            playTwitterAnimation(view);
                            break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    private View getViewFromPosition(int position) {
        View view = null;
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            view = showcaseViewpager.findViewWithTag(String.valueOf(position));
            if (view != null) {
                break;
            }
        }
        return view;
    }

    private void playHeartAnimation(final View heartLayout) {


        imageView = (ImageView) heartLayout.findViewById(R.id.image_heart);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.bd_anim).into(imageViewTarget);

        ((SparkButton) heartLayout.findViewById(R.id.heart_button)).playAnimation();

        ((SparkButton) heartLayout.findViewById(R.id.sweetheart_button)).playAnimation();

        ((SparkButton) heartLayout.findViewById(R.id.facebook_button)).playAnimation();

        heart_textView = (HTextView) heartLayout.findViewById(R.id.heart_textView);
        heart_textView.setTextColor(Color.parseColor("#ea0d3d"));
        heart_textView.setAnimateType(HTextViewType.RAINBOW);
        heart_textView.animateText("HappY BirthDaY HoneY");

    }

    private void playStarAnimation(final View starLayout) {

      /*  starTextView1 = (HTextView) starLayout.findViewById(R.id.star_textview1);
        starTextView1.setTextColor(Color.parseColor("#000000"));
        starTextView1.setAnimateType(HTextViewType.LINE);
        starTextView1.setSingleLine(false);
        starTextView1.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);*/


       /* starTextView1.animateText("Highly customizable");*/
       /* starTextView1.setAnimateType(HTextViewType.TYPER);
        starTextView1.setAnimateType(HTextViewType.RAINBOW);*/
       /* starTextView1.animateText("Hello Everyone!! Whazzup");*/


        happyBirthday = (HTextView) starLayout.findViewById(R.id.happy_birthday);
        happyBirthday.setTextColor(Color.parseColor("#ffffff"));

        happyBirthday.setTypeface(null);
        /*textView.setAnimateType(HTextViewType.ANVIL);
        textView.setAnimateType(HTextViewType.TYPER);*/
        happyBirthday.setAnimateType(HTextViewType.RAINBOW);
        happyBirthday.animateText("HappY BirthDaY Beloved SweetHearT");

        /*happyBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(DemoActivity.this, R.raw.happybirthday);
                if(mp.isPlaying())
                {
                    mp.stop();
                }
                else {
                    mp.start();
                    *//*fab.setClickable(false);
                    mp.start();*//*
                }
            }
        });*/

        ((SparkButton) starLayout.findViewById(R.id.twitter_button)).playAnimation();
        starLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(DemoActivity.this, R.raw.happybirthday);
                if(mp.isPlaying())
                {
                    mp.stop();
                }
                else {
                    mp.start();
                }
            }
        });


    }

    private void playFacebookAnimation(View facebookLayout) {


         ((SparkButton) facebookLayout.findViewById(R.id.star_button2)).setChecked(true);
        ((SparkButton) facebookLayout.findViewById(R.id.star_button2)).playAnimation();
        ((SparkButton) facebookLayout.findViewById(R.id.star_button1)).setChecked(true);
        ((SparkButton) facebookLayout.findViewById(R.id.star_button1)).playAnimation();

        //  ((SparkButton) starLayout.findViewById(R.id.star_button3)).setChecked(false);
        ((SparkButton) facebookLayout.findViewById(R.id.star_button3)).setChecked(true);
        ((SparkButton) facebookLayout.findViewById(R.id.star_button3)).playAnimation();
        ((SparkButton) facebookLayout.findViewById(R.id.star_buttons2)).setChecked(true);
        ((SparkButton) facebookLayout.findViewById(R.id.star_buttons2)).playAnimation();


    }

    private void playTwitterAnimation(View twitterLayout) {





         imageView = (ImageView) twitterLayout.findViewById(R.id.image_heart);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.bd_gift).into(imageViewTarget);

        ((SparkButton) twitterLayout.findViewById(R.id.heart_button)).setChecked(true);
       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((SparkButton) twitterLayout.findViewById(R.id.heart_button)).setChecked(true);
                ((SparkButton) twitterLayout.findViewById(R.id.heart_button)).playAnimation();
            }
        }, 300);*/

        ((SparkButton) twitterLayout.findViewById(R.id.heart_button)).playAnimation();

        ((SparkButton) twitterLayout.findViewById(R.id.sweetheart_button)).playAnimation();

        ((SparkButton) twitterLayout.findViewById(R.id.facebook_button)).playAnimation();

        heart_textView = (HTextView) twitterLayout.findViewById(R.id.heart_textView);
        heart_textView.setTextColor(Color.parseColor("#ea0d3d"));
        heart_textView.setAnimateType(HTextViewType.TYPER);
        heart_textView.animateText("HappY BirthDaY SweetHearT");
        heart_textView.setSingleLine(false);
        heart_textView.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);

        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.devoted_name:
                new AlertDialog.Builder(this)
                        .setTitle("Dedicated To....")
                        .setMessage(
                                "My Beloved Adorable Birthday Queen\n\n" +
                                        "Marufa Akter Leena\n")
                        .setPositiveButton("OK", null)
                        .show();
                return true;

            case R.id.about:
                new AlertDialog.Builder(this)
                        .setTitle("Developed by : Tech_Nerds")
                        .setMessage(
                                "Email : technerds1993@gmail.com\n\n" +
                                        "Blog : https://mhraju.github.io\n")
                        .setPositiveButton("OK", null)
                        .show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
