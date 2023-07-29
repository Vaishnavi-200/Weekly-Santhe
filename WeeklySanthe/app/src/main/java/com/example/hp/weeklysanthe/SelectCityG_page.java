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
public class SelectCityG_page extends AppCompatActivity {
    Spinner city;
    String str_cities;
    Button s;
    ListView lv_gro;

    String[] productgro;
    List<GroceryArray> productList_gro;
    ArrayAdapter<String> adaptergro;

    SharedPrefHandler sharedPrefHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcityg_page);
        sharedPrefHandler=new SharedPrefHandler(this);
        city=(Spinner)findViewById(R.id.cityg);
        s=(Button)findViewById(R.id.btn_searchg);
        lv_gro=(ListView)findViewById(R.id.lv_gro);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_cities = city.getSelectedItem().toString();
                if (str_cities.isEmpty()){
                    Toast.makeText(SelectCityG_page.this, "Fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    getProductByCode(str_cities);
                    Toast.makeText(SelectCityG_page.this, "selected succsessfully"+str_cities, Toast.LENGTH_SHORT).show();
                }
            }
        });



        lv_gro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str_grocery_name=lv_gro.getItemAtPosition(position).toString();

                sharedPrefHandler.setSharedPreferences("stationcharge",str_grocery_name);


                Intent intent=new Intent(getApplication(),Grocery_details.class);
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

        Call<List<GroceryArray>> call = api.getGroName(str_cities);

        call.enqueue(new Callback<List<GroceryArray>>() {
            @Override
            public void onResponse(Call<List<GroceryArray>> call, Response<List<GroceryArray>> response) {
                // List<Product> responseResult = response.body();
                productList_gro = response.body();

                Boolean isSuccess = false;
                if(productList_gro != null) {
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
            public void onFailure(Call<List<GroceryArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        productgro = new String[productList_gro.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < productList_gro.size(); i++) {
            productgro[i] = productList_gro.get(i).getName();
        }

        adaptergro = new ArrayAdapter<String>(this, R.layout.list_city, R.id.tv_listcity, productgro);
        lv_gro.setAdapter(adaptergro);





    }

}


