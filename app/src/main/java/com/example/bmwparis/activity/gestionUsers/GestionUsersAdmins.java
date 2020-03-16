package com.example.bmwparis.activity.gestionUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmwparis.R;
import com.example.bmwparis.adapters.UsersAdminItemsAdapter;
import com.example.bmwparis.users.User;
import com.example.bmwparis.users.UserAdmin;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class GestionUsersAdmins extends AppCompatActivity {
    private RequestQueue mQueue;
    private String url;
    private List<UserAdmin> userAdmins;
    private ListView listview_admins;
    private JSONArray data;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_users_admins);

        this.url = "http://51.38.34.13:3000/api/bmw/views/admin";
        userAdmins = new ArrayList<>();
        mQueue = Volley.newRequestQueue(this);
        listview_admins = (ListView) findViewById(R.id.listview_user_admin);
        StringRequest adminsRequest = new StringRequest(Request.Method.GET, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            data = new JSONArray(response);
                            for(int i = 0; i < data.length(); i++) {
                                int id_user = data.getJSONObject(i).getInt("id_user");
                                String nom = data.getJSONObject(i).getString("nom");
                                String prenom = data.getJSONObject(i).getString("prenom");
                                String mail = data.getJSONObject(i).getString("mail");
                                String adresse = data.getJSONObject(i).getString("adresse");
                                String tel = data.getJSONObject(i).getString("tel");
                                String mdp = data.getJSONObject(i).getString("mdp");
                                int admin_lvl = data.getJSONObject(i).getInt("admin_lvl");
                                userAdmins.add(new UserAdmin(id_user, nom, prenom, mail, adresse, tel, mdp, admin_lvl));
                            }
                            listview_admins.setAdapter(new UsersAdminItemsAdapter(getApplicationContext(), userAdmins));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erreur lors de la récupération de données !", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(adminsRequest);
    }
}
