package sn.project.android.coderlefutur.authentification;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {

	public static final String PREFS_NAME = "AOP_PREFS";
	public static final String RANBEFORE = "RANBEFORE";

	public static final String JAVA = "JAVA";
	public static final String JS = "JS";
	public static final String PHP = "CPP";
	public static final String CPP = "CPP";
	public static final String HTML = "HTML";
	public static final String C = "C";

	public static final String JAVA1 = "JAVA1";
	public static final String JS1 = "JS1";
	public static final String PHP1 = "CPP1";
	public static final String CPP1 = "CPP1";
	public static final String HTML1 = "HTML1";
	public static final String C1 = "C1";

	public static final String PREFS_KEY = "AOP_PREFS_String";
	
	public SharedPreference() {
		super();
	}

	public void save(Context context, String text) {
		SharedPreferences settings;
		Editor editor;
		
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putString(PREFS_KEY, text); //3

		editor.commit(); //4
	}
	public void saveBoolean(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (RANBEFORE, text); //3

		editor.commit(); //4
	}
	public void saveBooleanJS(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (JS, text); //3

		editor.commit(); //4
	}
	public void saveBooleanJava1(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (JAVA1, text); //3

		editor.commit(); //4
	}
	public void saveBooleanCPP1(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (CPP1, text); //3

		editor.commit(); //4
	}
	public void saveBooleanC1(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (C1, text); //3

		editor.commit(); //4
	}
	public void saveBooleanHTML1(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (HTML1, text); //3

		editor.commit(); //4
	}
	public void saveBooleanPHP1(Context context, Boolean text) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2

		editor.putBoolean (PHP1, text); //3

		editor.commit(); //4
	}
    public void saveBooleanJS1(Context context, Boolean text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putBoolean (JS1, text); //3

        editor.commit(); //4
    }
    public void saveBooleanJava(Context context, Boolean text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putBoolean (JAVA, text); //3

        editor.commit(); //4
    }
    public void saveBooleanCPP(Context context, Boolean text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putBoolean (CPP, text); //3

        editor.commit(); //4
    }
    public void saveBooleanC(Context context, Boolean text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putBoolean (C, text); //3

        editor.commit(); //4
    }
    public void saveBooleanHTML(Context context, Boolean text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putBoolean (HTML, text); //3

        editor.commit(); //4
    }
    public void saveBooleanPHP(Context context, Boolean text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putBoolean (PHP, text); //3

        editor.commit(); //4
    }

	public String getValue(Context context) {
		SharedPreferences settings;
		String text;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getString(PREFS_KEY, null);
		return text;
	}

	public boolean getBooleanJS1(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (JS1,false);
		return text;
	}
	public boolean getBooleanJAVA1(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (JAVA1,false);
		return text;
	}
	public boolean getBooleanCPP1(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (CPP1,false);
		return text;
	}
	public boolean getBooleanC1(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (C1,false);
		return text;
	}
	public boolean getBooleanPHP1(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (PHP1,false);
		return text;
	}
	public boolean getBooleanHTML1(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (HTML1,false);
		return text;
	}
    public boolean getBooleanJS(Context context){
        SharedPreferences settings;
        boolean text;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = settings.getBoolean (JS,false);
        return text;
    }
    public boolean getBooleanJAVA(Context context){
        SharedPreferences settings;
        boolean text;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = settings.getBoolean (JAVA,false);
        return text;
    }
    public boolean getBooleanCPP(Context context){
        SharedPreferences settings;
        boolean text;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = settings.getBoolean (CPP,false);
        return text;
    }
    public boolean getBooleanC(Context context){
        SharedPreferences settings;
        boolean text;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = settings.getBoolean (C,false);
        return text;
    }
    public boolean getBooleanPHP(Context context){
        SharedPreferences settings;
        boolean text;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = settings.getBoolean (PHP,false);
        return text;
    }
    public boolean getBooleanHTML(Context context){
        SharedPreferences settings;
        boolean text;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = settings.getBoolean (HTML,false);
        return text;
    }
	public boolean getBoolean(Context context){
		SharedPreferences settings;
		boolean text;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getBoolean (PREFS_KEY,false);
		return text;
	}
	
	public void clearSharedPreference(Context context) {
		SharedPreferences settings;
		Editor editor;

		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();

		editor.clear();
		editor.commit();
	}

	public void removeValue(Context context) {
		SharedPreferences settings;
		Editor editor;

		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();

		editor.remove(PREFS_KEY);
		editor.commit();
	}	
}
