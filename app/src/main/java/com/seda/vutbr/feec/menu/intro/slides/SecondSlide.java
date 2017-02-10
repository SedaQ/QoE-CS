package com.seda.vutbr.feec.menu.intro.slides;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seda.vutbr.feec.R;

/**
 * Created by Seda on 9/23/2016.
 */
public class SecondSlide extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO fix it to show youtubefragment here
//        final YouTubeFragment fragment = YouTubeFragment.newInstance("Cwkej79U3ek");
//        getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
        return inflater.inflate(R.layout.intro_slide, container, false);
    }

}
