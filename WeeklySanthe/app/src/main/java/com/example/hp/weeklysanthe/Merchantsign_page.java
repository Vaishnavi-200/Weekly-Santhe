package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 14-03-2023.
 */
public class Merchantsign_page extends AppCompatActivity {
    Button btn_signup1;
    TextView btn_signup2;
    String Mfullname,Mmobile,Memail,Maadharno,Mcity,Mpassword;
    EditText btn_fullname,btn_memail,btn_merchantid,btn_phone,btn_merchantcity,btn_merchantpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merchantsign_page);
        btn_signup1=(Button)findViewById(R.id.btn_msignup);
        btn_signup2=(TextView)findViewById(R.id.btn_msign);
        btn_fullname=(EditText)findViewById(R.id.btn_mname);
        btn_memail=(EditText)findViewById(R.id.btn_memailid);
        btn_merchantid=(EditText)findViewById(R.id.btn_mId);
        btn_phone=(EditText)findViewById(R.id.btn_mno);
        btn_merchantcity=(EditText)findViewById(R.id.btn_mcity);
        btn_merchantpassword=(EditText)findViewById(R.id.btn_mpassword);

        btn_signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Mmobile.length() < 10 || Mpassword.isEmpty()
                        || !Mmobile.matches("^[6-9]\\d{9}")
                        ) {
                    Toast.makeText(Merchantsign_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Merchantsign_page.this, "Login failed", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Merchantsign_page.this, Merchanthome_page.class);
                    startActivity(i);

                }
            }
        });


    }
    //This function is used to post application data to the server using post method and help of retrofit library(HTTP protocol)
    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.Merchantsign_page(
                Mfullname,
                Mmobile,
                Maadharno,
                Memail,
                Mcity,
                Mpassword

        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if (responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if (isSuccess) {

                } else {
                    // Show Creation Failed Message

                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}



