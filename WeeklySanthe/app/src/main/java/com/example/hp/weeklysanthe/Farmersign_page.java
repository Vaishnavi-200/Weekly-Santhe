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
public class Farmersign_page extends AppCompatActivity {
    TextView btn_sign;
    EditText btn_name,btn_no,btn_password,btn_city,btn_id,btn_aadhar;
    String fullname,mobile,email,aadharno,city,password;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmersign_page);
        btn_sign=(TextView)findViewById(R.id.btn_fsignup);
        btn_signup=(Button)findViewById(R.id.btn_fsignup1);
        btn_name=(EditText)findViewById(R.id.btn_fname);
        btn_no=(EditText)findViewById(R.id.btn_fmobile);
        btn_password=(EditText)findViewById(R.id.btn_password);
        btn_city=(EditText)findViewById(R.id.btn_city);
        btn_aadhar=(EditText)findViewById(R.id.btn_faadhar);
        btn_id=(EditText)findViewById(R.id.btn_femail);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Farmersign_page.this,FarmerLogin_page.class);
                startActivity(i);
                Toast.makeText(Farmersign_page.this,"welcome back",Toast.LENGTH_SHORT);

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

        Call<IsExist> call = api.Farmersign_page(
                fullname,
                mobile,
                aadharno,
                email,
                city,
                password

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
