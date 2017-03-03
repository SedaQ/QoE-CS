package com.seda.vutbr.feec.videa.website;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.seda.vutbr.feec.R;

/**
 * Created by Seda on 10/20/2016.
 */
public class Player extends YouTubeBaseActivity implements OnInitializedListener {

    private YouTubePlayerView playerView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_player);

        playerView = (YouTubePlayerView)findViewById(R.id.player_view);
        playerView.initialize(getString(R.string.YOUTUBE_API_KEY), this);
    }

    @Override
    public void onInitializationFailure(Provider provider,
                                        YouTubeInitializationResult result) {
        Toast.makeText(this, getString(R.string.failed), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player,
                                        boolean restored) {
        Log.i(SEARCH_SERVICE,"On success method called, test is:" + getIntent().getStringExtra("VIDEO_ID"));
        if(!restored){
            player.cueVideo(getIntent().getStringExtra("VIDEO_ID"));
//            player.loadVideo(getIntent().getStringExtra("VIDEO_ID"));
        } else {
            Toast.makeText(this, getString(R.string.failed), Toast.LENGTH_LONG).show();
        }
    }
}
