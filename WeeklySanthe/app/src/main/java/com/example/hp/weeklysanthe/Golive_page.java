package com.example.hp.weeklysanthe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by HP on 24-03-2023.
 */
public class Golive_page extends AppCompatActivity {
    WebView upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.golive_page);
        upload = (WebView)findViewById(R.id.wv_gl);
        upload.loadUrl(" https://meet.google.com/dwy-esij-ptt");
    }
}
