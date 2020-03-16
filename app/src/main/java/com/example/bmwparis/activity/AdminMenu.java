package com.example.bmwparis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmwparis.R;
import com.example.bmwparis.activity.connexion.MainActivity;
import com.example.bmwparis.activity.gestionUsers.GestionUsers;
import com.example.bmwparis.activity.gestionVehicules.GestionVehicules;
import com.example.bmwparis.vehicules.VehiculeClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class AdminMenu extends AppCompatActivity {

    Button button_vehicules, button_users, button_disconnect;
    TextView button_dashboard_users, button_dashboard_vehicules, button_dashboard_techs, button_dashboard_admins,
           button_dashboard_clients, button_dashboard_essais, button_dashboard_devis, button_dashboard_vehclients,
           button_dashboard_vehneufs, button_dashboard_vehoccasions;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        mQueue = Volley.newRequestQueue(this);

        // BOUTONS MENU
        this.button_vehicules = (Button) findViewById(R.id.button_vehicules);
        this.button_users = (Button) findViewById(R.id.button_users);
        this.button_disconnect = (Button) findViewById(R.id.button_disconnect);

        //BOUTONS DASHBOARD
        this.button_dashboard_vehicules = (TextView) findViewById(R.id.button_dashboard_vehicules);
        this.button_dashboard_users = (TextView) findViewById(R.id.button_dashboard_users);
        this.button_dashboard_techs = (TextView) findViewById(R.id.button_dashboard_techs);
        this.button_dashboard_admins = (TextView) findViewById(R.id.button_dashboard_admins);
        this.button_dashboard_clients = (TextView) findViewById(R.id.button_dashboard_clients);
        this.button_dashboard_essais = (TextView) findViewById(R.id.button_dashboard_essais);
        this.button_dashboard_devis = (TextView) findViewById(R.id.button_dashboard_devis);
        this.button_dashboard_vehclients = (TextView) findViewById(R.id.button_dashboard_vehclients);
        this.button_dashboard_vehneufs = (TextView) findViewById(R.id.button_dashboard_vehneufs);
        this.button_dashboard_vehoccasions = (TextView) findViewById(R.id.button_dashboard_vehoccasions);

        button_vehicules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuVehicules = new Intent(getApplicationContext(), GestionVehicules.class);
                startActivity(menuVehicules);
            }
        });

        button_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuUsers = new Intent(getApplicationContext(), GestionUsers.class);
                startActivity(menuUsers);
            }
        });

        button_disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuConnection = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(menuConnection);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String url = "http://51.38.34.13:3000/api/bmw/getdashboard";
        StringRequest dashboardRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray data = new JSONArray(response);
                    button_dashboard_vehicules.setText("Veh : " + data.getJSONObject(0).getString("vehicules"));
                    button_dashboard_users.setText("Users : " + data.getJSONObject(0).getString("users"));
                    button_dashboard_techs.setText("Techs : " + data.getJSONObject(0).getString("technicien"));
                    button_dashboard_admins.setText("Admins : " + data.getJSONObject(0).getString("admin"));
                    button_dashboard_clients.setText("Clients : " + data.getJSONObject(0).getString("client"));
                    button_dashboard_essais.setText("Essais : " + data.getJSONObject(0).getString("essai"));
                    button_dashboard_devis.setText("Devis : " + data.getJSONObject(0).getString("devis"));
                    button_dashboard_vehclients.setText("V_Clients : " + data.getJSONObject(0).getString("vehiculeClient"));
                    button_dashboard_vehneufs.setText("V_Neufs : " + data.getJSONObject(0).getString("vehiculeNeuf"));
                    button_dashboard_vehoccasions.setText("V_Occas : " + data.getJSONObject(0).getString("vehiculeOccasion"));
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e + "", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error + "", Toast.LENGTH_LONG).show();
            }
        });
        mQueue.add(dashboardRequest);
    }
}