package com.example.bmwparis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmwparis.R;
import com.example.bmwparis.users.UserAdmin;
import com.example.bmwparis.vehicules.VehiculeClient;

import java.util.List;

public class UsersAdminItemsAdapter extends BaseAdapter {

    private Context context;
    private List<UserAdmin> userAdminList;
    private LayoutInflater inflater;

    public UsersAdminItemsAdapter(Context context, List<UserAdmin> userAdminList) {
        this.context = context;
        this.userAdminList = userAdminList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userAdminList.size();
    }

    @Override
    public UserAdmin getItem(int position) {
        return userAdminList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_users, null);
        UserAdmin currentItem = getItem(position);
        String nom = currentItem.getNom();
        String prenom = currentItem.getPrenom();
        String mail = currentItem.getMail();
        String tel = currentItem.getTel();

        ImageView imgView = view.findViewById(R.id.list_users_img);
        TextView lastnameView = view.findViewById(R.id.list_users_lastname);
        TextView nameView = view.findViewById(R.id.list_users_name);
        TextView mailView = view.findViewById(R.id.list_users_mail);
        TextView telView = view.findViewById(R.id.list_users_tel);

        lastnameView.setText("Nom : " + nom);
        nameView.setText("Prénom : " + prenom);
        mailView.setText("Mail : " + mail);
        telView.setText("Téléphone : " + tel);

        return view;
    }
}
