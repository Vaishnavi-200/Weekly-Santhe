package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 25-03-2023.
 */
public class Vehicle_charging_station_details extends AppCompatActivity {

    SharedPrefHandler sharedPrefHandler;
    String string_charge;

    String[] productvcs;
    List<ChargeArray> productList_vsc;
    ArrayAdapter<String> adaptervcs;

    TextView t1,t2,t3,t4,t5,t6,t7;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_charging_station_details);
        sharedPrefHandler=new SharedPrefHandler(this);

        string_charge=sharedPrefHandler.getSharedPreferences("stationcharge");

        getProductByCode(string_charge);

        t1=(TextView)findViewById(R.id.tv_vcs);
        t2=(TextView)findViewById(R.id.tv2_vcs);
        t3=(TextView)findViewById(R.id.tv3_vcs);
        t4=(TextView)findViewById(R.id.tv4_vcs);
        t5=(TextView)findViewById(R.id.tv5_vcs);
        t6=(TextView)findViewById(R.id.tv6_vcs);
        t7=(TextView)findViewById(R.id.tv7_vcs);
        btn=(Button)findViewById(R.id.btn_get);
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

        Call<List<ChargeArray>> call = api.getChargeDetails(string_charge);

        call.enqueue(new Callback<List<ChargeArray>>() {
            @Override
            public void onResponse(Call<List<ChargeArray>> call, Response<List<ChargeArray>> response) {
                productList_vsc = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    t1.setText("APMC id : "+productList_vsc.get(0).getstationid());
                    t2.setText("Vegetable name : "+ productList_vsc.get(0).getstationname());
                    t3.setText("city : "+ productList_vsc.get(0).getcity());
                    t4.setText("address : " + productList_vsc.get(0).getaddress());
                    t5.setText("mobile number : "+productList_vsc.get(0).getmno());
                    t6.setText("APMC details : "+productList_vsc.get(0).getportdetails());
                    t7.setText("Rupees :"+productList_vsc.get(0).getchargingcharge());


                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<ChargeArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

