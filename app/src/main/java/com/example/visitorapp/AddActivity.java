package com.example.visitorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button b1;
    String s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        t1=(EditText) findViewById(R.id.e1);
        t2=(EditText) findViewById(R.id.e2);
        t3=(EditText) findViewById(R.id.e3);
        t4=(EditText) findViewById(R.id.e4);
        b1=(Button) findViewById(R.id.bb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=t1.getText().toString();
                s2=t2.getText().toString();
                s3=t3.getText().toString();
                s4=t4.getText().toString();
                Toast.makeText(getApplicationContext(),s1+s2+s3+s4,Toast.LENGTH_LONG).show();

            }
        });



    }
}