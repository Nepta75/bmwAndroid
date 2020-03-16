package com.example.bmwparis.activity.fiches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmwparis.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONException;
import org.json.JSONObject;

public class FicheVehiculesClients extends AppCompatActivity {

    Button button_vneuf_delete;
    TextView textview_marque, textview_modele, textview_prix, textview_cylindree, textview_immatriculation, textview_type_vehicule,
             textview_energie, textview_type_boite, textview_date_immat, textview_km, textview_etat, textview_information, textview_nom,
             textview_prenom, textview_mail;
    String idVehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite, img_1, img_2, prix, date_immat,
           km, etat, information, nom, prenom, mail;
    private String[] imagesVehicule;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_vehicules_clients);

        this.button_vneuf_delete = (Button) findViewById(R.id.button_vneuf_delete);
        mQueue = Volley.newRequestQueue(this);

        textview_marque = (TextView) findViewById(R.id.textview_marque);
        textview_modele = (TextView) findViewById(R.id.textview_modele);
        textview_prix = (TextView) findViewById(R.id.textview_prix);
        textview_cylindree = (TextView) findViewById(R.id.textview_cylindree);
        textview_immatriculation = (TextView) findViewById(R.id.textview_immatriculation);
        textview_type_vehicule =(TextView) findViewById(R.id.textview_type_vehicule);
        textview_energie = (TextView) findViewById(R.id.textview_energie);
        textview_type_boite = (TextView) findViewById(R.id.textview_type_boite);
        textview_date_immat = (TextView) findViewById(R.id.textview_date_immat);
        textview_km = (TextView) findViewById(R.id.textview_km);
        textview_etat = (TextView) findViewById(R.id.textview_etat);
        textview_information = (TextView) findViewById(R.id.textview_information);
        textview_nom = (TextView) findViewById(R.id.textview_nom);
        textview_prenom = (TextView) findViewById(R.id.textview_prenom);
        textview_mail = (TextView) findViewById(R.id.textview_mail);

        Intent ficheVehiculesNeufs = getIntent();
        idVehicule = ficheVehiculesNeufs.getStringExtra("id_vehicule");
        cylindree = ficheVehiculesNeufs.getStringExtra("cylindree");
        marque = ficheVehiculesNeufs.getStringExtra("marque");
        modele = ficheVehiculesNeufs.getStringExtra("modele");
        immatriculation = ficheVehiculesNeufs.getStringExtra("immatriculation");
        type_vehicule = ficheVehiculesNeufs.getStringExtra("type_vehicule");
        energie = ficheVehiculesNeufs.getStringExtra("energie");
        type_boite = ficheVehiculesNeufs.getStringExtra("type_boite");
        img_1 = ficheVehiculesNeufs.getStringExtra("img_1");
        img_2 = ficheVehiculesNeufs.getStringExtra("img_2");
        prix = ficheVehiculesNeufs.getStringExtra("prix");
        date_immat = ficheVehiculesNeufs.getStringExtra("date_immat");
        km = ficheVehiculesNeufs.getStringExtra("km");
        etat = ficheVehiculesNeufs.getStringExtra("etat");
        information = ficheVehiculesNeufs.getStringExtra("information");
        nom = ficheVehiculesNeufs.getStringExtra("nom");
        prenom = ficheVehiculesNeufs.getStringExtra("prenom");
        mail = ficheVehiculesNeufs.getStringExtra("mail");

        this.imagesVehicule = new String[] {
                img_1.substring(0, img_1.lastIndexOf('.')), img_2.substring(0, img_2.lastIndexOf('.'))
        };

        CarouselView carouselVehiculesNeufs = findViewById(R.id.carousel_vehicules_neuf);
        carouselVehiculesNeufs.setPageCount(imagesVehicule.length);
        carouselVehiculesNeufs.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(getApplicationContext().getResources().getIdentifier(imagesVehicule[position], "drawable", getApplicationContext().getPackageName()));
            }
        });

        carouselVehiculesNeufs.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), marque + " " + modele, Toast.LENGTH_SHORT).show();
            }
        });

        textview_marque.setText(marque.toUpperCase());
        textview_modele.setText(modele);
        textview_prix.setText(prix + "€");
        textview_cylindree.setText(cylindree + " cm³");
        textview_immatriculation.setText(immatriculation.toUpperCase());
        textview_type_vehicule.setText(type_vehicule);
        textview_energie.setText(energie);
        textview_type_boite.setText("Boîte " + type_boite);
        textview_date_immat.setText("Immatriculé le " + date_immat.substring(0, date_immat.lastIndexOf('T')));
        textview_km.setText(km);
        textview_etat.setText(etat);
        textview_information.setText("Efficia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.");
        textview_nom.setText(nom);
        textview_prenom.setText(prenom);
        textview_mail.setText(mail);

        button_vneuf_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://51.38.34.13:3000/api/bmw/deletevehicule/client/" + idVehicule;
                StringRequest deleteVehiculeNeuf = new StringRequest(Request.Method.DELETE, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject data = new JSONObject(response);
                                    int affectedRows = data.getInt("affectedRows");
                                    if (affectedRows == 1) {
                                        Toast.makeText(getApplicationContext(), "Le véhicule a été supprimé avec succès.", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Erreur lors de la suppresion du véhicule", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(getApplicationContext(), "Erreur lors de la suppresion du véhicule : " + e, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Impossible de supprimer le véhicule : " + error, Toast.LENGTH_SHORT).show();
                    }
                });
                mQueue.add(deleteVehiculeNeuf);
            }
        });
    }
}
