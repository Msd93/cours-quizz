package sn.project.android.coderlefutur.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Freq;

public class Adapter_Frequentation extends BaseAdapter {

    // Mes champs
    private Context context;
    private List<Freq> freqList ;
    private LayoutInflater layoutInflater;
    private DataBaseManager dataBaseManager;

    public Adapter_Frequentation(Context context, List<Freq> freqList) {

        this.context = context;
        this.freqList = freqList;
        this.layoutInflater = LayoutInflater.from (context);
    }

    @Override
    public int getCount() {
        return freqList.size ();
    }

    @Override
    public Freq getItem(int i) {
        return freqList.get (i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate (R.layout.item_frequentation,null);

        dataBaseManager = new DataBaseManager (context);
        Freq freq = getItem ( i );
        String date =  freq.getDate ();
        String duree = freq.getDuree ();
        String nomcours = freq.getNomcours ();
        String nommodule = freq.getNommodule ();

        TextView date_freq = view.findViewById (R.id.date_freq);
        TextView module_feq = view.findViewById (R.id.module_freq);
        TextView duree_freq = view.findViewById (R.id.duree_freq);
        ImageButton imageButton = view.findViewById (R.id.imageButton_Delete);

        date_freq.setText (""+date);
        module_feq.setText (""+nommodule);
        duree_freq.setText ("Durée : "+duree);

        ImageView imageView = view.findViewById (R.id.img_freq);
        if(nomcours.equals ("C")){
            String src = "c_c";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            imageView.setImageResource (resid);
        }
        if ( nomcours.equals ( "HTML" ) ){
            String src = "c_html";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            imageView.setImageResource (resid);
        }
        if ( nomcours.equals ( "JavaScript" ) ){
            String src = "c_js";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            imageView.setImageResource (resid);
        }
        if ( nomcours.equals ( "JAVA" ) ){
            String src = "c_java";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            imageView.setImageResource (resid);
        }
        if ( nomcours.equals ( "PHP" ) ){
            String src = "c_php";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            imageView.setImageResource (resid);
        }
        if ( nomcours.equals ( "C++" ) ){
            String src = "c_c__";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            imageView.setImageResource (resid);

        }
        imageButton.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                dataBaseManager.deleteStat (getItem (i));
                freqList.remove (getItem (i));
                notifyDataSetChanged ();
                Toast.makeText (context,"Suppression faite avec succès",Toast.LENGTH_SHORT).show ();
            }
        });
        return view;
    }
}
