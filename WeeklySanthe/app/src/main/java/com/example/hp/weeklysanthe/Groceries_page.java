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
public class Groceries_page extends AppCompatActivity {
    Button btn3;
    EditText gn,gp,gd,gc,gl,gg;
    String g1,g2,g3,g4,g5,g6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groceries_page);
        gn=(EditText)findViewById(R.id.e_gm);
        gp=(EditText)findViewById(R.id.e_gm1);
        gd=(EditText)findViewById(R.id.e_gm2);
        gc=(EditText)findViewById(R.id.e_gm3);
        gl=(EditText)findViewById(R.id.e_gm4);
        gg=(EditText)findViewById(R.id.e_gm5);
        btn3=(Button)findViewById(R.id.add3_btn);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g1 = gn.getText().toString();
                g2 = gp.getText().toString();
                g3 = gd.getText().toString();
                g4 = gc.getText().toString();
                g5 = gl.getText().toString();
                g6 = gg.getText().toString();

//                Toast.makeText(Groceries_page.this, "Grocery" + g3, Toast.LENGTH_SHORT).show();

                if (g1.isEmpty() || g2.isEmpty() || g3.isEmpty() || g4.isEmpty() || g5.isEmpty() || g6.isEmpty()) {
                    Toast.makeText(Groceries_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                } else {
                    CreateUserAccount();
                    Toast.makeText(Groceries_page.this, "Enterd successfully" + " v1" + " v2" + " v3" + " v4" + " v5" + " v6 ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Grocery_display_page.class);
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

        Call<IsExist> call = api.Groceries_page(
                g1,g2,g3,g4,g5,g6
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
