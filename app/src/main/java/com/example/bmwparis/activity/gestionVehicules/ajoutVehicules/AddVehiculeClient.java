package com.example.bmwparis.activity.gestionVehicules.ajoutVehicules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bmwparis.R;

public class AddVehiculeClient extends AppCompatActivity {
    EditText marque, modele, immatriculation, cylindree, prix, img1, img2;
    RadioGroup typeVehGroup, energieGroup, typeBoiteGroup;
    RadioButton typeVehBtn, energieBtn, typeBoiteBtn;

    public void setTypeVeh (View v) {
        int btnId = typeVehGroup.getCheckedRadioButtonId();
        typeVehBtn = findViewById(btnId);
    }

    public void setEnergie (View v) {
        int btnId = typeVehGroup.getCheckedRadioButtonId();
        energieBtn = findViewById(btnId);
    }
    public void setTypeBoite (View v) {
        int btnId = typeVehGroup.getCheckedRadioButtonId();
        typeBoiteBtn = findViewById(btnId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicule_client);

        this.marque = findViewById(R.id.edit_marque_client);
        this.modele = findViewById(R.id.edit_modele_client);
        this.immatriculation = findViewById(R.id.edit_immatriculation_client);
        this.cylindree = findViewById(R.id.edit_cylindree_client);
        this.prix = findViewById(R.id.edit_prix_client);
        this.img1 = findViewById(R.id.edit_img1_client);
        this.img2 = findViewById(R.id.edit_img2_client);

        this.typeVehGroup = findViewById(R.id.rgroup_typeVeh_client);
        this.energieGroup = findViewById(R.id.rgroup_energie_client);
        this.typeBoiteGroup = findViewById(R.id.rgroup_typeBoite_client);
    }

    public void addVehiculeClient(View v) {
        if (!marque.getText().toString().isEmpty() &&
        !modele.getText().toString().isEmpty() &&
        !immatriculation.getText().toString().isEmpty() &&
        !cylindree.getText().toString().isEmpty() &&
        !prix.getText().toString().isEmpty() &&
        !img1.getText().toString().isEmpty() &&
        !typeBoiteBtn.getText().toString().isEmpty() &&
        !energieBtn.getText().toString().isEmpty() &&
        !typeVehBtn.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Succes, ajout du véhicule", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Veuillez remplir tout les champs obligatoire", Toast.LENGTH_LONG).show();
        }
    }
}
