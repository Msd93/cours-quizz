package sn.project.android.coderlefutur.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "T_Frequentation")
public class Freq {
    @DatabaseField(generatedId = true)
    private int idStat;
    @DatabaseField
    private String date;
    @DatabaseField
    private String duree;
    @DatabaseField
    private String nommodule;
    @DatabaseField
    private String nomcours;

    public Freq() {
    }

    public Freq(String date, String duree, String nommodule, String nomcours) {
        this.date = date;
        this.duree = duree;
        this.nommodule = nommodule;
        this.nomcours = nomcours;
    }

    public int getIdStat() {
        return idStat;
    }

    public void setIdStat(int idStat) {
        this.idStat = idStat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getNommodule() {
        return nommodule;
    }

    public void setNommodule(String nommodule) {
        this.nommodule = nommodule;
    }

    public String getNomcours() {
        return nomcours;
    }

    public void setNomcours(String nomcours) {
        this.nomcours = nomcours;
    }
}
