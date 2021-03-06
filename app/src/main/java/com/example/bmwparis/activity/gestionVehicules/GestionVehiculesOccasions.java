package com.example.bmwparis.activity.gestionVehicules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmwparis.R;
import com.example.bmwparis.adapters.VehiculesOccasItemsAdapter;
import com.example.bmwparis.vehicules.VehiculeOccasion;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculesOccasions extends AppCompatActivity {
    private RequestQueue mQueue;
    private String url;
    private List<VehiculeOccasion> vehiculesOccasion;
    private ListView listview_vehicule;
    private JSONArray data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_occasions);
        this.url = "http://51.38.34.13:3000/api/bmw/viewvehicules/occas";
        vehiculesOccasion = new ArrayList<>();
        mQueue = Volley.newRequestQueue(this);
        listview_vehicule = (ListView) findViewById(R.id.listview_vehicule_occasion);
        StringRequest vehiculesRequest = new StringRequest(Request.Method.GET, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            data = new JSONArray(response);
                            for (int i = 0; i < data.length(); i++) {
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
                                Float prix = (float) data.getJSONObject(i).getDouble("prix");
                                String date_immat = data.getJSONObject(i).getString("date_immat");
                                String etat = data.getJSONObject(i).getString("etat");
                                String information = data.getJSONObject(i).getString("information");
                                Float km = (float) data.getJSONObject(i).getDouble("km");
                                vehiculesOccasion.add(new VehiculeOccasion(id_vehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite
                                        , img_1, img_2, prix, date_immat, etat, information, km));
                            }
                            listview_vehicule.setAdapter(new VehiculesOccasItemsAdapter(getApplicationContext(), vehiculesOccasion));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erreur lors de la récupération de données !", Toast.LENGTH_SHORT).show();
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
