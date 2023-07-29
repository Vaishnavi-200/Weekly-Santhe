package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 17-03-2023.
 */
public class Mforgotpassword_page extends AppCompatActivity {
 TextView btn_create;
    Button btn_mupdate;
    EditText btn_mobile,btn_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mforgotpassword_page);
        btn_create=(TextView)findViewById(R.id.btn_mcp);
        btn_mobile=(EditText)findViewById(R.id.btn_mphone);
        btn_password=(EditText)findViewById(R.id.btn_mep);
        btn_mupdate=(Button)findViewById(R.id.btn_mupdate);

        btn_mupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mforgotpassword_page.this,MerchantLogin_page.class);
                startActivity(i);
                Toast.makeText(Mforgotpassword_page.this, "welcome back", Toast.LENGTH_SHORT);

            }
        });





    }
}
