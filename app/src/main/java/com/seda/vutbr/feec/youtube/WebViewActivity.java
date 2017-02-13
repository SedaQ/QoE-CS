package com.seda.vutbr.feec.youtube;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.seda.vutbr.feec.R;


/**
 * Created by Seda on 11/26/2016.
 */
public class WebViewActivity extends Activity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    public void onCreate(Bundle saveState) {

        super.onCreate(saveState);
        setContentView(R.layout.activity_webview);

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webview1);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String url = "http://qoe-qtestq.rhcloud.com/root/videa/aspenvidea";
        displayYoutubeVideo.loadUrl(url);
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