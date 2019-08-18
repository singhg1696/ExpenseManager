package com.example.expensemanager.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.expensemanager.R;

public class AboutUs extends AppCompatActivity {

    android.webkit.WebView idWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityaboutus);
        idWebView = findViewById(R.id.idWebView);


        getSupportActionBar().setTitle("Expense Manager");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        idWebView.getSettings().setJavaScriptEnabled(true);
        idWebView.getSettings().setLoadsImagesAutomatically(true);
        idWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        idWebView.setWebViewClient(new WebViewClient());
        idWebView.loadUrl("https://moneylover.me/");
        WebSettings webSettings = idWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
