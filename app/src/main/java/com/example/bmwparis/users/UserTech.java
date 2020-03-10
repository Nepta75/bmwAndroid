package com.example.bmwparis.users;

public class UserTech extends User {

    private int technicien_lvl;
    private String diplome;

    public UserTech(int id_user, String nom, String prenom, String mail, String adresse, String tel, String mdp, int technicien_lvl, String diplome) {
        super(id_user, nom, prenom, mail, adresse, tel, mdp);
        this.technicien_lvl = technicien_lvl;
        this.diplome = diplome;
    }

    public int getTechnicien_lvl() {
        return technicien_lvl;
    }

    public void setTechnicien_lvl(int technicien_lvl) {
        this.technicien_lvl = technicien_lvl;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
}
