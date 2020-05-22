package sn.project.android.coderlefutur.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "T_Cours")
public class Cours {

    @DatabaseField(generatedId = true)
    private int codeCours;
    @DatabaseField
    private int nbModule;
    @DatabaseField
    private String nomCours;


    public Cours() {
    }

    public Cours(int nbModule, String nomCours) {
        this.nbModule = nbModule;
        this.nomCours = nomCours;
    }

    public int getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(int codeCours) {
        this.codeCours = codeCours;
    }

    public int getNbModule() {
        return nbModule;
    }

    public void setNbModule(int nbModule) {
        this.nbModule = nbModule;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }
}
