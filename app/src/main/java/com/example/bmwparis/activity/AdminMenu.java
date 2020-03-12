package com.example.bmwparis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class AdminMenu extends AppCompatActivity {

    Button button_vehicules, button_users, button_disconnect;
    Button button_dashboard_vehicules, button_dashboard_users, button_dashboard_techs, button_dashboard_admins,
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
        this.button_dashboard_vehicules = (Button) findViewById(R.id.button_dashboard_vehicules);
        this.button_dashboard_users = (Button) findViewById(R.id.button_dashboard_users);
        this.button_dashboard_techs = (Button) findViewById(R.id.button_dashboard_techs);
        this.button_dashboard_admins = (Button) findViewById(R.id.button_dashboard_admins);
        this.button_dashboard_clients = (Button) findViewById(R.id.button_dashboard_clients);
        this.button_dashboard_essais = (Button) findViewById(R.id.button_dashboard_essais);
        this.button_dashboard_devis = (Button) findViewById(R.id.button_dashboard_devis);
        this.button_dashboard_vehclients = (Button) findViewById(R.id.button_dashboard_vehclients);
        this.button_dashboard_vehneufs = (Button) findViewById(R.id.button_dashboard_vehneufs);
        this.button_dashboard_vehoccasions = (Button) findViewById(R.id.button_dashboard_vehoccasions);


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

    public void getData(String type) {
        int dataCount = 0;
        String value = "";
        switch (type) {
            case "vehiculeclients" : value = "views/vehicule/clients" ; break ;
            case "vehiculeoccasions" : value = "views/vehicule/occasions" ; break ;
            case "vehiculeneufs" : value = "views/vehicule/neufs" ; break ;
        }
        String url = "http://51.38.34.13:3000/api/bmw/" + value;
        StringRequest dashboardRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray data_array = new JSONArray(response);
//                    JSONObject data = new JSONObject(data_array);

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