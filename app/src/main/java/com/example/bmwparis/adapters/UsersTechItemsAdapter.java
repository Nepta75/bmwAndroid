package com.example.bmwparis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmwparis.R;
import com.example.bmwparis.users.User;
import com.example.bmwparis.users.UserTech;

import java.util.List;

public class UsersTechItemsAdapter extends BaseAdapter {

    private Context context;
    private List<UserTech> userTechList;
    private LayoutInflater inflater;

    public UsersTechItemsAdapter(Context context, List<UserTech> userTechList) {
        this.context = context;
        this.userTechList = userTechList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userTechList.size();
    }

    @Override
    public Object getItem(int position) {
        return userTechList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_users, null);
        UserTech currentItem = (UserTech) getItem(position);
        String nom = currentItem.getNom();
        String prenom = currentItem.getPrenom();
        String mail = currentItem.getMail();
        String tel = currentItem.getTel();

        ImageView imgView = view.findViewById(R.id.list_users_img);
        TextView lastnameView = view.findViewById(R.id.list_users_lastname);
        TextView nameView = view.findViewById(R.id.list_users_name);
        TextView mailView = view.findViewById(R.id.list_users_mail);
        TextView telView = view.findViewById(R.id.list_users_tel);

        imgView.setImageResource(R.drawable.user);
        lastnameView.setText(nom.toUpperCase());
        nameView.setText(prenom);
        mailView.setText(mail);
        telView.setText(tel);

        return view;
    }
}
