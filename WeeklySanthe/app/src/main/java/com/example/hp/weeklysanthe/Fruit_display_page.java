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
public class Fruit_display_page extends AppCompatActivity {
    SharedPrefHandler shr;
    Button btn_f;
    String fn,fd;
    Spinner sf,sf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_display_page);
        btn_f=(Button)findViewById(R.id.btn_fr_dis);
        shr=new SharedPrefHandler(this);
        sf=(Spinner)findViewById(R.id.fr_l);
        sf1=(Spinner)findViewById(R.id.fr_l1);
        shr=new SharedPrefHandler(this);
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn = sf.getSelectedItem().toString();
                fd = sf1.getSelectedItem().toString();
                shr.setSharedPreferences("sf", fn);
                shr.setSharedPreferences("sf1", fd);
                if (fn.isEmpty() || fd.isEmpty()) {
                    Toast.makeText(Fruit_display_page.this, "Fill the deatils", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Fruit_display_page.this, "Displayed successfully" + fn + fd, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplication(), Fruit_name_list.class);
                    startActivity(i);

                }
            }
        });
    }
}
