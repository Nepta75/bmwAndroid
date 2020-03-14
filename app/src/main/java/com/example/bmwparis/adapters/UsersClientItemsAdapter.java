package com.example.bmwparis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmwparis.R;
import com.example.bmwparis.users.User;

import java.util.List;

public class UsersClientItemsAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;
    private LayoutInflater inflater;

    public UsersClientItemsAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_users, null);
        User currentItem = getItem(position);
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
