package sn.project.android.coderlefutur.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "T_Module")
public class Module{
    @DatabaseField(generatedId = true)
    private int codeModule;
    @DatabaseField
    private String nomModule;
    @DatabaseField
    private String favori;

    @DatabaseField(canBeNull = false,foreign = true, foreignColumnName = "codeCours", foreignAutoCreate = true)
    private Cours cours;

    public Module() {
    }

    public Module(Cours cours,String nomModule) {
        this.cours= cours;
        this.nomModule = nomModule;
    }

    public int getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(int codeModule) {
        this.codeModule = codeModule;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getFavori() {
        return favori;
    }

    public void setFavori(String favori) {
        this.favori = favori;
    }
}
