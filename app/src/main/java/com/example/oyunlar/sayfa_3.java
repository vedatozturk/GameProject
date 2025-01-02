package com.example.oyunlar;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class sayfa_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sayfa3);

        TextView aciklama1 = findViewById(R.id.txt_aciklama);
        String video = getIntent().getStringExtra("oyunUrl");
        String aciklama = getIntent().getStringExtra("oyunAciklama");
        aciklama1.setText(aciklama);
        WebView webView = findViewById(R.id.webView);
        webView.loadData(video,"text/html","utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

    }
}