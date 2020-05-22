package sn.project.android.coderlefutur.cours;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

import sn.project.android.coderlefutur.Pdf_book;
import sn.project.android.coderlefutur.R;

public class Activity_CPlusPlus extends AppCompatActivity {

    Button btn_chap1, btn_chap2, btn_chap3, btn_chap4,
            btn_chap5, btn_chap6, btn_chap7, btn_chap8;
    private static final long DURATION_TRANSITION = 2000;
    private Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cplus_plus);

        btn_chap1 = (Button) findViewById(R.id.btn_1);  btn_chap2 = (Button) findViewById(R.id.btn_2);
        btn_chap3 = (Button) findViewById(R.id.btn_3);  btn_chap4 = (Button) findViewById(R.id.btn_4);
        btn_chap5 = (Button) findViewById(R.id.btn_5);  btn_chap6 = (Button) findViewById(R.id.btn_6);
        btn_chap7 = (Button) findViewById(R.id.btn_7);  btn_chap8 = (Button) findViewById(R.id.btn_8);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings ("unchecked")
    public void lireChapitre(View view) {

        transition = new Explode ()
                .setDuration (DURATION_TRANSITION)
                .setInterpolator (new DecelerateInterpolator ());
        getWindow ().setExitTransition (transition);

        if(view.getId()==R.id.btn_1) {
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap1.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book", book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }else if(view.getId()==R.id.btn_2){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap2.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
        else if(view.getId()==R.id.btn_3){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap3.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
        else if(view.getId()==R.id.btn_4){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap4.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
        else if(view.getId()==R.id.btn_5){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap5.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
        else if(view.getId()==R.id.btn_6){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap6.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
        else if(view.getId()==R.id.btn_7){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap7.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
        else if(view.getId()==R.id.btn_8){
            Intent i = new Intent(getApplicationContext(), Pdf_book.class);
            //Passage d'une valeur
            String book = btn_chap8.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("book",book);
            bundle.putString("cours", "C++");
            i.putExtras(bundle);
            startActivity(i, ActivityOptionsCompat
                    .makeSceneTransitionAnimation (this).toBundle ());
        }
    }
}
