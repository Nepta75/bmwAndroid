package com.example.bmwparis.activity.gestionVehicules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bmwparis.R;
import com.example.bmwparis.activity.gestionVehicules.ajoutVehicules.AddVehiculeClient;
import com.example.bmwparis.activity.gestionVehicules.ajoutVehicules.AddVehiculeNeuf;
import com.example.bmwparis.activity.gestionVehicules.ajoutVehicules.AddVehiculeOccas;

public class GestionVehiculesAjouter extends AppCompatActivity {

    Button addVehNeuf, addVehOccas, addVehClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules_ajouter);

        this.addVehNeuf = findViewById(R.id.button_veh_neuf_ajouter);
        this.addVehOccas = findViewById(R.id.button_veh_occas_ajouter);
        this.addVehClient = findViewById(R.id.button_veh_client_ajouter);

        this.addVehNeuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddVehNeuf = new Intent(getApplicationContext(), AddVehiculeNeuf.class);
                startActivity(intentAddVehNeuf);
            }
        });

        this.addVehOccas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddVehOccas = new Intent(getApplicationContext(), AddVehiculeOccas.class);
                startActivity(intentAddVehOccas);
            }
        });

        this.addVehClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddVehClient = new Intent(getApplicationContext(), AddVehiculeClient.class);
                startActivity(intentAddVehClient);
            }
        });
    }
}
