package com.example.bmwparis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.DoubleToLongFunction;

public class GestionVehiculesClients extends AppCompatActivity {

    private RequestQueue mQueue;
    private String url;
    private ArrayList vehiculesClients;
    private ListView list_vehicules_clients;

    public GestionVehiculesClients() {
        this.url = "http://51.91.97.54:3000/api/bmw/viewvehicules/client";
        this.vehiculesClients = new ArrayList<VehiculeClient>();
        this.list_vehicules_clients = (ListView) findViewById(R.id.list_vehicules_clients);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_clients);

        mQueue = Volley.newRequestQueue(this);

        StringRequest vehiculesRequest = new StringRequest(Request.Method.GET, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray data = new JSONArray(response);
                            for(int i = 0; i < data.length(); i++) {
                                int id_vehicule = data.getJSONObject(i).getInt("id_vehicule");
                                int cylindree = data.getJSONObject(i).getInt("cylindree");
                                String marque = data.getJSONObject(i).getString("marque");
                                String modele = data.getJSONObject(i).getString("modele");
                                String immatriculation = data.getJSONObject(i).getString("immatriculation");
                                String type_vehicule = data.getJSONObject(i).getString("type_vehicule");
                                String energie = data.getJSONObject(i).getString("energie");
                                String type_boite = data.getJSONObject(i).getString("type_boite");
                                Float prix = (float) data.getJSONObject(i).getDouble("prix");
                                String img_1 = data.getJSONObject(i).getString("img_1");
                                String img_2 = data.getJSONObject(i).getString("img_2");
                                String date_immat = data.getJSONObject(i).getString("date_immat");
                                int id_user = data.getJSONObject(i).getInt("id_user");
                                String etat = data.getJSONObject(i).getString("etat");
                                String information = data.getJSONObject(i).getString("information");
                                Float km = (float) data.getJSONObject(i).getDouble("km");
                                VehiculeClient vehiculeClient = new VehiculeClient(id_vehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite, img_1, img_2, prix,  id_user, date_immat, etat, information, km);
                                vehiculesClients.add(vehiculeClient);
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.,vehiculesClients);
                            list_vehicules_clients.setAdapter(arrayAdapter);

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
