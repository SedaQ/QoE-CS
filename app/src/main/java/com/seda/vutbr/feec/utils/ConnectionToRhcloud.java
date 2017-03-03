package com.seda.vutbr.feec.utils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Seda on 2/22/2017.
 */

public class ConnectionToRhcloud extends AsyncTask<String, Void, String> {

    private HttpsURLConnection conn;

    public ConnectionToRhcloud(){
        CookieHandler.setDefault(new CookieManager());
        conn = null;
    }

    @Override
    protected String doInBackground(String... params) {
        String postParams = "username=kovacd@feec.vutbr.cz&password=admin";
        loginToQoEServer(params[0], postParams);
        createNewEntity(params[1], params[2]);
        return null;
    }

    public void loginAndCreateQuestionary(String loginUrl, String createQuestionaryUrl, String json){
       doInBackground(loginUrl,createQuestionaryUrl,json);
    }

    public void createNewEntity(String url, String json) {
        try {
            URL obj = new URL(url);
            conn = (HttpsURLConnection) obj.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes("UTF-8"));
            os.close();

            int responseCode = conn.getResponseCode();
        } catch(IOException io){
            System.out.println(io);
        }
    }

    public void loginToQoEServer(String url, String postParams) {
        try {
            URL obj = new URL(url);
            conn = (HttpsURLConnection) obj.openConnection();

            conn.setUseCaches(false);
            conn.setRequestMethod("POST");

            conn.setDoOutput(true);

            // Send post request
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + postParams);
            System.out.println("Response Code : " + responseCode);
        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    public HttpsURLConnection getConn() {
        return conn;
    }

    public void setConn(HttpsURLConnection conn) {
        this.conn = conn;
    }
}
