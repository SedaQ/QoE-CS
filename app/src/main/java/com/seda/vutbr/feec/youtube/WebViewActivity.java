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

        //width=\"420\" height=\"315\"
        //width="100%" height="25%"
        //"<style>#myFrame { width:100%; height:50%; }</style>"+
//        String frameVideo = "<html>" +
//                "<body>"+
//                "<div class=\"container\">"+
//                "<div class=\"h_iframe\""+
//                "<iframe src=\"https://www.youtube.com/embed/5Fmf3D9oNn4?vq=hd1080\" frameborder=\"0\" allowfullscreen></iframe>" +
//                "</div>"+
//                //defining CSS
//                "<style>html,body {\n" +
//                "    height:100%;\n" +
//                "}\n" +
//                ".h_iframe iframe {\n" +
//                "    position:absolute;\n" +
//                "    top:0;\n" +
//                "    left:0;\n" +
//                "    width:100%;\n" +
//                "    height:100%;\n" +
//                "}</style>"+
//                "</body>" +
//                "</html> ";

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

        //displayYoutubeVideo.loadData(frameVideo2, "text/html", "utf-8"); // in case I'll need a loadData as on frameVideo2

        String url = "http://qoe-qtestq.rhcloud.com/root/videa/aspen";
        displayYoutubeVideo.loadUrl(url);

        //String frameVideo2 ="<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/5Fmf3D9oNn4?vq=small\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        //displayYoutubeVideo.loadData(frameVideo2, "text/html", "utf-8");

    }

}
