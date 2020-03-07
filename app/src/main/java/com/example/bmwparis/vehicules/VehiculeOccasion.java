package com.example.bmwparis.vehicules;

public class VehiculeOccasion extends Vehicule {
    private String etat, information, date_immat;
    private float km;

    public VehiculeOccasion(String etat, String information, String date_immat, float km) {
        this.etat = etat;
        this.information = information;
        this.date_immat = date_immat;
        this.km = km;
    }

    public VehiculeOccasion(int id_vehicule, int cylindree, String marque, String modele, String immatriculation, String type_vehicule, String energie, String type_boite, String img_1, String img_2, float prix, String etat, String information, String date_immat, float km) {
        super(id_vehicule, cylindree, marque, modele, immatriculation, type_vehicule, energie, type_boite, img_1, img_2, prix);
        this.etat = etat;
        this.information = information;
        this.date_immat = date_immat;
        this.km = km;
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

    public String getDate_immat() {
        return date_immat;
    }

    public void setDate_immat(String date_immat) {
        this.date_immat = date_immat;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }
}
