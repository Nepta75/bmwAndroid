package com.example.bmwparis.users;

public class UserAdmin extends User {

    private int admin_lvl;

    public UserAdmin(int id_user, String nom, String prenom, String mail, String adresse, String tel, String mdp, int admin_lvl) {
        super(id_user, nom, prenom, mail, adresse, tel, mdp);
        this.admin_lvl = admin_lvl;
    }

    public int getAdmin_lvl() {
        return admin_lvl;
    }

    public void setAdmin_lvl(int admin_lvl) {
        this.admin_lvl = admin_lvl;
    }
}
