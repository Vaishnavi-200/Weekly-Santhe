package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
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
public class VCS_page extends AppCompatActivity {
    Spinner city;
    String str_cities;
    Button search;
    ListView lv_vcs;

    String[] productvcs;
    List<ChargeArray> productList_vsc;
    ArrayAdapter<String> adaptervcs;

    SharedPrefHandler sharedPrefHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vcs_page);
        sharedPrefHandler=new SharedPrefHandler(this);
        city=(Spinner)findViewById(R.id.sp_vcs);
        search=(Button)findViewById(R.id.btn_search_vcs);
        lv_vcs=(ListView)findViewById(R.id.lv_vcs_v2);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_cities = city.getSelectedItem().toString();
                if (str_cities.isEmpty()){
                    Toast.makeText(VCS_page.this, "Fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    getProductByCode(str_cities);
                    Toast.makeText(VCS_page.this, "selected succsessfully"+str_cities, Toast.LENGTH_SHORT).show();
                }
            }
        });



        lv_vcs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str_vehicle_station_name=lv_vcs.getItemAtPosition(position).toString();

                sharedPrefHandler.setSharedPreferences("stationcharge",str_vehicle_station_name);


                Intent intent=new Intent(getApplication(),Vehicle_charging_station_details.class);
                startActivity(intent);
                finish();


            }
        });
    }
    private void getProductByCode(final  String str_cities) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<ChargeArray>> call = api.getChargeName(str_cities);

        call.enqueue(new Callback<List<ChargeArray>>() {
            @Override
            public void onResponse(Call<List<ChargeArray>> call, Response<List<ChargeArray>> response) {
                // List<Product> responseResult = response.body();
                productList_vsc = response.body();

                Boolean isSuccess = false;
                if(productList_vsc != null) {
                    isSuccess = true;
                }

                if(isSuccess) {

                    // responseResult.getSuccess();
                    // Update all field with result data

                    loadProductListView();

                } else {


                }
            }

            @Override
            public void onFailure(Call<List<ChargeArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        productvcs = new String[productList_vsc.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < productList_vsc.size(); i++) {
            productvcs[i] = productList_vsc.get(i).getstationname();
        }

        adaptervcs = new ArrayAdapter<String>(this, R.layout.listvcs_item, R.id.tv_listitemvcs, productvcs);
        lv_vcs.setAdapter(adaptervcs);





    }
}

