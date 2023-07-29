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
public class Veg_name_list extends AppCompatActivity {
    SharedPrefHandler shr;
    String veg, vcity;
    ListView l1, l2, l3, l4, l5, l6;
    String[] vegtables;
    List<VegArray_page> vegtableList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_name_list);
        l1 = (ListView) findViewById(R.id.lv_vg);
        shr = new SharedPrefHandler(this);
        veg = shr.getSharedPreferences("sv");
        vcity = shr.getSharedPreferences("sv1");
        Toast.makeText(Veg_name_list.this, "success" + veg + vcity, Toast.LENGTH_SHORT).show();
        getProductByCode(veg, vcity);

    }

    private void getProductByCode(final String veg, final String vcity) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<VegArray_page>> call = api.vegnamelist(veg, vcity);

        call.enqueue(new Callback<List<VegArray_page>>() {
            @Override
            public void onResponse(Call<List<VegArray_page>> call, Response<List<VegArray_page>> response) {
                // List<Product> responseResult = response.body();
                vegtableList = response.body();

                Boolean isSuccess = false;
                if (vegtableList != null) {
                    isSuccess = true;
                }

                if (isSuccess) {

                    // responseResult.getSuccess();
                    // Update all field with result data

                    loadvegtableListView();

                } else {


                }
            }

            @Override
            public void onFailure(Call<List<VegArray_page>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void loadvegtableListView() {
        //Creating an String array for the ListView
        vegtables = new String[vegtableList.size()];


        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < vegtableList.size(); i++) {
            vegtables[i] = vegtableList.get(i).getVname();
            vegtables[i] = vegtableList.get(i).getPrice();
            vegtables[i] = vegtableList.get(i).getDate();
            vegtables[i] = vegtableList.get(i).getCity();
            vegtables[i] = vegtableList.get(i).getLocation();
            vegtables[i] = vegtableList.get(i).getVeg();


        }

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_page, R.id.veg_listitem, vegtables);
        l1.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_page, R.id.veg_listitem1, vegtables);
        l2.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_page, R.id.veg_listitem2, vegtables);
        l3.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_page, R.id.veg_listitem3, vegtables);
        l4.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_page, R.id.veg_listitem4, vegtables);
        l5.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_page, R.id.veg_listitem5, vegtables);
        l6.setAdapter(adapter);
    }
}






