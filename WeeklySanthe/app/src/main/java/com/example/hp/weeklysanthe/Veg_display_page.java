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
public class Veg_display_page extends AppCompatActivity {
    SharedPrefHandler shr;
    Button btn_vg;
    String veg,vcity;
    Spinner sv,sv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_display_page);
        btn_vg=(Button)findViewById(R.id.btn_vg_dis);
        sv=(Spinner)findViewById(R.id.vg_l);
        sv1=(Spinner)findViewById(R.id.vg_l1);
        shr=new SharedPrefHandler(this);
        btn_vg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veg = sv.getSelectedItem().toString();
                vcity = sv1.getSelectedItem().toString();

                shr.setSharedPreferences("sv",veg);
                shr.setSharedPreferences("sv1",vcity);

                if (veg.isEmpty() || vcity.isEmpty()) {
                    Toast.makeText(Veg_display_page.this, "Fill the deatils", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Veg_display_page.this, "Displayed successfully"+veg+vcity , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplication(),Veg_name_list.class);
                    startActivity(i);

                }
            }
        });


    }
}
