package sn.project.android.coderlefutur.asynctask;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Agenda;

public class AsyncTask_Agenda extends AsyncTaskLoader<List<Agenda>> {

    private DataBaseManager dataBaseManager;

    public AsyncTask_Agenda(Context context) {
        super (context);
        dataBaseManager = new DataBaseManager (context);
    }

    @Nullable
    @Override
    public List <Agenda> loadInBackground() {

        return  dataBaseManager.readAgenda ();
    }

    @Override
    protected void onStartLoading() {

        forceLoad ();
    }
}
