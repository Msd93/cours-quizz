package sn.project.android.coderlefutur;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;

import com.mikhaellopez.circularimageview.CircularImageView;

import sn.project.android.coderlefutur.agenda.Acceuil_Agenda;
import sn.project.android.coderlefutur.cours.Activity_C;
import sn.project.android.coderlefutur.cours.Activity_CPlusPlus;
import sn.project.android.coderlefutur.cours.Activity_Favori_Cours;
import sn.project.android.coderlefutur.cours.Activity_Html;
import sn.project.android.coderlefutur.cours.Activity_JS;
import sn.project.android.coderlefutur.cours.Activity_Java;
import sn.project.android.coderlefutur.cours.Activity_PHP;
import sn.project.android.coderlefutur.model.Freq;
import sn.project.android.coderlefutur.quizz.Quizz_Detail;
import sn.project.android.coderlefutur.report.Frequentation;

public class MenuApp extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    private CircularImageView circularImageViewJava,circularImageViewPHP,circularImageViewHTML,
                              circularImageViewC,circularImageViewCpp,circularImageViewJS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu_app);


        navigationView = (NavigationView)findViewById (R.id.navigationView);
        drawerLayout =(DrawerLayout) findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        navigationView.getMenu ().getItem (0).setOnMenuItemClickListener (new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                drawerLayout.closeDrawer (GravityCompat.START);
                return true;
            }
         });

        navigationView.getMenu().getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentJava = new Intent(getApplicationContext(), Activity_Favori_Cours.class);
                startActivity(intentJava);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        navigationView.getMenu ().getItem (2).setOnMenuItemClickListener (new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentJava = new Intent (getApplicationContext(), Acceuil_Agenda.class);
                startActivity(intentJava);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
         });

        navigationView.getMenu().getItem(3).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentJava = new Intent(getApplicationContext(), Quizz_Detail.class);
                startActivity(intentJava);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        navigationView.getMenu().getItem(4).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentJava = new Intent(getApplicationContext(), Frequentation.class);
                startActivity(intentJava);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        navigationView.getMenu().getItem(5).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentJava = new Intent(getApplicationContext(), Apropos.class);
                startActivity(intentJava);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        //au click sur circleviewJava
        circularImageViewJava = (CircularImageView) findViewById(R.id.circleviewJava);
        circularImageViewJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent (getApplicationContext(), Activity_Java.class);
                startActivity(intentJava);
                //finish();
            }
        });
        //au click sur circleviewJS
        circularImageViewJS = (CircularImageView) findViewById(R.id.circleviewJS);
        circularImageViewJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent (getApplicationContext(), Activity_JS.class);
                startActivity(intentJava);
                //finish();
            }
        });

        //au click sur circleviewPHP
        circularImageViewPHP = (CircularImageView) findViewById(R.id.circleviewPHP);
        circularImageViewPHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent(getApplicationContext(), Activity_PHP.class);
                startActivity(intentJava);
                //finish();
            }
        });

        //au click sur circleviewHTML
        circularImageViewHTML = (CircularImageView) findViewById(R.id.circleviewHTML);
        circularImageViewHTML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent(getApplicationContext(), Activity_Html.class);
                startActivity(intentJava);
                //finish();
            }
        });

        //au click sur circleviewC
        circularImageViewC = (CircularImageView) findViewById(R.id.circleviewC);
        circularImageViewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent(getApplicationContext(), Activity_C.class);
                startActivity(intentJava);
                //finish();
            }
        });
        //au click sur circleviewCpp
        circularImageViewCpp = (CircularImageView) findViewById(R.id.circleviewCpp);
        circularImageViewCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent(getApplicationContext(), Activity_CPlusPlus.class);
                startActivity(intentJava);
                //finish();
            }
        });
        /**
        //au click sur circleviewJS
        circularImageViewPHP = (CircularImageView) findViewById(R.id.circleviewCpp);
        circularImageViewJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJava = new Intent(getApplicationContext(), Activity_CPlusPlus.class);
                startActivity(intentJava);
                //finish();
            }
        });*/
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
