package com.example.administrator.copyothersd.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.copyothersd.R;

public class ShowMore extends AppCompatActivity {
   String url;
   private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_more);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        url = intent.getStringExtra("wow");
        webView = findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
