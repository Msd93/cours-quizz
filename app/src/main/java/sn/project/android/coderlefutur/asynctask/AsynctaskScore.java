package sn.project.android.coderlefutur.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sn.project.android.coderlefutur.adapter.Adapter_Quizz_Detail;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Quizz;

public class AsynctaskScore extends AsyncTask<Void, Void, List<Quizz>> {
    // On a besoin du contexte pour replacer l'AsyncTask
    private Context context;
    // On récupère l'activité d'appel, au cas où besoin dans le traitement
    private Activity activity;

    ProgressDialog progressDialog;
    DataBaseManager dataBaseManager;
    List<Quizz> highTechItemlist = new ArrayList<>();
    ListView listView;
    TextView textView;

    /**
     * Constructeur de l'asyncTask.
     * @param activity
     */
    public AsynctaskScore(Activity activity, ListView listView, TextView textView) {
        this.context = activity.getApplicationContext();
        this.activity = activity;
        this.listView = listView;
        this.textView = textView;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        /*
         * Cette fonction contiendra le code exécuté au préalable, par exemple:
         *  -Affichage d'une ProgressBar
         *      =rond qui tourne pour indiquer une attente
         *      =Barre de progression
         *  -...
         */
        progressDialog = ProgressDialog.show(activity,
                "ProgressDialog",
                "Wait please");
    }

    @Override
    protected List<Quizz> doInBackground(Void... arg0) {

        /*
         * Ici, le code qui doit être exécuté dans l'AsyncTask, par exemple:
         *  -Une requête de base de données
         *  -Un appel à un Web Service
         *  -...
         */
        dataBaseManager = new DataBaseManager(activity);
        highTechItemlist = new ArrayList<>();
        highTechItemlist = dataBaseManager.readQuizze ();

        return highTechItemlist;
    }

    @Override
    protected void onPostExecute(final List<Quizz> success) {
        /*
         * Ici, le code exécuté une fois le traitement terminé, par exemple:
         *  -Mise à jour de l'affichage
         *  -Affichage d'une pop-up indiquant la fin du traitement
         *  -Désactivation de la ProgressBar
         *  -...
         */
//        listView.setAdapter(new Adapter_Quizz_Detail(activity.getApplicationContext(),
//                (ArrayList<Quizz>) success));
        Adapter_Quizz_Detail adapterQuizzDetail = new Adapter_Quizz_Detail(context, (ArrayList<Quizz>) success);
        listView.setAdapter(adapterQuizzDetail);
        if(success.isEmpty()) {
            textView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.INVISIBLE);
        }
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {

    }
}
