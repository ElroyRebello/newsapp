package com.example.elroynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recy;
    ArrayList<model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = findViewById(R.id.rv);
       // adapter adapter = new adapter(list, MainActivity.this);
      //  recy.setAdapter(adapter);

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
       /// recy.setLayoutManager(linearLayoutManager);
         newsobj obj = new newsobj(this);


         obj.getnews(new newsobj.Newsif() {
             @Override
             public void onError(String message) {

             }

             @Override
             public void onResponse(ArrayList<model> list) {
                 adapter adapter = new adapter(list, MainActivity.this);
                 recy.setAdapter(adapter);

                 LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                 recy.setLayoutManager(linearLayoutManager);
             }
         });




    }



    }
