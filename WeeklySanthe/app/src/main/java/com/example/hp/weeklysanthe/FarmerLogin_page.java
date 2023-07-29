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
 * Created by HP on 07-09-2022.
 */
public class FarmerLogin_page extends AppCompatActivity {
    TextView login,createnewacc,forgetpass;
    EditText mno;
    EditText pass;
    Button btn_log;
    String mno_s,pass_s;
    String str_shr_mno,str_shr_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmerlogin_page);
        login=(TextView)findViewById(R.id.btn_11);
        createnewacc=(TextView)findViewById(R.id.btn_16);
        forgetpass=(TextView)findViewById(R.id.btn_14);
        mno=(EditText)findViewById(R.id.btn_12);
        pass=(EditText)findViewById(R.id.btn_13);
        btn_log=(Button)findViewById(R.id.btn_15);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mno_s=mno.getText().toString();
                pass_s=pass.getText().toString();
                if (mno_s.length()<10 || pass_s.isEmpty()
                        ||!mno_s.matches("^[6-9]\\d{9}")
                        ){
                    Toast.makeText(FarmerLogin_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                }
                else{
//                    Toast.makeText(FarmerLogin_page.this, "Login failed", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(FarmerLogin_page.this,Farmerhome_page.class);
                    startActivity(i);

                }
            }
        });
        createnewacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerLogin_page.this,Farmersign_page.class);
                startActivity(i);
//                Toast.makeText(FarmerLogin_page.this,"Create new account",Toast.LENGTH_SHORT);
            }
        });
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(FarmerLogin_page.this,Forgotpassword_page.class);
                startActivity(i);
//                Toast.makeText(FarmerLogin_page.this,"Enter details",Toast.LENGTH_SHORT);
            }
        });

    }
}
