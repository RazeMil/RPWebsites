package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webpage extends AppCompatActivity{
    WebView wvURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webpage);

        wvURL = findViewById(R.id.webViewURL);
        wvURL.setWebViewClient(new WebViewClient());

        wvURL.getSettings().setAllowFileAccess(false);
        wvURL.getSettings().setBuiltInZoomControls(true);


        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("URL");
        wvURL.loadUrl(url);

    }
}