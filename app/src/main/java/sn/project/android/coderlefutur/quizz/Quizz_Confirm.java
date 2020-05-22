package sn.project.android.coderlefutur.quizz;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.authentification.SharedPreference;


public class Quizz_Confirm extends AppCompatActivity {

    String matiere;
    Button btn_niveau1, btn_niveau2, btn_niveau3;
    ImageButton btn_niveau4, btn_niveau5, btn_niveau6, btn_niveau7, btn_niveau8;
    GridLayout relativeLayout;
    private SharedPreference sharedPreference = new SharedPreference ();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_quizz__confirm);

        btn_niveau1 = findViewById (R.id.btn_niveau1);
        btn_niveau2 = findViewById (R.id.btn_niveau2);
        btn_niveau3 = findViewById (R.id.btn_niveau3);
        btn_niveau4 = findViewById (R.id.btn_niveau4);
        btn_niveau5 = findViewById (R.id.btn_niveau5);
        btn_niveau6 = findViewById (R.id.btn_niveau6);
        btn_niveau7 = findViewById (R.id.btn_niveau7);
        btn_niveau8 = findViewById (R.id.btn_niveau8);
        relativeLayout = findViewById (R.id.relativelayoutConfirm);

        //Recupere les valeurs envoyes depuis l'autre activite
        Bundle bundle = getIntent ( ).getExtras ( );
        matiere = bundle.getString ("cours");

        if ( matiere.equals ("JAVA") ) {
            String src = "c_java";
            int resid = getApplicationContext ( ).getResources ( ).
                    getIdentifier (src, "drawable", getApplicationContext ( ).getPackageName ( ));
            relativeLayout.setBackgroundResource (resid);

        } else if ( matiere.equals ("JavaScript") ) {
            String src = "c_js";
            int resid = getApplicationContext ( ).getResources ( ).
                    getIdentifier (src, "drawable", getApplicationContext ( ).getPackageName ( ));
            relativeLayout.setBackgroundResource (resid);
        } else if ( matiere.equals ("C") ) {
            String src = "c_c";
            int resid = getApplicationContext ( ).getResources ( ).
                    getIdentifier (src, "drawable", getApplicationContext ( ).getPackageName ( ));
            relativeLayout.setBackgroundResource (resid);
        } else if ( matiere.equals ("Cpp") ) {
            String src = "c_c__";
            int resid = getApplicationContext ( ).getResources ( ).
                    getIdentifier (src, "drawable", getApplicationContext ( ).getPackageName ( ));
            relativeLayout.setBackgroundResource (resid);
        } else if ( matiere.equals ("PHP") ) {
            String src = "c_php";
            int resid = getApplicationContext ( ).getResources ( ).
                    getIdentifier (src, "drawable", getApplicationContext ( ).getPackageName ( ));
            relativeLayout.setBackgroundResource (resid);
        } else if ( matiere.equals ("HTML") ) {
            String src = "c_html";
            int resid = getApplicationContext ( ).getResources ( ).
                    getIdentifier (src, "drawable", getApplicationContext ( ).getPackageName ( ));
            relativeLayout.setBackgroundResource (resid);
        }

        btn_niveau1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                Bundle bundle = new Bundle ( );
                bundle.putString ("cours", matiere);
                bundle.putString ("niveau", "niveau1");
                intent.putExtras (bundle);

                startActivity (intent);
            }
        });
        btn_niveau2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {

                //JAVA
                boolean b1 = sharedPreference.getBooleanJAVA (getApplicationContext ( ));
                //JS
                boolean b2 = sharedPreference.getBooleanJS (getApplicationContext ( ));
                //CPP
                boolean b3 = sharedPreference.getBooleanCPP (getApplicationContext ( ));
                //C
                boolean b4 = sharedPreference.getBooleanC (getApplicationContext ( ));
                //PHP
                boolean b5 = sharedPreference.getBooleanPHP (getApplicationContext ( ));
                //HTML
                boolean b6 = sharedPreference.getBooleanHTML (getApplicationContext ( ));
                if ( b1 == true && matiere.equals ("JAVA") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau2");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b2 == true && matiere.equals ("JavaScript") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau2");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b3 == true && matiere.equals ("Cpp") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau2");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else  if ( b4 == true && matiere.equals ("C") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau2");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b5 == true && matiere.equals ("PHP") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau2");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b6 == true && matiere.equals ("HTML") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau2");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                } else {
                    StyleableToast.makeText (getApplicationContext ( ), "Veuillez completer le niveau 1",R.style.niveauToast).show ( );
                }

            }
        });




        btn_niveau3.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {


                //JAVA
                boolean b1 = sharedPreference.getBooleanJAVA1 (getApplicationContext ( ));
                //JS
                boolean b2 = sharedPreference.getBooleanJS1 (getApplicationContext ( ));
                //CPP
                boolean b3 = sharedPreference.getBooleanCPP1 (getApplicationContext ( ));
                //C
                boolean b4 = sharedPreference.getBooleanC1 (getApplicationContext ( ));
                //PHP
                boolean b5 = sharedPreference.getBooleanPHP1 (getApplicationContext ( ));
                //HTML
                boolean b6 = sharedPreference.getBooleanHTML1 (getApplicationContext ( ));
                if ( b1 == true && matiere.equals ("JAVA") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau3");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b2 == true && matiere.equals ("JavaScript") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau3");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b3 == true && matiere.equals ("Cpp") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau3");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else  if ( b4 == true && matiere.equals ("C") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau3");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b5 == true && matiere.equals ("PHP") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau3");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                }
                else if ( b6 == true && matiere.equals ("HTML") ) {
                    Intent intent = new Intent (getApplicationContext ( ), Quizz_Menu.class);

                    Bundle bundle = new Bundle ( );
                    bundle.putString ("cours", matiere);
                    bundle.putString ("niveau", "niveau3");
                    intent.putExtras (bundle);

                    startActivity (intent);
                    finish ();
                } else {
                    StyleableToast.makeText (getApplicationContext ( ), "Veuillez completer le niveau 2",R.style.niveauToast).show ( );
                }


            }
        });
        btn_niveau4.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText (getApplicationContext ( ), "Disponible dans les prochaines versions",R.style.niveauToast).show ( );
            }
        });
        btn_niveau5.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText (getApplicationContext ( ), "Disponible dans les prochaines versions",R.style.niveauToast).show ( );
            }
        });
        btn_niveau6.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText (getApplicationContext ( ), "Disponible dans les prochaines versions",R.style.niveauToast).show ( );
            }
        });
        btn_niveau7.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText (getApplicationContext ( ), "Disponible dans les prochaines versions",R.style.niveauToast).show ( );
            }
        });
        btn_niveau8.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText (getApplicationContext ( ), "Disponible dans les prochaines versions",R.style.niveauToast).show ( );
            }
        });
    }

    public void btn_jouer(View view) {
        Button btn1 = (Button) findViewById(R.id.btn_1);
        AlphaAnimation alpha = new AlphaAnimation(0f, 1f);
        alpha.setDuration(500);

        btn1.startAnimation(alpha);

        Intent intent = new Intent(getApplicationContext(), Quizz_Menu.class);

        Bundle bundle = new Bundle();
        bundle.putString("cours", matiere);
        intent.putExtras(bundle);

        startActivity(intent);
        //animation
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
