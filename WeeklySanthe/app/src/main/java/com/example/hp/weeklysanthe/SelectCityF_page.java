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
public class SelectCityF_page extends AppCompatActivity {
    Spinner city;
    String str_fruit;
    Button s;
    ListView lv_fru;

    String[] productfru;
    List<FruitArray> productList_fru;
    ArrayAdapter<String> adapterfru;

    SharedPrefHandler sharedPrefHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcityf_page);
        sharedPrefHandler=new SharedPrefHandler(this);
        city=(Spinner)findViewById(R.id.cityf);
        s=(Button)findViewById(R.id.btn_searchf);
        lv_fru=(ListView)findViewById(R.id.lv_fru);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_fruit = city.getSelectedItem().toString();
                if (str_fruit.isEmpty()){
                    Toast.makeText(SelectCityF_page.this, "Fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    getProductByCode(str_fruit);
                    Toast.makeText(SelectCityF_page.this, "selected succsessfully"+str_fruit, Toast.LENGTH_SHORT).show();
                }
            }
        });



        lv_fru.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str_fruit_name=lv_fru.getItemAtPosition(position).toString();

                sharedPrefHandler.setSharedPreferences("stationcharge",str_fruit_name);


                Intent intent=new Intent(getApplication(),Fruit_details.class);
                startActivity(intent);
                finish();


            }
        });
    }
    private void getProductByCode(final  String str_veg) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<FruitArray>> call = api.getFruName(str_fruit);

        call.enqueue(new Callback<List<FruitArray>>() {
            @Override
            public void onResponse(Call<List<FruitArray>> call, Response<List<FruitArray>> response) {
                // List<Product> responseResult = response.body();
                productList_fru = response.body();

                Boolean isSuccess = false;
                if(productList_fru != null) {
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
            public void onFailure(Call<List<FruitArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        productfru = new String[productList_fru.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < productList_fru.size(); i++) {
            productfru[i] = productList_fru.get(i).getName();
        }

        adapterfru = new ArrayAdapter<String>(this, R.layout.list_city, R.id.tv_listcity, productfru);
        lv_fru.setAdapter(adapterfru);





    }

}


