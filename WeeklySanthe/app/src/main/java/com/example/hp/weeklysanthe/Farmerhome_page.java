package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 19-03-2023.
 */
public class Farmerhome_page extends AppCompatActivity {
//    SharedPrefHandler shr;
    TextView v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;
    ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmerhome_page);
//        shr = new SharedPrefHandler(this);

        v1 = (TextView) findViewById(R.id.tv_tomato);
        v2 = (TextView) findViewById(R.id.tv_beetroot);
        v3 = (TextView) findViewById(R.id.tv_carrot);
        v4 = (TextView) findViewById(R.id.tv_peas);
        v5 = (TextView) findViewById(R.id.tv_apple);
        v6 = (TextView) findViewById(R.id.tv_jackfruit);
        v7 = (TextView) findViewById(R.id.tv_guava);
        v8 = (TextView) findViewById(R.id.tv_cherry);
        v9 = (TextView) findViewById(R.id.tv_toordal);
        v10 = (TextView) findViewById(R.id.tv_wheat);

        i1 = (ImageView) findViewById(R.id.img_tomato);
        i2 = (ImageView) findViewById(R.id.img_beetroot);
        i3 = (ImageView) findViewById(R.id.img_carrot);
        i4 = (ImageView) findViewById(R.id.img_peas);
        i5 = (ImageView) findViewById(R.id.img_apple);
        i6 = (ImageView) findViewById(R.id.img_jackfruit);
        i7 = (ImageView) findViewById(R.id.img_guava);
        i8 = (ImageView) findViewById(R.id.img_cherry);
        i9 = (ImageView) findViewById(R.id.img_toordal);
        i10 = (ImageView) findViewById(R.id.img_wheat);

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),VCS_page.class);
                startActivity(i);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });
        v10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),VCS_page .class);
                startActivity(i);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
                startActivity(i);
            }
        });

        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), VCS_page.class);
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