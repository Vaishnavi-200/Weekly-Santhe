package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 24-03-2023.
 */
public class Payment_page extends AppCompatActivity {
    ImageView py,gp;
    TextView g,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_page);
//        g=(TextView)findViewById(R.id.name);
        py=(ImageView)findViewById(R.id.pay);
//        gp=(ImageView)findViewById(R.id.m_gpy);
        py.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
//                    Toast.makeText(Payment_page.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(Payment_page.this, "I clicked on PhonePe", Toast.LENGTH_SHORT).show();

            }
        });
//        gp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user");
//                if (launchIntent != null) {
//                    startActivity(launchIntent);
//                } else {
////                    Toast.makeText(Payment_page.this, "There is no package available in android", Toast.LENGTH_LONG).show();
//                }
//                Toast.makeText(Payment_page.this, "I clicked on PhonePe", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}
