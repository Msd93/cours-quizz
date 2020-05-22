package sn.project.android.coderlefutur.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

import sn.project.android.coderlefutur.model.Activite;
import sn.project.android.coderlefutur.model.Agenda;
import sn.project.android.coderlefutur.model.Cours;
import sn.project.android.coderlefutur.model.Freq;
import sn.project.android.coderlefutur.model.Module;
import sn.project.android.coderlefutur.model.Quizz;


public class DataBaseManager extends OrmLiteSqliteOpenHelper {


    private static final String DATABASE_NAME = "GestionCours.db";
    private static final int DATABASE_VERSION = 1;





    public DataBaseManager(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try{
            /**
             *Creation des tables de la base de données
             *Cette methode est invoquée une seule fois
             **/


            TableUtils.createTableIfNotExists( connectionSource, Quizz.class);
            TableUtils.createTableIfNotExists( connectionSource, Agenda.class);
            TableUtils.createTableIfNotExists( connectionSource, Module.class);
            TableUtils.createTableIfNotExists( connectionSource, Activite.class);
            TableUtils.createTableIfNotExists( connectionSource, Cours.class);
            TableUtils.createTableIfNotExists( connectionSource, Freq.class);

            addCours ();

            Log.i("DATABASE","la methode onCreate est invoquée");

        }catch (Exception exception){

            Log.e("DATABASE","la methode onCreate n'est pas invoquée",exception );

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try{
            /**
             Creation des tables de la base de données
            Cette methode est invoquée une seule fois
             **/

            TableUtils.dropTable( connectionSource, Quizz.class,true);
            TableUtils.dropTable( connectionSource, Agenda.class,true);
            TableUtils.dropTable( connectionSource, Module.class,true);
            TableUtils.dropTable( connectionSource, Activite.class,true);
            TableUtils.dropTable( connectionSource, Cours.class,true);
            TableUtils.dropTable( connectionSource, Freq.class,true);



            onCreate (database,connectionSource);
            Log.i("DATABASE","la methode onUpgrade est invoquée");

        }catch (Exception exception){

            Log.e("DATABASE","la methode onUpgrade n'est pas invoquée",exception );

        }
    }






    // CRUD Cours
    public boolean insertCours(Cours cours){
        try{
            Dao<Cours,Integer> mondao = getDao( Cours.class );
            mondao.create ( cours );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Cours");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Cours a echoué",ex);
            return false;
        }
    }
    public List<Cours> readCours() {
        try {
            Dao <Cours, Integer> mondao = getDao (Cours.class);
            List <Cours> coursList = mondao.queryForAll ( );
            return coursList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Cours", ex);
            return null;
        }
    }
    public List<Cours> getCours(String s) {
        try {
            Dao <Cours, Integer> mondao = getDao (Cours.class);
             List<Cours> coursList = mondao.queryForEq ("nomCours",s);
            return coursList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Cours", ex);
            return null;
        }
    }

    // CRUD Module
    public boolean insertModule(Module module){
        try{
            Dao<Module,Integer> mondao = getDao( Module.class );
            mondao.create ( module );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Module");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Module a echoué",ex);
            return false;
        }
    }
    public List<Module> getModule(String module){
        try{

            Dao<Module,Integer> mondao = getDao( Module.class );
            List<Module> modules = mondao.queryForEq ("nomModule", module);
            Log.i("DATABASE","module recupéré avec succés sur la table T_Module");
         return modules;
        }
        catch (Exception ex){
            Log.e("DATABASE","echec de la  récupérationsur la table T_Module",ex);
            return null;
        }
    }
    public List<Module> readModule() {
        try {
            Dao <Module, Integer> mondao = getDao (Module.class);
            List <Module> moduleList = mondao.queryForAll ( );
            return moduleList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Module", ex);
            return null;
        }
    }
    public List<Module> readModuleFavori(String fc) {
        try {
            Dao <Module, Integer> mondao = getDao (Module.class);
            List <Module> moduleList = mondao.queryForEq("favori",fc);
            Log.i("DATABASE", "Modules favoris listés");
            return moduleList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut pas lister les modules favori", ex);
            return null;
        }
    }
    public void modifyModuleFavori(String nommodule,String fc) {
        try {

            Dao <Module, Integer> mondao = getDao (Module.class);
            UpdateBuilder<Module, Integer> updateBuilder = mondao.updateBuilder();
            updateBuilder.where().eq("nomModule", nommodule );

            updateBuilder.updateColumnValue("favori", fc);
            updateBuilder.update();
            Log.i("DATABASE", "Modules favoris modifiiés");
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut pas modifier les modules favori", ex);
        }
    }

    // CRUD Activite
    public boolean insertActivite(Activite activite){
        try{
            Dao<Activite,Integer> mondao = getDao( Activite.class );
            mondao.create ( activite );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Activite");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Activte a echoué",ex);
            return false;
        }
    }
    public List<Activite> readActivite() {
        try {
            Dao <Activite, Integer> mondao = getDao (Activite.class);
            List <Activite> moduleList = mondao.queryForAll ( );
            return moduleList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Activte", ex);
            return null;
        }
    }

    // CRUD Agenda
    public boolean insertAgenda(Agenda agenda){
        try{
            Dao<Agenda,Integer> mondao = getDao( Agenda.class );
            mondao.createOrUpdate ( agenda );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Agenda");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Agenda a echoué",ex);
            return false;
        }
    }
    public boolean updateAgenda(Agenda agenda){
        try{
            Dao<Agenda,Integer> mondao = getDao( Agenda.class );
            mondao.update ( agenda );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Agenda");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Agenda a echoué",ex);
            return false;
        }
    }
    public List<Agenda> readAgenda() {
        try {
            Dao <Agenda, Integer> mondao = getDao (Agenda.class);
            List <Agenda> moduleList = mondao.queryForAll ( );
            return moduleList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Activte", ex);
            return null;
        }
    }
    public boolean deleteAgenda(int agenda){
        try{
            Dao<Agenda,Integer> mondao = getDao( Agenda.class );
            mondao.deleteById ( agenda );
            Log.i("DATABASE","Suppression faite avec succés sur la table T_Agenda");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Suppression sur la table T_Agenda a echoué",ex);
            return false;
        }
    }



    // CRUD Quizz
    public boolean insertQuizz(Quizz quizz){
        try{
            Dao<Quizz,Integer> mondao = getDao( Quizz.class );
            mondao.create ( quizz );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Quizz");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Quizz a echoué",ex);
            return false;
        }
    }
    public List<Quizz> readQuizze() {
        try {
            Dao <Quizz, Integer> mondao = getDao (Quizz.class);
            List <Quizz> moduleList = mondao.queryForAll ( );
            return moduleList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Quizz", ex);
            return null;
        }
    }
    public void deleteQuizz(Quizz quizz){
        try {
            Dao <Quizz, Integer> mondao = getDao (Quizz.class);
            mondao.delete (quizz);
            Log.i("DATABASE","Suppression faite sur la table T_Quizz");
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut supprimer l'element de la table T_Quizz", ex);
        }
    }
    // CRUD Freq
    public boolean insertStat(Freq statistique){
        try{
            Dao<Freq,Integer> mondao = getDao( Freq.class );
            mondao.create ( statistique );
            Log.i("DATABASE","Insertion faite avec succés sur la table T_Frequentation");
            return true;
        }
        catch (Exception ex){
            Log.e("DATABASE","Insertion sur la table T_Frequentation a echoué",ex);
            return false;
        }
    }
    public List<Freq> readStat() {
        try {
            Dao <Freq, Integer> mondao = getDao (Freq.class);
            List <Freq> statistiqueList = mondao.queryForAll ( );
            return statistiqueList;
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Quizz", ex);
            return null;
        }
    }

    public void deleteStat(Freq freq){
        try {
            Dao <Freq, Integer> mondao = getDao (Freq.class);
            mondao.delete (freq);
            Log.i("DATABASE","Suppression faite avec succés sur la table T_Frequentation");
        } catch (Exception ex) {
            Log.e ("DATABASE", "Ne peut lister les elements de la table T_Quizz", ex);
        }
    }

    private void addCours() {
        Cours coursJava = new Cours(8,"JAVA");
        Cours coursPHP = new Cours(8,"PHP");
        Cours coursCpp = new Cours(8,"Cpp");
        Cours coursHTML = new Cours(8,"HTML");
        Cours coursJS = new Cours(8,"JavaScript");
        Cours coursC = new Cours(8,"C");

        this.insertCours(coursJava);
        this.insertCours(coursPHP);
        this.insertCours(coursCpp);
        this.insertCours(coursHTML);
        this.insertCours(coursJS);
        this.insertCours(coursC);
        //module Java
        Module module1Java = new Module(coursJava,"Introduction à Java");
        Module module2Java = new Module(coursJava,"Technique de base");
        Module module3Java = new Module(coursJava,"Types primitifs");
        Module module4Java = new Module(coursJava,"Structures de contrôle");
        Module module5Java = new Module(coursJava,"POO");
        Module module6Java = new Module(coursJava,"Les tableaux");
        Module module7Java = new Module(coursJava,"Chaines de caractères");
        Module module8Java = new Module(coursJava,"Héritage");

        this.insertModule(module1Java);
        this.insertModule(module2Java);
        this.insertModule(module3Java);
        this.insertModule(module4Java);
        this.insertModule(module5Java);
        this.insertModule(module6Java);
        this.insertModule(module7Java);
        this.insertModule(module8Java);
        //module PHP
        Module module1Php = new Module(coursPHP,"Introduction à php");
        Module module2Php = new Module(coursPHP,"Exemple de script");
        Module module3Php = new Module(coursPHP,"Syntaxe de php");
        Module module4Php = new Module(coursPHP,"POO avec php");
        Module module5Php = new Module(coursPHP,"Configuration php_ini");
        Module module6Php = new Module(coursPHP,"Concepts fondamentaux");
        Module module7Php = new Module(coursPHP,"Manip de données");
        Module module8Php = new Module(coursPHP,"Exple application");

        this.insertModule(module1Php);
        this.insertModule(module2Php);
        this.insertModule(module3Php);
        this.insertModule(module4Php);
        this.insertModule(module5Php);
        this.insertModule(module6Php);
        this.insertModule(module7Php);
        this.insertModule(module8Php);
        //module html
        Module module1Html = new Module(coursHTML,"Introduction à html");
        Module module2Html = new Module(coursHTML,"Base du html");
        Module module3Html = new Module(coursHTML,"CSS");
        Module module4Html = new Module(coursHTML,"Formatage");
        Module module5Html = new Module(coursHTML,"Modèles des boites");
        Module module6Html = new Module(coursHTML,"Mise en page");
        Module module7Html = new Module(coursHTML,"Fonds et apparences");
        Module module8Html = new Module(coursHTML,"Tableaux");

        this.insertModule(module1Html);
        this.insertModule(module2Html);
        this.insertModule(module3Html);
        this.insertModule(module4Html);
        this.insertModule(module5Html);
        this.insertModule(module6Html);
        this.insertModule(module7Html);
        this.insertModule(module8Html);
        //module C
        Module module1C = new Module(coursC,"Introduction en C");
        Module module2C = new Module(coursC,"Tableau et srtructure");
        Module module3C = new Module(coursC,"Pointeur");
        Module module4C = new Module(coursC,"Les fonctions");
        Module module5C = new Module(coursC,"Les fichiers");
        Module module6C = new Module(coursC,"Liste chaînées");
        Module module7C = new Module(coursC,"Récursivité");
        Module module8C = new Module(coursC,"Pile et file");

        this.insertModule(module1C);
        this.insertModule(module2C);
        this.insertModule(module3C);
        this.insertModule(module4C);
        this.insertModule(module5C);
        this.insertModule(module6C);
        this.insertModule(module7C);
        this.insertModule(module8C);
        //module Cpp
        Module module1Cpp = new Module(coursCpp,"Introduction à cpp");
        Module module2Cpp = new Module(coursCpp,"Variable et type");
        Module module3Cpp = new Module(coursCpp,"Environnement");
        Module module4Cpp = new Module(coursCpp,"Les instructions");
        Module module5Cpp = new Module(coursCpp,"Texte cpp et portee");
        Module module6Cpp = new Module(coursCpp,"Les fonctions cpp");
        Module module7Cpp = new Module(coursCpp,"Code produit");
        Module module8Cpp = new Module(coursCpp,"Types contruits");

        this.insertModule(module1Cpp);
        this.insertModule(module2Cpp);
        this.insertModule(module3Cpp);
        this.insertModule(module4Cpp);
        this.insertModule(module5Cpp);
        this.insertModule(module6Cpp);
        this.insertModule(module7Cpp);
        this.insertModule(module8Cpp);
        //module JS
        Module module1JS = new Module(coursJS,"Introduction à JS");
        Module module2JS = new Module(coursJS,"Fondements JS");
        Module module3JS = new Module(coursJS,"POO JS");
        Module module4JS = new Module(coursJS,"DOM JS");
        Module module5JS = new Module(coursJS,"AJAX");
        Module module6JS = new Module(coursJS,"Prototype");
        Module module7JS = new Module(coursJS,"DOJO JS");
        Module module8JS = new Module(coursJS,"Interface (web)");

        this.insertModule(module1JS);
        this.insertModule(module2JS);
        this.insertModule(module3JS);
        this.insertModule(module4JS);
        this.insertModule(module5JS);
        this.insertModule(module6JS);
        this.insertModule(module7JS);
        this.insertModule(module8JS);

    }

}
