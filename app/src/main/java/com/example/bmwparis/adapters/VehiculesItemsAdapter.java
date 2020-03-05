package com.example.bmwparis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bmwparis.R;
import com.example.bmwparis.VehiculeClient;

import org.w3c.dom.Text;

import java.util.List;

public class VehiculesItemsAdapter extends BaseAdapter {

    private Context context;
    private List<VehiculeClient> vehiculesClientList;
    private LayoutInflater inflater;

    public VehiculesItemsAdapter (Context context, List<VehiculeClient> vehiculesClientList) {
        this.context = context;
        this.vehiculesClientList = vehiculesClientList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return vehiculesClientList.size();
    }

    @Override
    public VehiculeClient getItem(int position) {
        return vehiculesClientList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_vehicules, null);
        VehiculeClient currentItem = getItem(position);
        String modele = currentItem.getModele();
        Float prix = currentItem.getPrix();
        float km = currentItem.getKm();
        String img = currentItem.getImg_1();

        ImageView imgView = view.findViewById(R.id.list_vehicules_img);
        TextView modeleView = view.findViewById(R.id.list_vehicules_modele);
        TextView priceView = view.findViewById(R.id.list_vehicules_prix);
        TextView kmView = view.findViewById(R.id.list_vehicules_km);

        imgView.setImageResource(context.getResources().getIdentifier(img.substring(0, img.lastIndexOf('.')), "drawable", context.getPackageName()));
        modeleView.setText("modele : " + modele);
        priceView.setText("prix : " + prix + " €");
        kmView.setText("km : " + km + " km");

        return view;
    }
}
