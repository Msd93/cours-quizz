package sn.project.android.coderlefutur.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Module;

public class Adapter_Favori_Cours extends BaseAdapter {

    // Mes champs
    private Context context;
    private ArrayList<Module> moduleArrayList;
    private LayoutInflater layoutInflater;
    private DataBaseManager dataBaseManager;

    public Adapter_Favori_Cours(Context context, ArrayList<Module> moduleArrayList) {
        this.context = context;
        this.moduleArrayList = moduleArrayList;
        this.layoutInflater = LayoutInflater.from (context);
    }

    @Override
    public int getCount() {
        return moduleArrayList.size ();
    }

    @Override
    public Module getItem(int i) {
        return moduleArrayList.get (i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        dataBaseManager = new DataBaseManager(context);
        view = layoutInflater.inflate (R.layout.adapter_item_favori_cours,null);
        //Recuperere les informations des items;
        Module e = getItem (i);
        final String nomModule = e.getNomModule();
        final String nomCours = e.getCours().getNomCours();

        //Recuperer les Widgets qu'on va modifier apres
        TextView textViewfc = (TextView) view.findViewById (R.id.nomfavoriscours);
        Button buttonSupp = (Button) view.findViewById(R.id.btn_sup_fav_cours);
        textViewfc.setText (nomModule);

        ImageView img = view.findViewById (R.id.item_img_fv_cours);

        if(nomCours.equals ("JAVA")){
            String src = "c_java";
            int resid = context.getResources ().
                    getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }
        else if(nomCours.equals("JavaScript")){
            String src = "c_js";
            int resid = context.getResources ().
                    getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }
        else if(nomCours.equals("PHP")){
            String src = "c_php";
            int resid = context.getResources ().
                    getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }
        else if(nomCours.equals("Cpp")){
            String src = "c_c__";
            int resid = context.getResources ().
                    getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }
        else if(nomCours.equals("HTML")){
            String src = "c_html";
            int resid = context.getResources ().
                    getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }else if(nomCours.equals("C")){
            String src = "c_c";
            int resid = context.getResources ().
                    getIdentifier (src,"drawable",context.getPackageName ());
            img.setImageResource (resid);
        }


        buttonSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseManager.modifyModuleFavori(nomModule,"non");
                moduleArrayList.remove(getItem(i));
                notifyDataSetChanged();
                Toast.makeText(context,
                        "module enleve des favoris",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


//    AdapterView.OnItemClickListener(new )
}