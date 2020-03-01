package com.example.bmwparis;

public class Vehicule {

    private int id_vehicule, cylindree;
    private String marque, modele, immatriculation, type_vehicule, energie, type_boite, img_1, img_2;
    private float prix;

    public Vehicule() {

    }

    public Vehicule(int id_vehicule, int cylindree, String marque, String modele, String immatriculation, String type_vehicule, String energie, String type_boite, String img_1, String img_2, float prix) {
        this.id_vehicule = id_vehicule;
        this.cylindree = cylindree;
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
        this.type_vehicule = type_vehicule;
        this.energie = energie;
        this.type_boite = type_boite;
        this.img_1 = img_1;
        this.img_2 = img_2;
        this.prix = prix;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getType_vehicule() {
        return type_vehicule;
    }

    public void setType_vehicule(String type_vehicule) {
        this.type_vehicule = type_vehicule;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getType_boite() {
        return type_boite;
    }

    public void setType_boite(String type_boite) {
        this.type_boite = type_boite;
    }

    public String getImg_1() {
        return img_1;
    }

    public void setImg_1(String img_1) {
        this.img_1 = img_1;
    }

    public String getImg_2() {
        return img_2;
    }

    public void setImg_2(String img_2) {
        this.img_2 = img_2;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
