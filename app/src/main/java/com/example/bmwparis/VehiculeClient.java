package com.example.bmwparis;

import java.util.Date;

public class VehiculeClient extends Vehicule {

    private int id_user;
    private String etat, information, date_immat;
    private float km;

    public VehiculeClient(int id_user, String date_immat, String etat, String information, float km) {
        this.id_user = id_user;
        this.date_immat = date_immat;
        this.etat = etat;
        this.information = information;
        this.km = km;
    }

    public VehiculeClient(int id_vehicule, int cylindree, String marque, String modele, String immatriculation, String type_vehicule, String energie, String type_boite, String img_1, String img_2, float prix, int id_user, String date_immat, String etat, String information, float km) {
        super(id_vehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite, img_1, img_2, prix);
        this.id_user = id_user;
        this.date_immat = date_immat;
        this.etat = etat;
        this.information = information;
        this.km = km;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDate_immat() {
        return date_immat;
    }

    public void setDate_immat(String date_immat) {
        this.date_immat = date_immat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }
}