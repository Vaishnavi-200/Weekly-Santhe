package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HP on 24-03-2023.
 */
public class Contactus_page extends AppCompatActivity {
    ImageView calladmin;
    ImageView calltechni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_page);
        calladmin=(ImageView)findViewById(R.id.img);
        calltechni=(ImageView)findViewById(R.id.img1);
        calladmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:6360775210"));
                startActivity(intent);
            }
        });
        calltechni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9686057088"));
                startActivity(intent);
            }
        });
    }
}
