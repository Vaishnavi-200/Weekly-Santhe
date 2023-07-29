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
public class Grocery_details extends AppCompatActivity {

    SharedPrefHandler sharedPrefHandler;
    String string_gro;

    String[] productgro;
    List<GroceryArray> productList_gro;
    ArrayAdapter<String> adaptergro;

    TextView t1,t2,t3,t4,t5;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_details);
        sharedPrefHandler=new SharedPrefHandler(this);

        string_gro=sharedPrefHandler.getSharedPreferences("stationcharge");

        getProductByCode(string_gro);

        t1=(TextView)findViewById(R.id.tvg1);
        t2=(TextView)findViewById(R.id.tvg2);
        t3=(TextView)findViewById(R.id.tvg3);
        t4=(TextView)findViewById(R.id.tvg4);
        t5=(TextView)findViewById(R.id.tvg5);
        btn=(Button)findViewById(R.id.btn_get2);
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

        Call<List<GroceryArray>> call = api.getGroDetails(string_gro);

        call.enqueue(new Callback<List<GroceryArray>>() {
            @Override
            public void onResponse(Call<List<GroceryArray>> call, Response<List<GroceryArray>> response) {
                productList_gro = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    t1.setText("station id : " + productList_gro.get(0).getName());
                    t2.setText("station name : " + productList_gro.get(0).getPrice());
                    t3.setText("city : " + productList_gro.get(0).getCity());
                    t4.setText("address : " + productList_gro.get(0).getDate());
                    t5.setText("mobile number : " + productList_gro.get(0).getApmc());

                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<GroceryArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
