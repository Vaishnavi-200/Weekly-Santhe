package com.example.hp.weeklysanthe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by HP on 23-03-2023.
 */
public class Googleform_page extends AppCompatActivity {
    WebView upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googleform_page);
        upload = (WebView) findViewById(R.id.wv_gf);
        upload.loadUrl("https://forms.gle/aPEpm4zbq8sAbwfk7");
    }
}
