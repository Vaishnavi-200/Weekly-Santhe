package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP on 18-03-2023.
 */
public class Flash_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_page);
        Thread th= new Thread(){
            @Override
            public void run() {
                super.run();{
                    try{
                        sleep(3000);
                        Intent i = new Intent(getApplication(),Chooseamode_page.class);
                        startActivity(i);
                        finish();
                    }catch (Exception e)
                    {

                    }
                }
            }
        };
        th.start();




    }


}


