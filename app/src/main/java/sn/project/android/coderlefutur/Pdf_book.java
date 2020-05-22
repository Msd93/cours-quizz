package sn.project.android.coderlefutur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Freq;

public class Pdf_book extends AppCompatActivity {

    private String module,cours;
    PDFView viewbook;
    public float zoomValue=1;
    DataBaseManager dataBaseManager;
    private Boolean aBoolean = true;
    private Long begin,end,duree;
    private int sec,hour,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_book);

       //Declanchement du chronometre pour calculer la duree passe dans l'application
        begin = System.currentTimeMillis ();


        viewbook = (PDFView) findViewById(R.id.pdfbook);

        //Recupere les valeurs envoyes depuis l'autre activite
        Bundle bundle = getIntent().getExtras();
        module = bundle.getString("book");
        cours = bundle.getString("cours");


        viewbook.fromAsset(module+".pdf").defaultPage(0).spacing(10).load();

        dataBaseManager = new DataBaseManager(getApplicationContext());
    }

    public void nextPage(View view){ viewbook.jumpTo(viewbook.getCurrentPage()+1, true);}

    public void prevPage(View view){ viewbook.jumpTo(viewbook.getCurrentPage()-1, true);}

    public void zoomIn(View view){
        ++zoomValue;
        viewbook.zoomTo(zoomValue);
        viewbook.loadPages();
    }

    public void zoomOut(View view){
        if(zoomValue!=1) {
            --zoomValue;
            viewbook.zoomTo(zoomValue);
            viewbook.loadPages();
        }
    }

    public void ajouterModuleFavori(View view) {
        if(aBoolean==true) {
            dataBaseManager.modifyModuleFavori(module, "oui");
            Toast.makeText(getApplicationContext(),
                    "Module ajouté à vos cours favoris",Toast.LENGTH_SHORT).show();
            aBoolean=false;
        }else{
            Toast.makeText(getApplicationContext(),
                    "Déja ajouté à vos cours favoris, veuillez consulter vos favoris",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ( );

        end = System.currentTimeMillis ();
        duree = begin - end ;
        sec = (int) ((end - begin) / 1000.0);
        min = (int) ((end - begin) / 60000.0);
        hour = (int) ((end - begin) / 3600000.0);

        //Calendar calendar = Calendar.getInstance ();
        //DateFormat df =  DateFormat.getDateInstance (DateFormat.LONG, Locale.FRANCE);

        String duree = ""+hour+":"+min+":"+sec;
        DateFormat df = new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        if ( !module.equals (null) && !cours.equals (null) ) {
            Freq freq = new Freq (reportDate, duree, module, cours);
            dataBaseManager.insertStat (freq);
        }

        

    }
}
