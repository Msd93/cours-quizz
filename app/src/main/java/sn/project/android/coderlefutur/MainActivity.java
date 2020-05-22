package sn.project.android.coderlefutur;


import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat;


import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import sn.project.android.coderlefutur.authentification.GoogleSign;
import sn.project.android.coderlefutur.authentification.SharedPreference;

public class MainActivity extends AwesomeSplash {

    private Boolean text;
    private SharedPreference sharedPreference = new SharedPreference();

    //DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!


    @Override
    public void initSplash(ConfigSplash configSplash) {

        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.computer); //or any other drawable
        configSplash.setAnimLogoSplashDuration(3000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
       // configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(2000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(2000);
        configSplash.setPathSplashFillColor(R.color.wheat); //path object filling color


        //Customize Title
        configSplash.setTitleSplash("Coder le Futur");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(50f); //float value
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        //configSplash.setTitleFont(getResources ().getFont ()); //provide string to your font located in assets/fonts/

    }





    @Override
    public void animationsFinished() {

        text = sharedPreference.getBoolean (this);

        if(text) {
            Intent intent = new Intent (getApplicationContext ( ), GoogleSign.class);
            startActivity (intent);
            finish ( );
        }
        else{
            Intent intent = new Intent (getApplicationContext ( ), MenuApp.class);
            startActivity (intent);
            finish ( );
        }

    }
}


