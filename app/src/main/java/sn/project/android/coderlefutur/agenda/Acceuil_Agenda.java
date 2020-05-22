package sn.project.android.coderlefutur.agenda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.adapter.Adapter_Agenda;
import sn.project.android.coderlefutur.asynctask.AsyncTask_Agenda;
import sn.project.android.coderlefutur.model.Agenda;

public class Acceuil_Agenda extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Agenda>>{


    private LoaderManager loaderManager;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.acceuil_agenda);

        loaderManager  = getSupportLoaderManager ();
        loaderManager.initLoader (1,null,this);


        FloatingActionButton fab = ( FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext (),ListCours_Agenda.class);
                startActivity (intent);

            }
        });
    }



// Process pour charger les données de la base en arriere plan

    @NonNull
    @Override
    public Loader<List <Agenda>> onCreateLoader(int id, @Nullable Bundle args) {

        progressDialog = ProgressDialog.show(this,
                "ProgressDialog",
                "Wait please");
        return new AsyncTask_Agenda (this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader <List <Agenda>> loader, List <Agenda> data) {
        ListView listView = findViewById (R.id.listView_Agenda);
        Adapter_Agenda adapter = new Adapter_Agenda (getApplicationContext (),data);
        listView.setAdapter (adapter);
        progressDialog.dismiss();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List <Agenda>> loader) {

    }

}