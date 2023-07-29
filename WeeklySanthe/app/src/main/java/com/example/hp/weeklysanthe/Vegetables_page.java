package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 24-03-2023.
 */
public class Vegetables_page extends AppCompatActivity {
    Button btn1;
    EditText vn,vp,vd,vc,vl,vv;
    String vn1,vp2,vd3,vc4,vl5,vv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetables_page);
        btn1=(Button)findViewById(R.id.add1_btn);
        vn=(EditText)findViewById(R.id.e_vm);
        vp=(EditText)findViewById(R.id.e_vm1);
        vd=(EditText)findViewById(R.id.e_vm2);
        vc=(EditText)findViewById(R.id.e_vm3);
        vl=(EditText)findViewById(R.id.e_vm4);
        vv=(EditText)findViewById(R.id.e_vm5);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vn1=vn.getText().toString();
                vp2=vp.getText().toString();
                vd3=vd.getText().toString();
                vc4=vc.getText().toString();
                vl5=vl.getText().toString();
                vv6=vv.getText().toString();



//                Toast.makeText(Vegetables_page.this, "Veg" + vd3, Toast.LENGTH_SHORT).show();


                if (vn1.isEmpty()||vp2.isEmpty()||vd3.isEmpty()||vc4.isEmpty()||vl5.isEmpty()||vv6.isEmpty()){
                    Toast.makeText(Vegetables_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    CreateUserAccount();
                    Toast.makeText(Vegetables_page.this, "Enterd successfully"+" v1"+" v2"+" v3"+" v4"+" v5"+" v6 ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Veg_display_page.class);
                    startActivity(i);

                }

            }
        });


    }
    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.Vegetables_page(
                vn1,vp2,vd3,vc4,vl5,vv6
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
