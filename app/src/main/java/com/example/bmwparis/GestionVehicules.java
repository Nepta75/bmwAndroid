package com.example.bmwparis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionVehicules extends AppCompatActivity {

    Button button_vehicules_neuf, button_vehicules_occasions, button_vehicules_clients, button_vehicules_ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_vehicules);

        this.button_vehicules_neuf = (Button) findViewById(R.id.button_vehicules_neufs);
        this.button_vehicules_occasions = (Button) findViewById(R.id.button_vehicules_occasions);
        this.button_vehicules_clients = (Button) findViewById(R.id.button_vehicules_clients);
        this.button_vehicules_ajouter = (Button) findViewById(R.id.button_vehicules_ajouter);

        button_vehicules_neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuVehiculesNeufs = new Intent(getApplicationContext(), GestionVehiculesNeufs.class);
                startActivity(menuVehiculesNeufs);
            }
        });

        button_vehicules_occasions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuVehiculesOccasions = new Intent(getApplicationContext(), GestionVehiculesOccasions.class);
                startActivity(menuVehiculesOccasions);
            }
        });

        button_vehicules_clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuVehiculesClients = new Intent(getApplicationContext(), GestionVehiculesClients.class);
                startActivity(menuVehiculesClients);
            }
        });

        button_vehicules_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuAjouterVehicules = new Intent(getApplicationContext(), GestionVehiculesAjouter.class);
                startActivity(menuAjouterVehicules);
            }
        });
    }
}
