package sn.project.android.coderlefutur.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "T_Personnes")
public class Personne {

    @DatabaseField(generatedId = true)
    private int idPersonne;
    @DatabaseField
    private String prenom;
    @DatabaseField
    private String nom;
    @DatabaseField
    private String login;

    //Constructeur pour intancier un nouvel objet de personne
    public Personne() {
    }

    //Constructeur pour intancier un nouvel objet de personne
    public Personne(String prenom, String nom,String login) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}