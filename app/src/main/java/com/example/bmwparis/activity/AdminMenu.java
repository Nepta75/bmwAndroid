package com.example.bmwparis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bmwparis.R;
import com.example.bmwparis.activity.gestionVehicules.GestionVehicules;

public class AdminMenu extends AppCompatActivity {

    Button button_vehicules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        this.button_vehicules = (Button) findViewById(R.id.button_vehicules);

        button_vehicules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuVehicules = new Intent(getApplicationContext(), GestionVehicules.class);
                startActivity(menuVehicules);
            }
        });
    }
}
