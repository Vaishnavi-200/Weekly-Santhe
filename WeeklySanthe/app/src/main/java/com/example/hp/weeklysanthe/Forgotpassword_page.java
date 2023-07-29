package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 13-03-2023.
 */
public class Forgotpassword_page extends AppCompatActivity {
    TextView btn_cp;
    EditText btn_mp,btn_ep;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword_page);
        btn_cp=(TextView)findViewById(R.id.btn_cp);
        btn_mp=(EditText)findViewById(R.id.btn_mp);
        btn_ep=(EditText)findViewById(R.id.btn_ep);
        btn_update=(Button)findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Forgotpassword_page.this, FarmerLogin_page.class);
                startActivity(i);
                Toast.makeText(Forgotpassword_page.this, "welcome back", Toast.LENGTH_SHORT);

            }
        });





    }
}

