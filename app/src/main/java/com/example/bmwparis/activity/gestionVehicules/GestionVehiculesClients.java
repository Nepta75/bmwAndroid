package com.example.bmwparis.activity.gestionVehicules;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmwparis.R;
import com.example.bmwparis.adapters.VehiculesClientItemsAdapter;
import com.example.bmwparis.vehicules.VehiculeClient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculesClients extends AppCompatActivity {

    private RequestQueue mQueue;
    private String url;
    private List<VehiculeClient> vehiculesClients;
    private ListView listview_vehicule;
    private TextView teste;
    private JSONArray data;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_clients);
        this.url = "http://51.38.34.13:3000/api/bmw/viewvehicules/client";
        vehiculesClients = new ArrayList<>();
        mQueue = Volley.newRequestQueue(this);
        listview_vehicule = (ListView) findViewById(R.id.listview_vehicule_client);
        StringRequest vehiculesRequest = new StringRequest(Request.Method.GET, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            data = new JSONArray(response);
                            for(int i=0; i < data.length(); i++){
                                int id_vehicule = data.getJSONObject(i).getInt("id_vehicule");
                                int cylindree = data.getJSONObject(i).getInt("cylindree");
                                String marque = data.getJSONObject(i).getString("marque");
                                String modele = data.getJSONObject(i).getString("modele");
                                String immatriculation = data.getJSONObject(i).getString("immatriculation");
                                String type_vehicule = data.getJSONObject(i).getString("type_vehicule");
                                String energie = data.getJSONObject(i).getString("energie");
                                String type_boite = data.getJSONObject(i).getString("type_boite");
                                String img_1 = data.getJSONObject(i).getString("img_1");
                                String img_2 = data.getJSONObject(i).getString("img_2");
                                Float prix = (float) 0;
                                int id_user = data.getJSONObject(i).getInt("id_user");
                                String date_immat = data.getJSONObject(i).getString("date_immat");
                                String etat = data.getJSONObject(i).getString("etat");
                                String information = data.getJSONObject(i).getString("information");
                                Float km = (float) data.getJSONObject(i).getDouble("km");
                                vehiculesClients.add(new VehiculeClient(id_vehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite
                                , img_1, img_2, prix, id_user, date_immat, etat, information, km));
                            }
                            listview_vehicule.setAdapter(new VehiculesClientItemsAdapter(getApplicationContext(), vehiculesClients));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erreur lors de la récupération de données !", Toast.LENGTH_LONG).show();
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
