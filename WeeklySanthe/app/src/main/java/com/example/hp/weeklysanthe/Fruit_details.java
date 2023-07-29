package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 19-03-2023.
 */
public class Fruit_details extends AppCompatActivity {

    SharedPrefHandler sharedPrefHandler;
    String string_fru;

    String[] productfru;
    List<FruitArray> productList_fru;
    ArrayAdapter<String> adapterfru;

    TextView t1,t2,t3,t4,t5;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruits_details);
        sharedPrefHandler=new SharedPrefHandler(this);

        string_fru=sharedPrefHandler.getSharedPreferences("fruits");

        getProductByCode(string_fru);

        t1=(TextView)findViewById(R.id.tvf1);
        t2=(TextView)findViewById(R.id.tvf2);
        t3=(TextView)findViewById(R.id.tvf3);
        t4=(TextView)findViewById(R.id.tvf4);
        t5=(TextView)findViewById(R.id.tvf5);
        btn=(Button)findViewById(R.id.btn_get1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Proceednext_page.class);
                startActivity(i);
            }
        });


    }
    private void getProductByCode(final String string_charge)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<FruitArray>> call = api.getFruDetails(string_fru);

        call.enqueue(new Callback<List<FruitArray>>() {
            @Override
            public void onResponse(Call<List<FruitArray>> call, Response<List<FruitArray>> response) {
                productList_fru = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    t1.setText("station id : " + productList_fru.get(0).getName());
                    t2.setText("station name : " + productList_fru.get(0).getPrice());
                    t3.setText("city : " + productList_fru.get(0).getCity());
                    t4.setText("address : " + productList_fru.get(0).getDate());
                    t5.setText("mobile number : " + productList_fru.get(0).getApmc());

                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<FruitArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
