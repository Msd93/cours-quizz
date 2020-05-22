package sn.project.android.coderlefutur.cours;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import sn.project.android.coderlefutur.Pdf_book;
import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.adapter.Adapter_Favori_Cours;
import sn.project.android.coderlefutur.asynctask.Asynctask_Favoris_Cours;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Module;

public class Activity_Favori_Cours extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<ArrayList<Module>> {

    private ListView listView;
    private ProgressDialog progressDialog;
    //    Adapter_Favori_Cours adapterFavoriCours;
//    private DataBaseManager dataBaseManager;
    private TextView textViewInfo;
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity__favori__cours);

        dataBaseManager = new DataBaseManager (getApplicationContext ());

        listView = (ListView) findViewById (R.id.listView_fc);
        textViewInfo = (TextView) findViewById (R.id.textviewinfo);

//        dataBaseManager = new DataBaseManager(getApplicationContext());
//        moduleList = dataBaseManager.readModuleFavori("oui");
//        adapterFavoriCours = new Adapter_Favori_Cours(getApplicationContext(), (ArrayList<Module>) moduleList);
//        listView.setAdapter(adapterFavoriCours);

        getSupportLoaderManager ( ).initLoader (0, null, this);

//        if(moduleList.isEmpty()){
//            textViewInfo.setVisibility(View.VISIBLE);
//        }else{
//            textViewInfo.setVisibility(View.INVISIBLE);
//        }
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {
                TextView item = view.findViewById (R.id.nomfavoriscours);
                Intent intent = new Intent (getApplicationContext ( ), Pdf_book.class);

                List<Module> moduleList = dataBaseManager.getModule (item.getText ().toString ());
                String cours = moduleList.get (0).getCours ().getNomCours ();

                Log.i ("DRAWABLE", cours);

                Bundle bundle = new Bundle ( );
                bundle.putString ("book", (String) item.getText ( ));
                bundle.putString ("cours", cours);
                intent.putExtras (bundle);
                startActivity (intent);

            }
        });
    }

    @NonNull
    @Override
    public Loader <ArrayList <Module>> onCreateLoader(int i, @Nullable Bundle bundle) {
        progressDialog = ProgressDialog.show(this,
                "ProgressDialog",
                "Wait please");
        return new Asynctask_Favoris_Cours (this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader <ArrayList <Module>> loader,
                               ArrayList <Module> modules) {
        Adapter_Favori_Cours adapter_favori_cours = new Adapter_Favori_Cours (getApplicationContext ( ),modules);
        if ( modules.isEmpty ( ) ) {
            textViewInfo.setVisibility (View.VISIBLE);
        } else {
            textViewInfo.setVisibility (View.INVISIBLE);
        }
        listView.setAdapter (adapter_favori_cours);
        progressDialog.dismiss ();
    }

    @Override
    public void onLoaderReset(@NonNull Loader <ArrayList <Module>> loader) {

    }


}