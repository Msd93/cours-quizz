package sn.project.android.coderlefutur.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TimePicker;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.database.DataBaseManager;

public class ListCours_Agenda extends AppCompatActivity {

    private TimePicker picker;
    private Button annuller, modifier;
    private CheckBox check1, check2, check3, check4, check5, check6, check7;

    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setContentView (R.layout.list_cours_agenda);
        dataBaseManager = new DataBaseManager (this);

        DisplayMetrics dm = new DisplayMetrics ( );
        getWindowManager ( ).getDefaultDisplay ( ).getMetrics (dm);
        int Width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow ( ).setLayout ((int) (Width * .8), (int) (height * .6 ));


    }

    public void choisirHoraire(View view) {

        if(view.getId () == R.id.html_L){
        Intent intent = new Intent (getApplicationContext (),Date_Agenda.class);
        Bundle bundle = new Bundle ();
        bundle.putCharSequence ("cours","HTML");
        intent.putExtra ("bundle",bundle);
        startActivity (intent);
            finish ();
        }
        if(view.getId () == R.id.js_L){
        Intent intent = new Intent (getApplicationContext (),Date_Agenda.class);
        Bundle bundle = new Bundle ();
        bundle.putCharSequence ("cours","JavaScript");
        intent.putExtra ("bundle",bundle);
        startActivity (intent);
            finish ();
        }
        if(view.getId () == R.id.java_L){
        Intent intent = new Intent (getApplicationContext (),Date_Agenda.class);
        Bundle bundle = new Bundle ();
        bundle.putCharSequence ("cours","JAVA");
        intent.putExtra ("bundle",bundle);
        startActivity (intent);
            finish ();
        }
        if(view.getId () == R.id.php_L){
        Intent intent = new Intent (getApplicationContext (),Date_Agenda.class);
        Bundle bundle = new Bundle ();
        bundle.putCharSequence ("cours","PHP");
        intent.putExtra ("bundle",bundle);
        startActivity (intent);
            finish ();
        }
        if(view.getId () == R.id.c_L){
        Intent intent = new Intent (getApplicationContext (),Date_Agenda.class);
        Bundle bundle = new Bundle ();
        bundle.putCharSequence ("cours","C");
        intent.putExtra ("bundle",bundle);
        startActivity (intent);
            finish ();
        }


        if(view.getId () == R.id.cpp_L){
        Intent intent = new Intent (getApplicationContext (),Date_Agenda.class);
        Bundle bundle = new Bundle ();
        bundle.putCharSequence ("cours","Cpp");
        intent.putExtra ("bundle",bundle);
        startActivity (intent);
        finish ();
        }
 }
}
