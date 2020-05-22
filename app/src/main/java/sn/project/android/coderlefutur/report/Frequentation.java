package sn.project.android.coderlefutur.report;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.adapter.Adapter_Frequentation;
import sn.project.android.coderlefutur.asynctask.AsyncTask_Frequentation;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Freq;

public class Frequentation extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Freq>>{


    private DataBaseManager dataBaseManager;
    private LoaderManager loaderManager;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_frequentation);

        dataBaseManager = new DataBaseManager (this);
        loaderManager  = getSupportLoaderManager ();
        loaderManager.initLoader (1,null,this);
        /**ListView listView = findViewById (R.id.list_freq);
        Adapter_Frequentation adapter = new Adapter_Frequentation (getApplicationContext (),freqList);
        listView.setAdapter (adapter);*/
    }
    //Process pour charger les données de la base en arriere plan

    @NonNull
    @Override
    public Loader<List<Freq>> onCreateLoader(int id, @Nullable Bundle args) {
        progressDialog = ProgressDialog.show(this,
                "ProgressDialog",
                "Wait please");
        return new AsyncTask_Frequentation (this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader < List<Freq>> loader, List<Freq> data) {
        ListView listView = findViewById (R.id.list_freq);
        Adapter_Frequentation adapter = new Adapter_Frequentation (getApplicationContext (),data);
        listView.setAdapter (adapter);
        progressDialog.dismiss();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Freq>> loader) {

    }
}
