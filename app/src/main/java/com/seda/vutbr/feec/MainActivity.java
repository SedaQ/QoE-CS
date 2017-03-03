package com.seda.vutbr.feec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.seda.vutbr.feec.endpoints.APIEndPointLogin;
import com.seda.vutbr.feec.endpoints.APIEndPointsREST;
import com.seda.vutbr.feec.menu.intro.DefaultIntro;
import com.seda.vutbr.feec.menu.settings.MyPreferencesActivity;
import com.seda.vutbr.feec.utils.ConnectionToRhcloud;
import com.seda.vutbr.feec.videa.WebViewActivity;
import com.seda.vutbr.feec.videa.website.Search;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private Button playVideo;
    private Button webView;
    private EditText emailAddress;
    private EditText age;
    private EditText education;
    private EditText userConnection;
    private RadioGroup radioGroup;
    private RadioButton gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] gender = getResources().getStringArray(R.array.gender);
        //this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.textview, gender));

        //using iframe
        playVideoWebViewButton();

        //using android video
        //playVideoButtonListener();
        //getInformationFromQuestionary();
        //setTextChangeListeners();
    }

    private void setTextChangeListeners(){
        emailAddress.addTextChangedListener(this);
        age.addTextChangedListener(this);
        education.addTextChangedListener(this);
        userConnection.addTextChangedListener(this);
    }

    private void getInformationFromQuestionary(){
        emailAddress = (EditText) findViewById(R.id.emailAddress);
        age = (EditText) findViewById(R.id.age);
        education = (EditText) findViewById(R.id.education);
        userConnection = (EditText) findViewById(R.id.userConnection);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupGender);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(selectedId);
    }

    private void playVideoWebViewButton() {
        webView = (Button) findViewById(R.id.webViewButton);
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromQuestionary();

                Intent i = new  Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("email", emailAddress.getText().toString());
                i.putExtra("age", age.getText().toString());
                i.putExtra("gender", gender.getText().toString());
                i.putExtra("education", education.getText().toString());
                i.putExtra("userConnection", userConnection.getText().toString());
                startActivity(i);
            }
        });
    }

    /*
    public void playVideoButtonListener(){
        playVideo = (Button) findViewById(R.id.playVideoButton);
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), YouTubeActivity.class));
            }
        });
    }*/

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


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editTextField) {
        if(editTextField == emailAddress.getEditableText()){
            String text = emailAddress.getText().toString();
            if(!isValidEmail(text)){
                Toast.makeText(getApplicationContext(), "Setted email address must be real..", Toast.LENGTH_SHORT);
            }
        } else if(editTextField == age.getEditableText()){

        } else if(editTextField == education.getEditableText()){

        } else if(editTextField == userConnection.getEditableText()){

        }
        String emailAddressTemp;
        String ageTemp;
        String educationTemp;
        String userConnectionTemp;
    }

    public boolean isValidEmail(String string){
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
