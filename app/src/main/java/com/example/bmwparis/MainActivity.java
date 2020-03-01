package com.example.bmwparis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.text_view_results);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "http://51.91.97.54:3000/api/bmw/connect";
        JSONArray arrayParams = new JSONArray();
        JSONObject objectParams = new JSONObject();
        try {
            objectParams.put("mail", "lokman-hekim@hotmail.fr");
            objectParams.put("mdp", "123");
            arrayParams.put(objectParams);
        } catch (JSONException e) {

        }
        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest(Request.Method.POST, url, arrayParams,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int id;
                        String login, mdp, nom, prenom, adresse, tel;
                        resultTextView.setText("data :" + response);
                        try {
                            id = response.getJSONObject(0).getInt("id_user");
                            login = response.getJSONObject(0).getString("mail");
                            mdp = response.getJSONObject(0).getString("mdp");
                            nom = response.getJSONObject(0).getString("nom");
                            prenom = response.getJSONObject(0).getString("prenom");
                            adresse = response.getJSONObject(0).getString("adresse");
                            tel = response.getJSONObject(0).getString("tel");
                            CurrentUser currentUser = new CurrentUser(id, nom, prenom, login, adresse, tel, mdp);
                            resultTextView.setText("login :" + currentUser.getMail() + ", mdp : " + currentUser.getMdp());
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
    }

}
