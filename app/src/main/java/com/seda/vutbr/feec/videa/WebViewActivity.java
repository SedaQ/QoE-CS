package com.seda.vutbr.feec.videa;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.seda.vutbr.feec.R;
import com.seda.vutbr.feec.endpoints.APIEndPointLogin;
import com.seda.vutbr.feec.endpoints.APIEndPointVidea;
import com.seda.vutbr.feec.endpoints.APIEndPointsREST;
import com.seda.vutbr.feec.utils.ConnectionToRhcloud;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Seda on 11/26/2016.
 */
public class WebViewActivity extends Activity {

    private WebView webView;
    private JSONObject jsonObject = new JSONObject();
    private ConnectionToRhcloud connectionToRhcloud;

    @SuppressLint("SetJavaScriptEnabled")
    public void onCreate(Bundle saveState) {

        super.onCreate(saveState);
        setContentView(R.layout.activity_webview);

        connectionToRhcloud = new ConnectionToRhcloud();

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();git stat
            StrictMode.setThreadPolicy(policy);
        }
        createQuestionaryViaREST();

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webview1);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String url = APIEndPointVidea.ASPEN;
        displayYoutubeVideo.loadUrl(url);
    }

    public void createQuestionaryViaREST(){
        //create JSON File with data and send to RHCloud
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", getIntent().getStringExtra("email"));
            jsonObject.put("age", getIntent().getStringExtra("age"));
            jsonObject.put("gender", getIntent().getStringExtra("gender"));
            jsonObject.put("school",getIntent().getStringExtra("education"));
            jsonObject.put("userConnection", getIntent().getStringExtra("userConnection"));

            connectionToRhcloud.loginAndCreateQuestionary(APIEndPointLogin.LOGIN_URL, APIEndPointsREST.QUESTIONARIES, jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

/*
public class WebViewActivity extends Activity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    public void onCreate(Bundle saveState) {

        super.onCreate(saveState);
        setContentView(R.layout.activity_webview);

        // String frameVideo2 = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/a4NT5iBFuZs?vq=large\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webview1);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String frameVideo = "";
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8"); // in case I'll need a loadData as on frameVideo2
    }
}
*/