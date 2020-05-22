package sn.project.android.coderlefutur.asynctask;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Freq;

public class AsyncTask_Frequentation extends AsyncTaskLoader<List<Freq>> {

    private DataBaseManager dataBaseManager;

    public AsyncTask_Frequentation(Context context) {
        super (context);
        dataBaseManager = new DataBaseManager (context);
    }

    @Nullable
    @Override
    public List<Freq> loadInBackground() {
        return  dataBaseManager.readStat ();
    }

    @Override
    protected void onStartLoading() {

        forceLoad ();
    }
}
