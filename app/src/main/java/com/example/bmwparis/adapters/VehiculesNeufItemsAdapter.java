package com.example.bmwparis.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmwparis.R;
import com.example.bmwparis.activity.fiches.FicheVehiculesNeufs;
import com.example.bmwparis.activity.gestionUsers.GestionUsers;
import com.example.bmwparis.vehicules.VehiculeNeuf;

import java.util.List;

public class VehiculesNeufItemsAdapter extends BaseAdapter {

    private Context context;
    private List<VehiculeNeuf> vehiculesNeufList;
    private LayoutInflater inflater;

    public VehiculesNeufItemsAdapter(Context context, List<VehiculeNeuf> vehiculesNeufList) {
        this.context = context;
        this.vehiculesNeufList = vehiculesNeufList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return vehiculesNeufList.size();
    }

    @Override
    public VehiculeNeuf getItem(int position) {
        return vehiculesNeufList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_vehicules, null);
        final VehiculeNeuf currentItem = getItem(position);
        String modele = currentItem.getModele();
        Float prix = currentItem.getPrix();
        float km = 0;
        String img = currentItem.getImg_1();

        ImageView imgView = view.findViewById(R.id.list_vehicules_img);
        TextView modeleView = view.findViewById(R.id.list_vehicules_modele);
        TextView priceView = view.findViewById(R.id.list_vehicules_prix);
        TextView kmView = view.findViewById(R.id.list_vehicules_km);

        imgView.setImageResource(context.getResources().getIdentifier(img.substring(0, img.lastIndexOf('.')), "drawable", context.getPackageName()));
        modeleView.setText(modele);
        priceView.setText(prix + " €");

        return view;
    }
}
