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

import java.util.ArrayList;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Quizz;


public class Adapter_Quizz_Detail extends BaseAdapter {


    // Mes champs
    private Context context;
    private ArrayList<Quizz> etudiantArrayList;
    private LayoutInflater layoutInflater;
    private DataBaseManager dataBaseManager ;

    public Adapter_Quizz_Detail(Context context, ArrayList<Quizz> etudiantArrayList) {
        this.context = context;
        this.etudiantArrayList = etudiantArrayList;
        this.layoutInflater = LayoutInflater.from (context);
    }



    @Override
    public int getCount() {
        return etudiantArrayList.size ();
    }

    @Override
    public Quizz getItem(int i) {
        return etudiantArrayList.get (i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        dataBaseManager = new DataBaseManager(context);

        view = layoutInflater.inflate (R.layout.adapter_item,null);
        //Recuperere les informations des items;
        Quizz e = getItem (i);
        String nomCours = e.getCours().getNomCours();

        //Recuperer les Widgets qu'on va modifier apres
        TextView datequizz = (TextView) view.findViewById (R.id.datequizz);
        datequizz.setText ("Date "+e.getDateQuizz().toString());

        TextView scorequizz = (TextView) view.findViewById (R.id.scorequizz);
        scorequizz.setText ("Score "+e.getScore ());

        TextView niveauquizz = (TextView) view.findViewById (R.id.niveau_quizz);
        niveauquizz.setText (e.getNiveau());

        ImageButton imageButton = view.findViewById(R.id.imageButtonDelete);

        ImageView img = view.findViewById (R.id.item_img);

        if(nomCours.equals ("JAVA")){
            String src = "c_java";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }
        else if(nomCours.equals("JavaScript")){
            String src = "c_js";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }else if(nomCours.equals("Cpp")){
            String src = "c_c__";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }else if(nomCours.equals("C")){
            String src = "c_c";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }else if(nomCours.equals("PHP")){
            String src = "c_php";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }else if(nomCours.equals("HTML")){
            String src = "c_html";
            int resid = context.getResources ().getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseManager.deleteQuizz(getItem(i));
                etudiantArrayList.remove(getItem(i));
                notifyDataSetChanged();
                Toast.makeText(context,
                        "Partie enlevée des statistiques",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}