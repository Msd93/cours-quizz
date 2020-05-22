package sn.project.android.coderlefutur.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "T_Agenda")
public class Agenda {

    @DatabaseField(generatedId = true)
    private int idEDT;
    @DatabaseField
    private String jour1;
    @DatabaseField
    private String jour2;
    @DatabaseField
    private String jour3;
    @DatabaseField
    private String jour4;
    @DatabaseField
    private String jour5;
    @DatabaseField
    private String jour6;
    @DatabaseField
    private String jour7;
    @DatabaseField
    private int heure;
    @DatabaseField
    private int minute;
    @DatabaseField
    private boolean switcH;
    @DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "codeCours",foreignAutoCreate = true)
    private Cours cours;


    public Agenda() {
    }

    public Agenda(String jour1, String jour2, String jour3, String jour4, String jour5, String jour6, String jour7, int heure, int minute, Cours cours, boolean switcH) {
        this.jour1 = jour1;
        this.jour2 = jour2;
        this.jour3 = jour3;
        this.jour4 = jour4;
        this.jour5 = jour5;
        this.jour6 = jour6;
        this.jour7 = jour7;
        this.heure = heure;
        this.minute = minute;
        this.switcH = switcH;
        this.cours = cours;
    }

    public int getIdEDT() {
        return idEDT;
    }

    public void setIdEDT(int idEDT) {
        this.idEDT = idEDT;
    }

    public String getJour1() {
        return jour1;
    }

    public void setJour1(String jour1) {
        this.jour1 = jour1;
    }

    public String getJour2() {
        return jour2;
    }

    public void setJour2(String jour2) {
        this.jour2 = jour2;
    }

    public String getJour3() {
        return jour3;
    }

    public void setJour3(String jour3) {
        this.jour3 = jour3;
    }

    public String getJour4() {
        return jour4;
    }

    public void setJour4(String jour4) {
        this.jour4 = jour4;
    }

    public String getJour5() {
        return jour5;
    }

    public void setJour5(String jour5) {
        this.jour5 = jour5;
    }

    public String getJour6() {
        return jour6;
    }

    public void setJour6(String jour6) {
        this.jour6 = jour6;
    }

    public String getJour7() {
        return jour7;
    }

    public void setJour7(String jour7) {
        this.jour7 = jour7;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isSwitcH() {
        return switcH;
    }

    public void setSwitcH(boolean switcH) {
        this.switcH = switcH;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
