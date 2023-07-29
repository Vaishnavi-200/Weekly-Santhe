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
public class MerchantLogin_page extends AppCompatActivity {
    TextView mtv_forgot,mtv_new;
    EditText mno,pass;
    Button btn_m1login;
    String mno_m,pass_m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merchantlogin_page);
//        btn_mlogin=(Button)findViewById(R.id.btn_mlogin);
        mtv_forgot=(TextView)findViewById(R.id.mtv_forgot);
        mtv_new=(TextView)findViewById(R.id.mtv_new);
        mno=(EditText)findViewById(R.id.met_login);
        pass=(EditText)findViewById(R.id.met1_login);
        btn_m1login=(Button)findViewById(R.id.m1btn_login);

        mtv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MerchantLogin_page.this,Mforgotpassword_page.class);
                startActivity(i);
                Toast.makeText(MerchantLogin_page.this, "welcome", Toast.LENGTH_SHORT);

            }
        });
        mtv_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MerchantLogin_page.this,Merchantsign_page.class);
                startActivity(i);
                Toast.makeText(MerchantLogin_page.this,"create new account",Toast.LENGTH_SHORT);
            }
        });
        btn_m1login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mno_m = mno.getText().toString();
                pass_m = pass.getText().toString();
                if (mno_m.length() < 10 || pass_m.isEmpty()
                        || !mno_m.matches("^[6-9]\\d{9}")
                        ) {
                    Toast.makeText(MerchantLogin_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MerchantLogin_page.this, "Login sucessfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MerchantLogin_page.this, Merchanthome_page.class);
                    startActivity(i);

                }
            }
        });



}

}
