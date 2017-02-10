package com.seda.vutbr.feec.menu.intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.seda.vutbr.feec.R;
import com.seda.vutbr.feec.menu.intro.slides.SampleSlide;
import com.seda.vutbr.feec.menu.intro.slides.SecondSlide;

/**
 * Created by Seda on 9/23/2016.
 */
public final class DefaultIntro extends BaseIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(SampleSlide.newInstance(R.layout.intro));
        //addSlide(SampleSlide.newInstance(R.layout.intro4));
        addSlide(new SecondSlide());
        // Hide Skip/Done button.
        //showSkipButton(false);
        //setProgressButtonEnabled(false);

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        loadMainActivity();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        loadMainActivity();
        //Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    public void getStarted(View v) {
        loadMainActivity();
    }
}