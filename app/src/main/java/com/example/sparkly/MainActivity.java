package com.example.sparkly;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
private WebView Sweet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        isNetworkConnectionIsAvailable();

            Sweet = (WebView) findViewById(R.id.webView);
            WebSettings webSettings = Sweet.getSettings();
            webSettings.setJavaScriptEnabled(true);
            Sweet.loadUrl("http://dolcihub.online/");
            Sweet.setWebViewClient(new WebViewClient());


        }

    @Override
    public void onBackPressed(){
        if(Sweet.canGoBack()) {
            Sweet.goBack();
        }else {
            super.onBackPressed();
        }

    }


public void checkNetworkConnection() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("No Internet Connection");
    builder.setMessage("please turn on Internet connection");
    builder.setNegativeButton("close",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    finish();

                }
            });
           AlertDialog alertDialog = builder.create();
           alertDialog.show();
}

    private boolean isNetworkConnectionIsAvailable() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnected();
        if (isConnected){
            Log.d("Network", "Connected");
            return true;
        }
        else {

            checkNetworkConnection();
            Log.d("Network", "Not Connected");
            return false;
        }

    }

    }
