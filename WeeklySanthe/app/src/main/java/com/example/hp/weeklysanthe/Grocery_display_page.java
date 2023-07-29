package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by HP on 24-03-2023.
 */
public class Grocery_display_page extends AppCompatActivity {
    Button btn_g;
    Spinner sg,sg1;
    String gn,gd;
    SharedPrefHandler shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_display_page);
        shr=new SharedPrefHandler(this);
        btn_g=(Button)findViewById(R.id.btn_gr_dis);
        sg=(Spinner)findViewById(R.id.gr_l);
        sg1=(Spinner)findViewById(R.id.gr_l1);
        shr=new SharedPrefHandler(this);
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gn = sg.getSelectedItem().toString();
                gd = sg1.getSelectedItem().toString();
                shr.setSharedPreferences("sg", gn);
                shr.setSharedPreferences("sg1", gd);
                if (gn.isEmpty() || gd.isEmpty()) {
                    Toast.makeText(Grocery_display_page.this, "Fill the deatils", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Grocery_display_page.this, "Displayed successfully" + gn +gd, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplication(),Grocery_name_list.class);
                    startActivity(i);

                }
            }
        });
    }
}
