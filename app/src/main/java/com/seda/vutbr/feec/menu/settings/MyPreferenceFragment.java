package com.seda.vutbr.feec.menu.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.seda.vutbr.feec.R;

/**
 * Created by Seda on 9/24/2016.
 */
public class MyPreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
