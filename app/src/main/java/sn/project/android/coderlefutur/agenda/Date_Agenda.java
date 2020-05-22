package sn.project.android.coderlefutur.agenda;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.List;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Agenda;
import sn.project.android.coderlefutur.model.Cours;

public class Date_Agenda extends AppCompatActivity {

    private Dialog dialog;
    private TimePicker picker;
    private Button annuller,modifier;
    private String string;
    private CheckBox check1, check2, check3, check4, check5, check6, check7;
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.date_agenda);

        dialog = new Dialog (this);
        dataBaseManager  = new DataBaseManager (this);

        Bundle extra = getIntent ().getBundleExtra ("bundle");
        string = (String)extra.get ("cours");
        Toast.makeText (getApplicationContext ( ), string, Toast.LENGTH_LONG).show ( );

        modifier = findViewById (R.id.modifier);
        annuller = findViewById (R.id.annuler);

        check1 =  findViewById (R.id.check1);
        check2 =  findViewById (R.id.check2);
        check3 = findViewById (R.id.check3);
        check4 = findViewById (R.id.check4);
        check5 = findViewById (R.id.check5);
        check6 = findViewById (R.id.check6);
        check7 = findViewById (R.id.check7);

        picker = findViewById (R.id.heure);
        picker.setIs24HourView (true);


        DisplayMetrics dm = new DisplayMetrics ( );
        getWindowManager ( ).getDefaultDisplay ( ).getMetrics (dm);
        int Width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow ( ).setLayout ((int) (Width * .8), (int) (height * .7));


        annuller.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                dialog.dismiss ();    }
        });

        modifier.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                    List<Cours> coursList = dataBaseManager.getCours (string);
                    for (Cours c : coursList) {
                        if ( check1.isChecked ( )  || check2.isChecked ( ) || check3.isChecked ( ) ||
                             check4.isChecked ( ) || check5.isChecked ( ) || check6.isChecked ( ) || check7.isChecked ( ) ) {
                            Agenda agenda1 = new Agenda (
                                    check1.isChecked () ? check1.getText ( ).toString ( ) : "",
                                    check2.isChecked () ? check2.getText ( ).toString ( ) : "",
                                    check3.isChecked () ? check3.getText ( ).toString ( ) : "",
                                    check4.isChecked () ? check4.getText ( ).toString ( ) : "",
                                    check5.isChecked () ? check5.getText ( ).toString ( ) : "",
                                    check6.isChecked () ? check6.getText ( ).toString ( ) : "",
                                    check7.isChecked () ? check7.getText ( ).toString ( ) : "",
                                    picker.getCurrentHour ( ), picker.getCurrentMinute ( ), c,false);
                                    dataBaseManager.insertAgenda (agenda1);
                                    finish ();

                               }
                        if ( !check1.isChecked ( ) && !check2.isChecked ( ) && !check3.isChecked ( ) &&
                               !check4.isChecked ( ) && !check5.isChecked ( ) && !check6.isChecked ( ) && !check7.isChecked ( )  ){
                               Toast.makeText (getApplicationContext (),"Veuillez selectionner une date",Toast.LENGTH_LONG).show ();

                        }
                    }


            }
        });
    }
}
