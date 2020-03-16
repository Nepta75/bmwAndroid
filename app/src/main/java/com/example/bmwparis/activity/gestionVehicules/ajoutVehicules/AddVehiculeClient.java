package com.example.bmwparis.activity.gestionVehicules.ajoutVehicules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmwparis.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddVehiculeClient extends AppCompatActivity {
    EditText idUser, marque, modele, immatriculation, cylindree, etat, km,  info, img1, img2, date;
    RadioGroup typeVehGroup, energieGroup, typeBoiteGroup;
    RadioButton typeVehBtn, energieBtn, typeBoiteBtn;
    Button addvehicule;
    RequestQueue mQueue;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicule_client);

        this.mQueue = Volley.newRequestQueue(this);
        this.url = "http://51.38.34.13:3000/api/bmw/addvehicule/client";

        this.idUser = findViewById(R.id.edit_id_client);
        this.marque = findViewById(R.id.edit_marque_client);
        this.modele = findViewById(R.id.edit_modele_client);
        this.immatriculation = findViewById(R.id.edit_immatriculation_client);
        this.cylindree = findViewById(R.id.edit_cylindree_client);
        this.etat = findViewById(R.id.edit_etat_client);
        this.date = findViewById(R.id.edit_date_client);
        this.info = findViewById(R.id.edit_info_client);
        this.km = findViewById(R.id.edit_km_client);
        this.img1 = findViewById(R.id.edit_img1_client);
        this.img2 = findViewById(R.id.edit_img2_client);
        this.typeVehGroup = findViewById(R.id.rgroup_typeVeh_client);
        this.energieGroup = findViewById(R.id.rgroup_energie_client);
        this.typeBoiteGroup = findViewById(R.id.rgroup_typeBoite_client);

        this.addvehicule = findViewById(R.id.addVehiculeClient);

        addvehicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addVehiculeClient(v);
            }
        });
    }

    public void setTypeVeh (View v) {
        int btnId = typeVehGroup.getCheckedRadioButtonId();
        typeVehBtn = findViewById(btnId);
    }

    public void setEnergie (View v) {
        int btnId = energieGroup.getCheckedRadioButtonId();
        energieBtn = findViewById(btnId);
    }
    public void setTypeBoite (View v) {
        int btnId = typeBoiteGroup.getCheckedRadioButtonId();
        typeBoiteBtn = findViewById(btnId);
    }

    public void addVehiculeClient(View v) {
        if (!idUser.getText().toString().isEmpty() &&
        !marque.getText().toString().isEmpty() &&
        !modele.getText().toString().isEmpty() &&
        !immatriculation.getText().toString().isEmpty() &&
        !cylindree.getText().toString().isEmpty() &&
        !date.getText().toString().isEmpty() &&
        !etat.getText().toString().isEmpty() &&
        !km.getText().toString().isEmpty() &&
        !img1.getText().toString().isEmpty() &&
        !typeBoiteBtn.getText().toString().isEmpty() &&
        !energieBtn.getText().toString().isEmpty() &&
        !typeVehBtn.getText().toString().isEmpty()) {
            JSONArray arrayParams = new JSONArray();
            JSONObject objParams = new JSONObject();
            try {
                objParams.put("idUser", idUser.getText());
                objParams.put("marque", marque.getText());
                objParams.put("modele", modele.getText());
                objParams.put("immatriculation", immatriculation.getText());
                objParams.put("dateImmat", date.getText());
                objParams.put("cylindree", cylindree.getText());
                objParams.put("etat", etat.getText());
                objParams.put("info", info.getText());
                objParams.put("km", km.getText());
                objParams.put("img1", img1.getText());
                objParams.put("img2", img2.getText());
                objParams.put("typeBoite", typeBoiteBtn.getText());
                objParams.put("energie", energieBtn.getText());
                objParams.put("typeVeh", typeVehBtn.getText());
                arrayParams.put(objParams);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonArrayRequest addVehicule = new JsonArrayRequest(Request.Method.PUT, url, arrayParams, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Toast.makeText(getApplicationContext(), "Succes, ajout du véhicule", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), typeVehBtn.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            mQueue.add(addVehicule);
        } else {
            Toast.makeText(getApplicationContext(), "Veuillez remplir tout les champs obligatoire", Toast.LENGTH_SHORT).show();
        }
    }
}
