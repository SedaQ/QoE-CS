package com.seda.vutbr.feec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.seda.vutbr.feec.menu.intro.DefaultIntro;
import com.seda.vutbr.feec.menu.settings.MyPreferencesActivity;
import com.seda.vutbr.feec.youtube.WebViewActivity;
import com.seda.vutbr.feec.youtube.YouTubeActivity;
import com.seda.vutbr.feec.youtube.website.Search;

public class MainActivity extends AppCompatActivity {

    TextView count;
    private Button playVideo;
    private Button webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playVideoButtonListener();

        //using iframe
        playVideoWebViewButton();

    }

    private void playVideoWebViewButton() {
        webView = (Button) findViewById(R.id.webViewButton);
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new  Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(intent1);
            }
        });
    }

    public void playVideoButtonListener(){
        playVideo = (Button) findViewById(R.id.playVideoButton);
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), YouTubeActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add:
                return(true);
            case R.id.reset:
                return(true);
            case R.id.start_intro:
                Intent intent = new Intent(this, DefaultIntro.class);
                startActivity(intent);
                finish();
                return(true);
            case R.id.start_youtube:
                Intent startYoutube = new Intent(this, Search.class);
                startActivity(startYoutube);
                finish();
                return(true);
            case R.id.settings:
                Intent settings = new Intent(this, MyPreferencesActivity.class);
                startActivity(settings);
                finish();
//                SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//                String strUserName = SP.getString("username", "NA");
//                boolean bAppUpdates = SP.getBoolean("applicationUpdates",false);
//                String downloadType = SP.getString("downloadType","1");

            case R.id.about:
                Toast.makeText(this, R.string.about_toast, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.exit:
                finish();
                return(true);
            default:
                return(super.onOptionsItemSelected(item));
        }
    }


}
