package com.example.bmwparis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.DoubleToLongFunction;

public class GestionVehiculesClients extends AppCompatActivity {

    private RequestQueue mQueue;
    private String url;
    private List<VehiculeClient> vehiculesClients;
    private ListView listview_vehicule;
    private TextView teste;
    private JSONArray data;

    public GestionVehiculesClients() {
        this.url = "http://51.38.34.13:3000/api/bmw/viewvehicules/client";
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_clients);
        vehiculesClients = new ArrayList<>();
        mQueue = Volley.newRequestQueue(this);
        listview_vehicule = (ListView) findViewById(R.id.listview_vehicule);
        teste = (TextView) findViewById(R.id.teste);
        StringRequest vehiculesRequest = new StringRequest(Request.Method.GET, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            data = new JSONArray(response);
                            for(int i=0; i < data.length(); i++){
                                int id_vehicule = data.getJSONObject(i).getInt("id_vehicule");
                                teste.setText("data : " + data.getJSONObject(i).getString("immatriculation").toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            teste.setText("errrrrreuuuuuur");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(vehiculesRequest);
    }
}
