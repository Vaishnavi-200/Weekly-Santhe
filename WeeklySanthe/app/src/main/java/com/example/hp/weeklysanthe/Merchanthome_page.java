package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by HP on 17-03-2023.
 */
public class Merchanthome_page extends AppCompatActivity {
    LinearLayout veg,fru,gro,fee,about;
    Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merchanthome_page);
        veg=(LinearLayout)findViewById(R.id.l1);
        fru=(LinearLayout)findViewById(R.id.l2);
        gro=(LinearLayout)findViewById(R.id.l3);
        fee=(LinearLayout)findViewById(R.id.l4);
        about=(LinearLayout)findViewById(R.id.l5);



        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Vegetables_page.class);
                startActivity(i);
            }
        });
        fru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Fruits_page.class);
                startActivity(i);
            }
        });
        gro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Groceries_page.class);
                startActivity(i);

            }
        });
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Feedback_page.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Aboutus_page.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_aboutus) {
//            // shr.setSharedPreferences("profile","true");
//            Intent i = new Intent(getApplication(),Aboutus_page.class);
//            startActivity(i);
//            return true;
//        }
//        if (id == R.id.action_help) {
//            Intent i = new Intent(getApplication(),Helpus_page.class);
//            startActivity(i);
//            return true;
//        }
        if (id == R.id.action_contact) {
            Intent i = new Intent(getApplication(),Contactus_page.class);
            startActivity(i);
            return true;
        }
//        if (id == R.id.action_logout) {
//            Intent i = new Intent(getApplication(),Log.class);
//            startActivity(i);
//            return true;
//        }
        if (id == R.id.action_payment) {
            Intent i = new Intent(getApplication(),Payment_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_golive) {
            Intent i = new Intent(getApplication(),Golive_page.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
