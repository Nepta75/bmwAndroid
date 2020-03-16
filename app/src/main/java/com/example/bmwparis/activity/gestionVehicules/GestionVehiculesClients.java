package com.example.bmwparis.activity.gestionVehicules;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import com.example.bmwparis.activity.fiches.FicheVehiculesClients;
import com.example.bmwparis.adapters.VehiculesClientItemsAdapter;
import com.example.bmwparis.vehicules.VehiculeClient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class GestionVehiculesClients extends AppCompatActivity {

    private RequestQueue mQueue;
    private String url;
    private List<VehiculeClient> vehiculesClients;
    private ListView listview_vehicule;
    private JSONArray data;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_clients);
        this.url = "http://51.38.34.13:3000/api/bmw/viewvehicules/client";
        mQueue = Volley.newRequestQueue(this);
        listview_vehicule = (ListView) findViewById(R.id.listview_vehicule_client);
    }

    @Override
    protected void onStart() {
        super.onStart();

        vehiculesClients = new ArrayList<>();

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
                                String nom = data.getJSONObject(i).getString("nom");
                                String prenom = data.getJSONObject(i).getString("prenom");
                                String mail = data.getJSONObject(i).getString("mail");

                                Toast.makeText(getApplicationContext(), date_immat, Toast.LENGTH_SHORT);

                                vehiculesClients.add(new VehiculeClient(id_vehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite
                                        , img_1, img_2, prix, id_user, date_immat, etat, information, km, nom, prenom, mail));
                            }
                            listview_vehicule.setAdapter(new VehiculesClientItemsAdapter(getApplicationContext(), vehiculesClients));
                            listview_vehicule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent ficheVehiculesClients = new Intent(getApplicationContext(), FicheVehiculesClients.class);
                                    ficheVehiculesClients.putExtra("id_vehicule", valueOf(vehiculesClients.get(position).getId_vehicule()));
                                    ficheVehiculesClients.putExtra("cylindree", valueOf(vehiculesClients.get(position).getCylindree()));
                                    ficheVehiculesClients.putExtra("marque", vehiculesClients.get(position).getMarque());
                                    ficheVehiculesClients.putExtra("modele", vehiculesClients.get(position).getModele());
                                    ficheVehiculesClients.putExtra("immatriculation", vehiculesClients.get(position).getImmatriculation());
                                    ficheVehiculesClients.putExtra("type_vehicule", vehiculesClients.get(position).getType_vehicule());
                                    ficheVehiculesClients.putExtra("energie", vehiculesClients.get(position).getEnergie());
                                    ficheVehiculesClients.putExtra("type_boite", vehiculesClients.get(position).getType_boite());
                                    ficheVehiculesClients.putExtra("img_1", vehiculesClients.get(position).getImg_1());
                                    ficheVehiculesClients.putExtra("img_2", vehiculesClients.get(position).getImg_2());
                                    ficheVehiculesClients.putExtra("prix", valueOf(vehiculesClients.get(position).getPrix()));
                                    ficheVehiculesClients.putExtra("date_immat", vehiculesClients.get(position).getDate_immat());
                                    ficheVehiculesClients.putExtra("km", valueOf(vehiculesClients.get(position).getKm()));
                                    ficheVehiculesClients.putExtra("etat", vehiculesClients.get(position).getEtat());
                                    ficheVehiculesClients.putExtra("information", vehiculesClients.get(position).getInformation());
                                    ficheVehiculesClients.putExtra("nom", vehiculesClients.get(position).getNom());
                                    ficheVehiculesClients.putExtra("prenom", vehiculesClients.get(position).getPrenom());
                                    ficheVehiculesClients.putExtra("mail", vehiculesClients.get(position).getMail());

                                    startActivity(ficheVehiculesClients);
                                }
                            });
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
