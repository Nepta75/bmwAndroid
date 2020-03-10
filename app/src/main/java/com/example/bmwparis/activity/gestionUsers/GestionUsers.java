package com.example.bmwparis.activity.gestionUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bmwparis.R;

public class GestionUsers extends AppCompatActivity {

    Button button_users_clients, button_users_admins, button_users_tech, button_users_ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_users);

        button_users_clients = (Button) findViewById(R.id.button_users_clients);
        button_users_admins = (Button) findViewById(R.id.button_users_admins);
        button_users_tech = (Button) findViewById(R.id.button_users_tech);
        button_users_ajouter = (Button) findViewById(R.id.button_users_ajouter);

        button_users_clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gestionUsersClients = new Intent(getApplicationContext(), GestionUsersClients.class);
                startActivity(gestionUsersClients);
            }
        });

        button_users_admins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gestionUsersAdmins = new Intent(getApplicationContext(), GestionUsersAdmins.class);
                startActivity(gestionUsersAdmins);
            }
        });

        button_users_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gestionUsersTech = new Intent(getApplicationContext(), GestionUsersTechs.class);
                startActivity(gestionUsersTech);
            }
        });

        button_users_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gestionUsersAjouter = new Intent(getApplicationContext(), GestionUsersAjouter.class);
                startActivity(gestionUsersAjouter);
            }
        });
    }
}
