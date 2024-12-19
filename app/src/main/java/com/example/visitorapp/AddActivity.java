package com.example.visitorapp;

import android.content.Intent;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button b1,b2;
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
        b2=(Button) findViewById(R.id.bbb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = t1.getText().toString();
                s2 = t2.getText().toString();
                s3 = t3.getText().toString();
                s4 = t4.getText().toString();
                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All the fields are mandatory", Toast.LENGTH_LONG).show();
                } else
                {
                    callApi();
                }
            }

            private void callApi() {
                String apiurl=" https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data= new JSONObject();
                try {
                    data.put("firstname",s1);
                    data.put("lastname",s2);
                    data.put("purpose",s3);
                    data.put("whomToMeet",s4);
                    JsonObjectRequest request=new JsonObjectRequest(
                            Request.Method.POST,
                            apiurl,
                            data,
                            response -> Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_LONG).show(),
                            error -> Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show()


                    );
                    RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                    queue.add(request);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            });

         b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(o);
            }
        });



    }
}