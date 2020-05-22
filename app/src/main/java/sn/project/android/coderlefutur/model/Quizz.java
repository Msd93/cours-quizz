package sn.project.android.coderlefutur.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "T_Quizz")
public class Quizz {
    @DatabaseField(generatedId = true)
    private int idQuizz;
    @DatabaseField
    private int score;
    @DatabaseField
    private String dateQuizz;
    @DatabaseField
    private String niveau;

    @DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "codeCours", foreignAutoCreate = true)
    private Cours cours;

    public Quizz() {
    }

    public Quizz(int score, String dateQuizz,String niveau, Cours cours) {
        this.score = score;
        this.niveau = niveau;
        this.dateQuizz = dateQuizz;
        this.cours = cours;
    }

    public int getIdQuizz() {
        return idQuizz;
    }

    public void setIdQuizz(int idQuizz) {
        this.idQuizz = idQuizz;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDateQuizz() {
        return dateQuizz;
    }

    public void setDateQuizz(String dateQuizz) {
        this.dateQuizz = dateQuizz;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Date de jeu: "+dateQuizz+" Score: "+score+"\n\n";
    }
}
