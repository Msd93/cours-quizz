package sn.project.android.coderlefutur.asynctask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Module;


public class Asynctask_Favoris_Cours extends AsyncTaskLoader<ArrayList<Module>> {

    private List<Module> modules;
    private DataBaseManager dataBaseManager;

    public Asynctask_Favoris_Cours(@NonNull Context context) {
        super(context);
        dataBaseManager = new DataBaseManager(context);
    }

    @Nullable
    @Override
    public ArrayList<Module> loadInBackground() {
        modules = dataBaseManager.readModuleFavori("oui");
        Log.i("ON LOAD IN BACKGROUND","données chargées");

        return (ArrayList<Module>) modules;
    }

    @Override
    protected void onStartLoading() {
        if (modules != null) {
            deliverResult((ArrayList<Module>) modules); // Use the cache
            Log.i("ON START LOAD","données dispo sur le cache et livrées directement");
        }else {
            forceLoad();
            Log.i("ON START LOAD","données non dispo sur le cache");
        }
    }
}
