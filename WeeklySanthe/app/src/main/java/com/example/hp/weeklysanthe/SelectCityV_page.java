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
 * Created by HP on 20-03-2023.
 */
public class SelectCityV_page extends AppCompatActivity {
    Spinner city;
    String str_veg;
    Button s;
    ListView lv_veg;

    String[] productveg;
    List<VegetableArray> productList_veg;
    ArrayAdapter<String> adapterveg;

    SharedPrefHandler sharedPrefHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcityv_page);
        sharedPrefHandler=new SharedPrefHandler(this);
        city=(Spinner)findViewById(R.id.city);
        s=(Button)findViewById(R.id.btn_search);
        lv_veg=(ListView)findViewById(R.id.lv_veg);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_veg = city.getSelectedItem().toString();
                if (str_veg.isEmpty()){
                    Toast.makeText(SelectCityV_page.this, "Fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
//                    getProductByCode(str_veg);
                    Toast.makeText(SelectCityV_page.this, "selected succsessfully"+str_veg, Toast.LENGTH_SHORT).show();
                }
            }
        });



        lv_veg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str_vegtable_name=lv_veg.getItemAtPosition(position).toString();

                sharedPrefHandler.setSharedPreferences("vegetable",str_vegtable_name);


                Intent intent=new Intent(getApplication(),Vegetables_details.class);
                startActivity(intent);
                finish();


            }
        });
    }
//    private void getProductByCode(final  String str_cities) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
//                .build();
//
//        Api api = retrofit.create(Api.class);
//
//        Call<List<VegetableArray>> call = api.getVegName(str_cities);
//
//        call.enqueue(new Callback<List<VegetableArray>>() {
//            @Override
//            public void onResponse(Call<List<VegetableArray>> call, Response<List<VegetableArray>> response) {
//                // List<Product> responseResult = response.body();
//                productList_veg = response.body();
//
//                Boolean isSuccess = false;
//                if(productList_veg != null) {
//                    isSuccess = true;
//                }
//
//                if(isSuccess) {
//
//                    // responseResult.getSuccess();
//                    // Update all field with result data
//
//                    loadProductListView();
//
//                } else {
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<VegetableArray>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//
//
//
//
//    private void loadProductListView() {
//        //Creating an String array for the ListView
//        productveg = new String[productList_veg.size()];
//
//
//
//        //looping through all the products and inserting the names inside the string array
//        for (int i = 0; i < productList_veg.size(); i++) {
//            productveg[i] = productList_veg.get(i).getName();
//        }
//
//        adapterveg = new ArrayAdapter<String>(this, R.layout.list_city, R.id.tv_listcity, productveg);
//        lv_veg.setAdapter(adapterveg);
//
//
//
//
//
//    }

}

