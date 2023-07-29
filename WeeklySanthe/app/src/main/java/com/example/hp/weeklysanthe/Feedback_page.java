package com.example.hp.weeklysanthe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HP on 24-03-2023.
 */
public class Feedback_page extends AppCompatActivity {
    EditText subject,mno,msg;
    Button send;
    String str_sub,str_mno,str_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page);
        subject=(EditText)findViewById(R.id.et_subject);
        mno=(EditText)findViewById(R.id.et1_mno);
        msg=(EditText)findViewById(R.id.et2_msg);
        send=(Button)findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_sub = subject.getText().toString();
                str_mno = mno.getText().toString();
                str_msg = msg.getText().toString();
                if (str_sub.isEmpty() || str_mno.length() < 10 || str_msg.isEmpty()) {
                    Toast.makeText(Feedback_page.this, "Enter feedback", Toast.LENGTH_SHORT).show();
                } else {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"snehamaloji@gmail.co"});
                    email.putExtra(Intent.EXTRA_SUBJECT, str_sub);
                    email.putExtra(Intent.EXTRA_TEXT, str_msg + str_mno);

                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client :"));

                    Toast.makeText(Feedback_page.this, " sent sucessfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}


