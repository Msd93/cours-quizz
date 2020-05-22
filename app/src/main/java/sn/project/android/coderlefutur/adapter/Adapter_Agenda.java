package sn.project.android.coderlefutur.adapter;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;


import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_1;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_2;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_3;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_4;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_5;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_6;
import sn.project.android.coderlefutur.alarm.Notifcation_receiver_7;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Agenda;

import static android.content.Context.ALARM_SERVICE;

public class Adapter_Agenda extends BaseAdapter {


    // Mes champs
    private Context context;
    private List<Agenda> agendaList;
    private Agenda agenda;
    private LayoutInflater layoutInflater;
    private DataBaseManager dataBaseManager;
    private Dialog dialog;
    private NotificationManagerCompat notificationManager;

    public Adapter_Agenda(Context context, List<Agenda> agendaList) {
        this.context = context;
        this.agendaList = agendaList;
        this.layoutInflater = LayoutInflater.from (context);
        dataBaseManager = new DataBaseManager (context);
        notificationManager = NotificationManagerCompat.from(context);
    }



    @Override
    public int getCount() {
        return agendaList.size ();
    }

    @Override
    public Agenda getItem(int i) {
        return agendaList.get (i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate (R.layout.item_agenda,null);

     //Recuperere les informations des items;
        agenda = getItem (i);
        int id = agenda.getIdEDT ();
        final String jour1  = agenda.getJour1 ();
        final String jour2  = agenda.getJour2 ();
        final String jour3  = agenda.getJour3 ();
        final String jour4  = agenda.getJour4 ();
        final String jour5  = agenda.getJour5 ();
        final String jour6  = agenda.getJour6 ();
        final String jour7  = agenda.getJour7 ();
        Boolean switcH = agenda.isSwitcH ();
        final int minute = agenda.getMinute ();
        final int heure = agenda.getHeure ();
        //Cours en rapport avec l'agenda
        final String nomcours = agenda.getCours ().getNomCours ();

 //Recuperer les Widgets qu'on va modifier apres


        // Choisir le nom approprié selon le cours choisis
        TextView imageView = view.findViewById (R.id.cours_image);
        imageView.setText (nomcours);

        TextView ineT = view.findViewById (R.id.textItem);

        ineT.append ( !jour2.equals ("") ? jour2.subSequence (0,3)  : "" );
        if ( !jour2.equals ("") ){ineT.append (",");}

        ineT.append ( !jour3.equals ("") ? jour3.subSequence (0,3)  : "" );
        if ( !jour3.equals ("") ){ineT.append (",");}

        ineT.append ( !jour4.equals ("") ? jour4.subSequence (0,3)  : "" );
        if ( !jour4.equals ("") ){ineT.append (",");}

        ineT.append ( !jour5.equals ("") ? jour5.subSequence (0,3)  : "" );
        if ( !jour5.equals ("") ){ineT.append (",");}

        ineT.append ( !jour6.equals ("") ? jour6.subSequence (0,3)  : "" );
        if ( !jour6.equals ("") ){ineT.append (",");}
        ineT.append ( !jour7.equals ("") ? jour7.subSequence (0,3)  : "" );
        if ( !jour7.equals ("") ){ineT.append (",");}
        ineT.append ( !jour1.equals ("") ? jour1.subSequence (0,3)  : "" );


        final TextView idTextView = view.findViewById (R.id.id_agenda);
        //final TextView coursTextView = view.findViewById (R.id.cours_agenda);
        idTextView.setText (""+id);
        //coursTextView.setText (nomcours);


        // Evenement utilise pour modifier l'emploi du temps dans l'agenda
        LinearLayout layout_item = view.findViewById (R.id.layout_item);
        layout_item.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
              /**Intent intent  = new Intent (context,UpdateAgenda.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              Bundle bundle = new Bundle ();
              bundle.putCharSequence ("cours",nomcours);
              intent.putExtra ("bundle",bundle);
              context.startActivity (intent);*/

            }
        });


        // Evenement utilisé pour activer ou desactiver l'alarm
        Switch aSwitch = view.findViewById (R.id.switchItem);
        aSwitch.setChecked (agenda.isSwitcH ());

        aSwitch.setText (heure+":" + minute);

        aSwitch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if ( b == true ){
                    agenda.setSwitcH (true);
                    dataBaseManager.updateAgenda ( agenda );
                    Toast.makeText (context,"Vous avez activer le switch "+agenda.isSwitcH (),Toast.LENGTH_LONG ).show ();



                    if ( !jour1.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,1);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }
                        Intent intent = new Intent (context,Notifcation_receiver_1.class);
                        Bundle bundle = new Bundle ();
                        bundle.putString ("JAVA",nomcours);
                        bundle.putString ("JavaScript",nomcours);
                        bundle.putString ("PHP",nomcours);
                        bundle.putString ("HTML",nomcours);
                        bundle.putString ("C",nomcours);
                        bundle.putString ("Cpp",nomcours);
                        intent.putExtra ("bundle",bundle);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set (AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }
                 if ( !jour2.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,2);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }

                        Intent intent = new Intent (context,Notifcation_receiver_2.class);
                        Bundle bundle = new Bundle ();
                     bundle.putString ("JAVA",nomcours);
                     bundle.putString ("JavaScript",nomcours);
                     bundle.putString ("PHP",nomcours);
                     bundle.putString ("HTML",nomcours);
                     bundle.putString ("C",nomcours);
                     bundle.putString ("Cpp",nomcours);
                        intent.putExtra ("bundle",bundle);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),2,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set (AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }
                 if ( !jour3.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,3);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }

                        Intent intent = new Intent (context,Notifcation_receiver_3.class);
                        Bundle bundle = new Bundle ();
                     bundle.putString ("JAVA",nomcours);
                     bundle.putString ("JavaScript",nomcours);
                     bundle.putString ("PHP",nomcours);
                     bundle.putString ("HTML",nomcours);
                     bundle.putString ("C",nomcours);
                     bundle.putString ("Cpp",nomcours);
                        intent.putExtra ("bundle",bundle);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),3,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set (AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }
                 if ( !jour4.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,4);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }

                        Intent intent = new Intent (context,Notifcation_receiver_4.class);
                        Bundle bundle = new Bundle ();
                        bundle.putString ("cours",nomcours);
                     bundle.putString ("JAVA",nomcours);
                     bundle.putString ("JavaScript",nomcours);
                     bundle.putString ("PHP",nomcours);
                     bundle.putString ("HTML",nomcours);
                     bundle.putString ("C",nomcours);
                     bundle.putString ("Cpp",nomcours);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),4,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }
                 if ( !jour5.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,5);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }

                        Intent intent = new Intent (context,Notifcation_receiver_5.class);
                        Bundle bundle = new Bundle ();
                     bundle.putString ("JAVA",nomcours);
                     bundle.putString ("JavaScript",nomcours);
                     bundle.putString ("PHP",nomcours);
                     bundle.putString ("HTML",nomcours);
                     bundle.putString ("C",nomcours);
                     bundle.putString ("Cpp",nomcours);
                        intent.putExtra ("bundle",bundle);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),5,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set (AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }
                 if ( !jour6.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,6);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }

                        Intent intent = new Intent (context,Notifcation_receiver_6.class);
                        Bundle bundle = new Bundle ();
                     bundle.putString ("JAVA",nomcours);
                     bundle.putString ("JavaScript",nomcours);
                     bundle.putString ("PHP",nomcours);
                     bundle.putString ("HTML",nomcours);
                     bundle.putString ("C",nomcours);
                     bundle.putString ("Cpp",nomcours);
                        intent.putExtra ("bundle",bundle);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),6,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set (AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }
                if ( !jour7.equals ("") ){
                        Calendar calendar = Calendar.getInstance ();
                        calendar.set (Calendar.HOUR_OF_DAY,heure);
                        calendar.set (Calendar.MINUTE,minute);
                        calendar.set (Calendar.SECOND,0);
                        calendar.set ( Calendar.DAY_OF_WEEK,7);

                        if( calendar.before ( Calendar.getInstance ())){
                            calendar.add ( Calendar.DATE, 7 );
                        }

                        Intent intent = new Intent (context,Notifcation_receiver_7.class);
                        Bundle bundle = new Bundle ();
                    bundle.putString ("JAVA",nomcours);
                    bundle.putString ("JavaScript",nomcours);
                    bundle.putString ("PHP",nomcours);
                    bundle.putString ("HTML",nomcours);
                    bundle.putString ("C",nomcours);
                    bundle.putString ("Cpp",nomcours);
                        intent.putExtra ("bundle",bundle);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),7,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.set (AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis (),pendingIntent);
                    }



                }
                else {
                    agenda.setSwitcH (false);
                    dataBaseManager.updateAgenda ( agenda );
                    Toast.makeText (context, "Vous avez fermer le switch " + agenda.isSwitcH ( ), Toast.LENGTH_LONG).show ( );




                    // Annuler l'alarme suivant le cours defeni
                    if ( !jour1.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_1.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }
                    if ( !jour2.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_2.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),2,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                         }
                    if ( !jour3.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_3.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),3,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);
                         }
                     if ( !jour4.equals ("") ){

                         Intent intent = new Intent (context,Notifcation_receiver_4.class);
                         PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),4,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                         AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                         alarmManager.cancel (pendingIntent);

                         }
                     if ( !jour5.equals ("") ){

                         Intent intent = new Intent (context,Notifcation_receiver_5.class);
                         PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),5,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                         AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                         alarmManager.cancel (pendingIntent);

                         }
                     if ( !jour6.equals ("") ){

                         Intent intent = new Intent (context,Notifcation_receiver_6.class);
                         PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),6,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                         AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                         alarmManager.cancel (pendingIntent);

                         }
                      if ( !jour7.equals ("") ){

                          Intent intent = new Intent (context,Notifcation_receiver_7.class);
                          PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),7,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                          AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                          alarmManager.cancel (pendingIntent);

                         }

                }

            }
        });
        ImageView img = view.findViewById (R.id.imageItem);
        int resid = context.getResources ().getIdentifier ("ic_delete_black_24dp","drawable",context.getPackageName ());
            img.setImageResource (resid);
       // Evenement utlise pour supprimer un emploi du tempsa
         img.setOnClickListener (new View.OnClickListener ( ) {
                @Override
                public void onClick(View view) {
                   dataBaseManager.deleteAgenda (Integer.parseInt ( idTextView.getText ().toString () ));
                    Toast.makeText (context,"Vous avez supprimer l agenda "+idTextView.getText ().toString (),Toast.LENGTH_LONG ).show ();

                    //Pour mettre a jour la listView
                    agendaList.remove (i);
                    Adapter_Agenda.this.notifyDataSetChanged ();






                    // Annuler l'alarme suivant le cours defeni
                    if ( !jour1.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_1.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }
                    if ( !jour2.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_2.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),2,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }
                    if ( !jour3.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_3.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),3,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);
                    }
                    if ( !jour4.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_4.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),4,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }
                    if ( !jour5.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_5.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),5,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }
                    if ( !jour6.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_6.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),6,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }
                    if ( !jour7.equals ("") ){

                        Intent intent = new Intent (context,Notifcation_receiver_7.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast (context.getApplicationContext (),7,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
                        alarmManager.cancel (pendingIntent);

                    }



                }
            });



        return view;
    }
}