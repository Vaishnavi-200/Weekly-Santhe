package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 23-03-2023.
 */
public class Proceednext_page extends AppCompatActivity {
    Button btn_upload1;
    Button btn_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceednext_page);
        btn_upload1 = (Button) findViewById(R.id.btn_upload);
        btn_next1 = (Button) findViewById(R.id.btn_next);

        btn_upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Proceednext_page.this, Googleform_page.class);
                startActivity(i);
                Toast.makeText(Proceednext_page.this, "welcome back", Toast.LENGTH_SHORT);

            }
        });

        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Proceednext_page.this, Merchanthome_page.class);
                startActivity(i);
                Toast.makeText(Proceednext_page.this, "welcome back", Toast.LENGTH_SHORT);

            }
        });

    }
}
