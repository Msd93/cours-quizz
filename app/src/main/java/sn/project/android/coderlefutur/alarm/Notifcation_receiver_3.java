package sn.project.android.coderlefutur.alarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.agenda.Acceuil_Agenda;
import sn.project.android.coderlefutur.cours.Activity_C;
import sn.project.android.coderlefutur.cours.Activity_CPlusPlus;
import sn.project.android.coderlefutur.cours.Activity_Html;
import sn.project.android.coderlefutur.cours.Activity_JS;
import sn.project.android.coderlefutur.cours.Activity_Java;
import sn.project.android.coderlefutur.cours.Activity_PHP;

public class Notifcation_receiver_3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

    NotificationManager notificationManager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);



        Bundle extra = intent.getBundleExtra ("bundle");
        String s_JAVA = extra.getString("JAVA");
        String s_JavaScript = extra.getString("JavaScript");
        String s_C = extra.getString("C");
        String s_Cpp = extra.getString("Cpp");
        String s_HTML = extra.getString("HTML");
        String s_PHP = extra.getString("PHP");

        Intent repeating = null ;
        if ( s_HTML.equals ( "HTML" ) ){
            repeating  = new Intent (context,Activity_Html.class);
            PendingIntent pendingIntent = PendingIntent.getActivity (context,3,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentParametre = new Intent (context,Acceuil_Agenda.class);
            PendingIntent pendingParametre = PendingIntent.getActivity (context,3,intentParametre,PendingIntent.FLAG_UPDATE_CURRENT);


            Uri uri = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder (context)
                    .setContentIntent (pendingIntent)
                    .setSmallIcon (R.drawable.logo_1)
                    .setLargeIcon (BitmapFactory.decodeResource(Resources.getSystem (),R.drawable.logo_1))
                    .setColor(ContextCompat.getColor(context, R.color.blue))
                    .setLights(ContextCompat.getColor(context, R.color.blue), 1000, 1000)
                    .setVibrate(new long[]{800, 800, 800, 800})
                    .setContentTitle ("Coder le Futur")
                    .setContentText ("C'est l'heure de consulter vos cours !")
                    .setSound (uri)
                    //.addAction (R.drawable.fichier,nomcours,pendingIntent)
                    .addAction (R.drawable.parametre,"Paramètres",pendingParametre)
                    .setAutoCancel (true);


            notificationManager.notify (31,builder.build ());
        }
        if ( s_JavaScript.equals ( "JavaScript" ) ){
            repeating  = new Intent (context,Activity_JS.class);
            PendingIntent pendingIntent = PendingIntent.getActivity (context,3,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentParametre = new Intent (context,Acceuil_Agenda.class);
            PendingIntent pendingParametre = PendingIntent.getActivity (context,3,intentParametre,PendingIntent.FLAG_UPDATE_CURRENT);


            Uri uri = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder (context)
                    .setContentIntent (pendingIntent)
                    .setSmallIcon (R.drawable.logo_1)
                    .setLargeIcon (BitmapFactory.decodeResource(Resources.getSystem (),R.drawable.logo_1))
                    .setColor(ContextCompat.getColor(context, R.color.blue))
                    .setLights(ContextCompat.getColor(context, R.color.blue), 1000, 1000)
                    .setVibrate(new long[]{800, 800, 800, 800})
                    .setContentTitle ("Coder le Futur")
                    .setContentText ("C'est l'heure de consulter vos cours !")
                    .setSound (uri)
                    //.addAction (R.drawable.fichier,nomcours,pendingIntent)
                    .addAction (R.drawable.parametre,"Paramètres",pendingParametre)
                    .setAutoCancel (true);


            notificationManager.notify (32,builder.build ());
        }
        if ( s_JAVA.equals ( "JAVA" ) ){
            repeating  = new Intent (context,Activity_Java.class);
            PendingIntent pendingIntent = PendingIntent.getActivity (context,3,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentParametre = new Intent (context,Acceuil_Agenda.class);
            PendingIntent pendingParametre = PendingIntent.getActivity (context,3,intentParametre,PendingIntent.FLAG_UPDATE_CURRENT);


            Uri uri = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder (context)
                    .setContentIntent (pendingIntent)
                    .setSmallIcon (R.drawable.logo_1)
                    .setLargeIcon (BitmapFactory.decodeResource(Resources.getSystem (),R.drawable.logo_1))
                    .setColor(ContextCompat.getColor(context, R.color.blue))
                    .setLights(ContextCompat.getColor(context, R.color.blue), 1000, 1000)
                    .setVibrate(new long[]{800, 800, 800, 800})
                    .setContentTitle ("Coder le Futur")
                    .setContentText ("C'est l'heure de consulter vos cours !")
                    .setSound (uri)
                    //.addAction (R.drawable.fichier,nomcours,pendingIntent)
                    .addAction (R.drawable.parametre,"Paramètres",pendingParametre)
                    .setAutoCancel (true);


            notificationManager.notify (33,builder.build ());
        }
        if ( s_PHP.equals ( "PHP" ) ){
            repeating  = new Intent (context,Activity_PHP.class);
            PendingIntent pendingIntent = PendingIntent.getActivity (context,3,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentParametre = new Intent (context,Acceuil_Agenda.class);
            PendingIntent pendingParametre = PendingIntent.getActivity (context,3,intentParametre,PendingIntent.FLAG_UPDATE_CURRENT);


            Uri uri = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder (context)
                    .setContentIntent (pendingIntent)
                    .setSmallIcon (R.drawable.logo_1)
                    .setLargeIcon (BitmapFactory.decodeResource(Resources.getSystem (),R.drawable.logo_1))
                    .setColor(ContextCompat.getColor(context, R.color.blue))
                    .setLights(ContextCompat.getColor(context, R.color.blue), 1000, 1000)
                    .setVibrate(new long[]{800, 800, 800, 800})
                    .setContentTitle ("Coder le Futur")
                    .setContentText ("C'est l'heure de consulter vos cours !")
                    .setSound (uri)
                    //.addAction (R.drawable.fichier,nomcours,pendingIntent)
                    .addAction (R.drawable.parametre,"Paramètres",pendingParametre)
                    .setAutoCancel (true);


            notificationManager.notify (34,builder.build ());
        }
        if ( s_C.equals ( "C" ) ){
            repeating  = new Intent (context,Activity_C.class);
            PendingIntent pendingIntent = PendingIntent.getActivity (context,3,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentParametre = new Intent (context,Acceuil_Agenda.class);
            PendingIntent pendingParametre = PendingIntent.getActivity (context,3,intentParametre,PendingIntent.FLAG_UPDATE_CURRENT);


            Uri uri = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder (context)
                    .setContentIntent (pendingIntent)
                    .setSmallIcon (R.drawable.logo_1)
                    .setLargeIcon (BitmapFactory.decodeResource(Resources.getSystem (),R.drawable.logo_1))
                    .setColor(ContextCompat.getColor(context, R.color.blue))
                    .setLights(ContextCompat.getColor(context, R.color.blue), 1000, 1000)
                    .setVibrate(new long[]{800, 800, 800, 800})
                    .setContentTitle ("Coder le Futur")
                    .setContentText ("C'est l'heure de consulter vos cours !")
                    .setSound (uri)
                    //.addAction (R.drawable.fichier,nomcours,pendingIntent)
                    .addAction (R.drawable.parametre,"Paramètres",pendingParametre)
                    .setAutoCancel (true);


            notificationManager.notify (35,builder.build ());
        }
        if ( s_Cpp.equals ( "Cpp" ) ){
            repeating  = new Intent (context,Activity_CPlusPlus.class);
            PendingIntent pendingIntent = PendingIntent.getActivity (context,3,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentParametre = new Intent (context,Acceuil_Agenda.class);
            PendingIntent pendingParametre = PendingIntent.getActivity (context,3,intentParametre,PendingIntent.FLAG_UPDATE_CURRENT);


            Uri uri = RingtoneManager.getDefaultUri (RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder (context)
                    .setContentIntent (pendingIntent)
                    .setSmallIcon (R.drawable.logo_1)
                    .setLargeIcon (BitmapFactory.decodeResource(Resources.getSystem (),R.drawable.logo_1))
                    .setColor(ContextCompat.getColor(context, R.color.blue))
                    .setLights(ContextCompat.getColor(context, R.color.blue), 1000, 1000)
                    .setVibrate(new long[]{800, 800, 800, 800})
                    .setContentTitle ("Coder le Futur")
                    .setContentText ("C'est l'heure de consulter vos cours !")
                    .setSound (uri)
                    //.addAction (R.drawable.fichier,nomcours,pendingIntent)
                    .addAction (R.drawable.parametre,"Paramètres",pendingParametre)
                    .setAutoCancel (true);


            notificationManager.notify (36,builder.build ());
        }



    }
}
