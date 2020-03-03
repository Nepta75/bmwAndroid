package com.example.bmwparis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestionVehiculesNeufs extends AppCompatActivity {

    private RequestQueue mQueue;
    private String url;

    public GestionVehiculesNeufs() {
        this.url = "http://51.68.143.7:3000/api/bmw/viewvehicules/neuf";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_neufs);

        mQueue = Volley.newRequestQueue(this);
        StringRequest vehiculesRequest = new StringRequest(Request.Method.GET, this.url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray data = new JSONArray(response);
                        for(int i = 0; i < data.length(); i++) {

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
