package com.example.bmwparis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListVehiculesAdapter extends ArrayAdapter<VehiculeClient> {

    Context mCtx;
    int resource;
    List<VehiculeClient> listVehicules;

    public ListVehiculesAdapter(Context mCtx, int resource, List<VehiculeClient> listVehicules) {
        super(mCtx, resource, listVehicules);
        this.mCtx = mCtx;
        this.resource = resource;
        this.listVehicules = listVehicules;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.list_vehicules, null);

        TextView textViewModele = view.findViewById(R.id.list_vehicules_modele);
        TextView textViewPrix = view.findViewById(R.id.list_vehicules_prix);
        ImageView imageViewVeh = view.findViewById(R.id.list_vehicules_img);

        Vehicule vehicule = listVehicules.get(position);
        textViewModele.setText(vehicule.getModele());
        textViewPrix.setText((int) vehicule.getPrix());
        imageViewVeh.setImageDrawable(mCtx.getDrawable(Integer.parseInt(vehicule.getImg_1())));

        return view;
    }
}
