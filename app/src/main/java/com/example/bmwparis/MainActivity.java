package com.example.bmwparis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText edit_login, edit_password;
    private RequestQueue mQueue;
    private String login, password;
    CurrentUser currentUser = new CurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView) findViewById(R.id.debug_tv);
        Button buttonLogin = (Button) findViewById(R.id.button_login);
        mQueue = Volley.newRequestQueue(this);
        this.edit_login = (EditText) findViewById(R.id.edit_login);
        this.edit_password = (EditText) findViewById(R.id.edit_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser(edit_login.getText().toString(), edit_password.getText().toString());
            }
        });
    }

    private void checkUser(String login, String password) {
        String url = "http://51.91.97.54:3000/api/bmw/connect";
        JSONArray arrayParams = new JSONArray();
        JSONObject objectParams = new JSONObject();
        try {
            objectParams.put("mail", login);
            objectParams.put("mdp", password);
            arrayParams.put(objectParams);
        } catch (JSONException e) {
        }
        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest(Request.Method.POST, url, arrayParams,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int id;
                        String login, mdp, nom, prenom, adresse, tel;
                        try {
                            id = response.getJSONObject(0).getInt("id_user");
                            login = response.getJSONObject(0).getString("mail");
                            mdp = response.getJSONObject(0).getString("mdp");
                            nom = response.getJSONObject(0).getString("nom");
                            prenom = response.getJSONObject(0).getString("prenom");
                            adresse = response.getJSONObject(0).getString("adresse");
                            tel = response.getJSONObject(0).getString("tel");
                            currentUser.setId_user(id);
                            currentUser.setMail(login);
                            currentUser.setMdp(mdp);
                            currentUser.setNom(nom);
                            currentUser.setPrenom(prenom);
                            currentUser.setAdresse(adresse);
                            currentUser.setTel(tel);
                            currentUser.setConnected(true);
                            checkAdmin(id);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Adresse mail et/ou mdp incorrect(s) !", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erreur lors de la connexion à la base de données", Toast.LENGTH_LONG).show();
                    }
                }
        );
        mQueue.add(jsonArrayRequest);
    }


    public void checkAdmin(int id) {
        String url = "http:/51.91.97.54:3000/api/bmw/view/admin/id_user/" +id;
        StringRequest verifAdminRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject data = new JSONArray(response).getJSONObject(0);
                        currentUser.setAdmin_lvl(data.getInt("admin_lvl"));
                        Intent adminMenu = new Intent(getApplicationContext(), AdminMenu.class);
                        startActivity(adminMenu);
//                        finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        resultTextView.setText("Utilisateur non admin !");
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
        );
        mQueue.add(verifAdminRequest);
    }
}
