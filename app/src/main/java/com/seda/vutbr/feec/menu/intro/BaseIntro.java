package com.seda.vutbr.feec.menu.intro;

import android.content.Intent;

import com.github.paolorotolo.appintro.AppIntro;
import com.seda.vutbr.feec.MainActivity;

/**
 * Created by Seda on 9/23/2016.
 * Shared methods between classes
 */
public class BaseIntro extends AppIntro {

    /**
     * go to main activity from app intro
     */
    void loadMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
