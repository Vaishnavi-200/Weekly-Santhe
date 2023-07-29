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
public class Fruit_name_list extends AppCompatActivity {
    SharedPrefHandler shr;
    String fruit,fcity;
    ListView lf;
    String[] fruits;
    List<FruitArray_page> fruitList;
    ArrayAdapter<String> adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_name_list);
        lf=(ListView)findViewById(R.id.lv_fu);
        shr=new SharedPrefHandler(this);
        fruit=shr.getSharedPreferences("sf");
        fcity=shr.getSharedPreferences("sf1");
        Toast.makeText(Fruit_name_list.this, "success" + fruit + fcity, Toast.LENGTH_SHORT).show();
        getProductByCode(fruit, fcity);

    }
    private void getProductByCode(final  String fruit,final String fcity) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<FruitArray_page>> call = api.fruittnamelist(fruit, fcity);

        call.enqueue(new Callback<List<FruitArray_page>>() {
            @Override
            public void onResponse(Call<List<FruitArray_page>> call, Response<List<FruitArray_page>> response) {
                // List<Product> responseResult = response.body();
                fruitList = response.body();

                Boolean isSuccess = false;
                if(fruitList != null) {
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
            public void onFailure(Call<List<FruitArray_page>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        fruits = new String[fruitList.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < fruitList.size(); i++) {
            fruits[0] = fruitList.get(i).getFname();
            fruits[1] = fruitList.get(i).getFprice();
            fruits[2] = fruitList.get(i).getFdate();
            fruits[3] = fruitList.get(i).getFcity();
            fruits[4] = fruitList.get(i).getFlocation();
            fruits[5] = fruitList.get(i).getFruit();


        }

        adapter1 = new ArrayAdapter<String>(this, R.layout.list_fruit, R.id.fruit_listitem, fruits);
        lf.setAdapter(adapter1);





    }

}