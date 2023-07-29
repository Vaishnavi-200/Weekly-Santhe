package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by HP on 13-03-2023.
 */
public class Chooseamode_page extends AppCompatActivity {
//    Button btn_farmer,btn_mmerchant;
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseamode_page);
        i1=(ImageView)findViewById(R.id.m);
        i2=(ImageView)findViewById(R.id.far);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Chooseamode_page.this,FarmerLogin_page.class);
                startActivity(i);
//                Toast.makeText(Chooseamode_page.this, "welcome", Toast.LENGTH_SHORT).show();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Chooseamode_page.this,MerchantLogin_page.class);
                startActivity(i);
//                Toast.makeText(Chooseamode_page.this, "welcome", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


