package sn.project.android.coderlefutur.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "T_Activite")
public class Activite  {

    @DatabaseField(generatedId = true)
    private int idActivite;
    @DatabaseField
    private Date dateConsultation;
    @DatabaseField
    private String heureDebut; // Pour savoir le temps que l'utilidateur a passé dans l'application
    @DatabaseField
    private String heureFin; // Pour savoir le temps  que l'utilidateur  a passé dans l'application


    @DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "idPersonne", foreignAutoCreate = true)
    private Personne personne;

    @DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "codeModule", foreignAutoCreate = true)
    private Module module;


    public Activite() {
    }

    public Activite(Date dateConsultation, String heureDebut, String heureFin, Personne personne, Module module) {
        this.dateConsultation = dateConsultation;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.personne = personne;
        this.module = module;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}