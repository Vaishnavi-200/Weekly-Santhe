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
public class Fruits_page extends AppCompatActivity {
    Button btn2;
    EditText fn,fp,fd,fc,fl,ff;
    String fn1,fp2,fd3,fc4,fl5,ff6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruits_page);
        btn2=(Button)findViewById(R.id.add2_btn);
        fn=(EditText)findViewById(R.id.e_fm);
        fp=(EditText)findViewById(R.id.e_fm1);
        fd=(EditText)findViewById(R.id.e_fm2);
        fc=(EditText)findViewById(R.id.e_fm3);
        fl=(EditText)findViewById(R.id.e_fm4);
        ff=(EditText)findViewById(R.id.e_fm5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn1 = fn.getText().toString();
                fp2 = fp.getText().toString();
                fd3 = fd.getText().toString();
                fc4 = fc.getText().toString();
                fl5 = fl.getText().toString();
                ff6 = ff.getText().toString();

//                Toast.makeText(Fruits_page.this, "Fruit" + fd3, Toast.LENGTH_SHORT).show();

                if (fn1.isEmpty() || fp2.isEmpty() || fd3.isEmpty() || fc4.isEmpty() || fl5.isEmpty() || ff6.isEmpty()) {
                    Toast.makeText(Fruits_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                } else {
                    CreateUserAccount();
                    Toast.makeText(Fruits_page.this, "Enterd successfully" + " f1" + " f2" + " f3" + " f4" + " f5" + " f6 ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Fruit_display_page.class);
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

        Call<IsExist> call = api.Fruits_page(
                fn1, fp2, fd3, fc4, fl5, ff6
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
