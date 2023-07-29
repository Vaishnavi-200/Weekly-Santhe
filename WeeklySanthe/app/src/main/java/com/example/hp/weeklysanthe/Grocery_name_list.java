package com.example.hp.weeklysanthe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 24-03-2023.
 */
public class Grocery_name_list extends AppCompatActivity {
    SharedPrefHandler shr;
    String grocery,gcity;
    ListView lg;
    String[] groceroies;
    List<GroceryArray_page> groceryList;
    ArrayAdapter<String> adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_name_list);
        lg=(ListView)findViewById(R.id.lv_go);
        shr=new SharedPrefHandler(this);
        grocery=shr.getSharedPreferences("sg");
        gcity=shr.getSharedPreferences("sg1");
        Toast.makeText(Grocery_name_list.this, "success" + grocery + gcity, Toast.LENGTH_SHORT).show();
        getProductByCode(grocery, gcity);

    }
    private void getProductByCode(final  String grocery,final String gdate) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<GroceryArray_page>> call = api.grocerynamelist(grocery, gdate);

        call.enqueue(new Callback<List<GroceryArray_page>>() {
            @Override
            public void onResponse(Call<List<GroceryArray_page>> call, Response<List<GroceryArray_page>> response) {
                // List<Product> responseResult = response.body();
                groceryList = response.body();

                Boolean isSuccess = false;
                if(groceryList != null) {
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
            public void onFailure(Call<List<GroceryArray_page>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        groceroies = new String[groceryList.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < groceryList.size(); i++) {
            groceroies[0] = groceryList.get(i).getGname();
            groceroies[1] = groceryList.get(i).getGprice();
            groceroies[2] = groceryList.get(i).getGdate();
            groceroies[3] = groceryList.get(i).getGcity();
            groceroies[4] = groceryList.get(i).getGlocation();
            groceroies[5] = groceryList.get(i).getGrocery();


        }

        adapter2 = new ArrayAdapter<String>(this, R.layout.list_grocery, R.id.grocery_listitem, groceroies);
        lg.setAdapter(adapter2);





    }
}
