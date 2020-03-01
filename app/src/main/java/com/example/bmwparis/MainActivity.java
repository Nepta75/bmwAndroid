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
import com.android.volley.toolbox.JsonObjectRequest;
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
                Boolean connected = currentUser.getConnected();
                if(connected) {
                    Toast.makeText(getApplicationContext(), "zbeub zbeub", Toast.LENGTH_SHORT).show();
                    Intent adminMenu = new Intent(getApplicationContext(), AdminMenu.class);
                    startActivity(adminMenu);
                    finish();
                }
            }
        });
    }

    private Boolean checkUser(String login, String password) {
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
//                        resultTextView.setText("data :" + response);
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
//                            resultTextView.setText("login :" + currentUser.getMail() + ", mdp : " + currentUser.getMdp());
                        } catch (JSONException e) {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        mQueue.add(jsonArrayRequest);
        if(currentUser.getConnected()) {
            return true;
        }
        return false;
    }
}
