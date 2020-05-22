package sn.project.android.coderlefutur.quizz;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.asynctask.AsynctaskScore;

public class Quizz_Detail extends AppCompatActivity {

    Dialog dialog;
    TextView textViewPartie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_detail);

        dialog = new Dialog(this);
        textViewPartie = (TextView) findViewById(R.id.textViewPartie);

        // asynctask pour charger les statistiques
        ListView listViewQuizz = findViewById(R.id.listView_quizz);
        AsynctaskScore asynctaskScore = new AsynctaskScore(this,listViewQuizz,textViewPartie);
        asynctaskScore.execute();
    }

    public void showPopup(View view){
        LinearLayout linearLayoutjava;
        LinearLayout linearLayoutjavascript;
        LinearLayout linearLayoutC;
        LinearLayout linearLayouthtml;
        LinearLayout linearLayoutPhp;
        LinearLayout linearLayoutCpp;

        dialog.setContentView(R.layout.liste_cours_quizz);

        linearLayoutjava = (LinearLayout) dialog.findViewById(R.id.java);
        linearLayoutjavascript = (LinearLayout) dialog.findViewById(R.id.js);
        linearLayoutC = dialog.findViewById(R.id.c);
        linearLayouthtml = dialog.findViewById(R.id.html);
        linearLayoutPhp = dialog.findViewById(R.id.php);
        linearLayoutCpp = dialog.findViewById(R.id.cpp);

        // ceci nous redirige vers le quizz java
        linearLayoutjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quizz_Confirm.class);

                Bundle bundle = new Bundle();
                bundle.putString("cours", "JAVA");
                intent.putExtras(bundle);

                startActivity(intent);

                dialog.dismiss();
            }
        });
        // ceci nous redirige vers le quizz javascript
        linearLayoutjavascript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quizz_Confirm.class);

                Bundle bundle = new Bundle();
                bundle.putString("cours", "JavaScript");
                intent.putExtras(bundle);

                startActivity(intent);

                dialog.dismiss();
            }
        });
        linearLayoutC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quizz_Confirm.class);

                Bundle bundle = new Bundle();
                bundle.putString("cours", "C");
                intent.putExtras(bundle);

                startActivity(intent);

                dialog.dismiss();
            }
        });
        linearLayoutCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quizz_Confirm.class);

                Bundle bundle = new Bundle();
                bundle.putString("cours", "Cpp");
                intent.putExtras(bundle);

                startActivity(intent);

                dialog.dismiss();
            }
        });
        linearLayouthtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quizz_Confirm.class);

                Bundle bundle = new Bundle();
                bundle.putString("cours", "HTML");
                intent.putExtras(bundle);

                startActivity(intent);

                dialog.dismiss();
            }
        });
        linearLayoutPhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quizz_Confirm.class);

                Bundle bundle = new Bundle();
                bundle.putString("cours", "PHP");
                intent.putExtras(bundle);

                startActivity(intent);

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void clearStatistique(View view) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
