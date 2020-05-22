package sn.project.android.coderlefutur.quizz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.Date;
import java.util.List;

import jp.shts.android.storiesprogressview.StoriesProgressView;
import sn.project.android.coderlefutur.R;
import sn.project.android.coderlefutur.authentification.SharedPreference;
import sn.project.android.coderlefutur.database.DataBaseManager;
import sn.project.android.coderlefutur.model.Cours;
import sn.project.android.coderlefutur.model.Quizz;


public class Quizz_Menu extends AppCompatActivity {
    StoriesProgressView storiesProgressView;
    Dialog dialog;
    private DataBaseManager dataBaseManager;
    Button answer1,answer2,answer3,answer4;
    TextView score,question,btn_close;
    ImageView img_sound;
    private String matiere;
    private String niveau;
    private Boolean sound = true;
    private MediaPlayer mpC;
    private MediaPlayer mpF;
    private String mAnswer;
    private int mScore = 0;
    Vibrator vibrator;

    private Questions_Java mQuestions = new Questions_Java();
    private Questions_JS mQuestionsJS = new Questions_JS();
    private Questions_C mQuestionsC = new Questions_C();
    private Questions_Cpp mQuestionsCpp = new Questions_Cpp();
    private Questions_Html mQuestionsHtml = new Questions_Html();
    private Questions_Php mQuestionsPhp = new Questions_Php();

    private SharedPreference sharedPreference = new SharedPreference ();


    int qid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz__menu);

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        img_sound = (ImageView) findViewById(R.id.img_sound);
        btn_close = findViewById(R.id.btnClose);


        mpC = MediaPlayer.create(getApplicationContext(),R.raw.correct);
        mpF = MediaPlayer.create(getApplicationContext(),R.raw.faux);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        score.setText("Score "+mScore);

        dialog = new Dialog(this);
        dataBaseManager = new DataBaseManager(this);
        //Recupere les valeurs envoyes depuis l'autre activite
        Bundle bundle = getIntent().getExtras();
        matiere = bundle.getString("cours");
        niveau = bundle.getString("niveau");
        if(niveau.equals("niveau1")){
            qid=0;
        }else if(niveau.equals("niveau2")){
            qid=5;
        }else if(niveau.equals("niveau3")){
            qid=10;
        }
        barreDeProgression();
        updateQuestion(qid);


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(answer1.getText() == mAnswer){
                    enableDisablempC();
                    StyleableToast.makeText(getApplicationContext(),"Bonne réponse",R.style.exampleToast).show();
                    mScore++;
                    score.setText("Score "+mScore);
                    updateQuestion(++qid);
                }else{
                    enableDisablempF();
                    vibrator.vibrate(500);
                    Toast.makeText(getApplicationContext(),"Mauvaise réponse",Toast.LENGTH_SHORT).show();
                    updateQuestion(++qid);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer2.getText() == mAnswer){
                    enableDisablempC();
                    StyleableToast.makeText(getApplicationContext(),"Bonne réponse",R.style.exampleToast).show();
                    mScore++;
                    score.setText("Score "+mScore);
                    updateQuestion(++qid);
                }else{
                    enableDisablempF();
                    vibrator.vibrate(500);
                    Toast.makeText(getApplicationContext(),"Mauvaise réponse",Toast.LENGTH_SHORT).show();
                    updateQuestion(++qid);
                }
            }

        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText() == mAnswer){
                    enableDisablempC();
                    StyleableToast.makeText(getApplicationContext(),"Bonne réponse",R.style.exampleToast).show();
                    mScore++;
                    score.setText("Score "+mScore);
                    updateQuestion(++qid);
                }else{
                    enableDisablempF();
                    vibrator.vibrate(500);
                    Toast.makeText(getApplicationContext(),"Mauvaise réponse",Toast.LENGTH_SHORT).show();
                    updateQuestion(++qid);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText() == mAnswer){
                    enableDisablempC();
                    StyleableToast.makeText(getApplicationContext(),"Bonne réponse",R.style.exampleToast).show();
                    mScore++;
                    score.setText("Score "+mScore);
                    updateQuestion(++qid);
                }else{
                    enableDisablempF();
                    vibrator.vibrate(500);
                    Toast.makeText(getApplicationContext(),"Mauvaise réponse",Toast.LENGTH_SHORT).show();
                    updateQuestion(++qid);
                }
            }
        });

        //
        img_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sound) {
                    sound = false;
                    String src = "pas_de_son";
                    int resid = getApplicationContext().getResources().
                            getIdentifier(src, "drawable", getApplicationContext().getPackageName());
                    img_sound.setImageResource(resid);
                }else{
                    sound = true;
                    String src = "son";
                    int resid = getApplicationContext().getResources().
                            getIdentifier(src, "drawable", getApplicationContext().getPackageName());
                    img_sound.setImageResource(resid);
                }
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quizz_Menu.this);
                alertDialogBuilder.
                        setMessage("Voulez-vous quitter la parie ").
                        setCancelable(false)
                        .setPositiveButton(" OUI ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(),Quizz_Detail.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton(" NON ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alertDialogBuilder.setCancelable(true);
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    private void updateQuestion(int num){
        if(niveau.equals("niveau1") && num==5){
            gameOver();
        }else if(niveau.equals("niveau2") && num==10){
            gameOver();
        }else if(niveau.equals("niveau3") && num >= 15){
            gameOver();
        }else {
            if(matiere.equals("JAVA")) {
                if(niveau.equals("niveau1")) {
                    question.setText(mQuestions.getQuestion(num));
                    answer1.setText(mQuestions.getChoice1(num));
                    answer2.setText(mQuestions.getChoice2(num));
                    answer3.setText(mQuestions.getChoice3(num));
                    answer4.setText(mQuestions.getChoice4(num));
                    mAnswer = mQuestions.getCorrectAnswer(num);
                }else if(niveau.equals("niveau2")){
                    question.setText(mQuestions.getQuestion(num));
                    answer1.setText(mQuestions.getChoice1(num));
                    answer2.setText(mQuestions.getChoice2(num));
                    answer3.setText(mQuestions.getChoice3(num));
                    answer4.setText(mQuestions.getChoice4(num));
                    mAnswer = mQuestions.getCorrectAnswer(num);
                }else if(niveau.equals("niveau3")){
                    question.setText(mQuestions.getQuestion(num));
                    answer1.setText(mQuestions.getChoice1(num));
                    answer2.setText(mQuestions.getChoice2(num));
                    answer3.setText(mQuestions.getChoice3(num));
                    answer4.setText(mQuestions.getChoice4(num));
                    mAnswer = mQuestions.getCorrectAnswer(num);
                }


            }else if(matiere.equals("JavaScript")){
                if(niveau.equals("niveau1")) {
                    question.setText(mQuestionsJS.getQuestion(num));
                    answer1.setText(mQuestionsJS.getChoice1(num));
                    answer2.setText(mQuestionsJS.getChoice2(num));
                    answer3.setText(mQuestionsJS.getChoice3(num));
                    answer4.setText(mQuestionsJS.getChoice4(num));
                    mAnswer = mQuestionsJS.getCorrectAnswer(num);
                }else if(niveau.equals("niveau2")){
                    question.setText(mQuestionsJS.getQuestion(num));
                    answer1.setText(mQuestionsJS.getChoice1(num));
                    answer2.setText(mQuestionsJS.getChoice2(num));
                    answer3.setText(mQuestionsJS.getChoice3(num));
                    answer4.setText(mQuestionsJS.getChoice4(num));
                    mAnswer = mQuestionsJS.getCorrectAnswer(num);
                }else if(niveau.equals("niveau3")){
                    question.setText(mQuestionsJS.getQuestion(num));
                    answer1.setText(mQuestionsJS.getChoice1(num));
                    answer2.setText(mQuestionsJS.getChoice2(num));
                    answer3.setText(mQuestionsJS.getChoice3(num));
                    answer4.setText(mQuestionsJS.getChoice4(num));
                    mAnswer = mQuestionsJS.getCorrectAnswer(num);
                }


            }else if(matiere.equals("C")){
                if(niveau.equals("niveau1")){
                    question.setText(mQuestionsC.getQuestion(num));
                    answer1.setText(mQuestionsC.getChoice1(num));
                    answer2.setText(mQuestionsC.getChoice2(num));
                    answer3.setText(mQuestionsC.getChoice3(num));
                    answer4.setText(mQuestionsC.getChoice4(num));
                    mAnswer = mQuestionsC.getCorrectAnswer(num);
                }else if(niveau.equals("niveau2")){
                    question.setText(mQuestionsC.getQuestion(num));
                    answer1.setText(mQuestionsC.getChoice1(num));
                    answer2.setText(mQuestionsC.getChoice2(num));
                    answer3.setText(mQuestionsC.getChoice3(num));
                    answer4.setText(mQuestionsC.getChoice4(num));
                    mAnswer = mQuestionsC.getCorrectAnswer(num);
                }else if(niveau.equals("niveau3")){
                    question.setText(mQuestionsC.getQuestion(num));
                    answer1.setText(mQuestionsC.getChoice1(num));
                    answer2.setText(mQuestionsC.getChoice2(num));
                    answer3.setText(mQuestionsC.getChoice3(num));
                    answer4.setText(mQuestionsC.getChoice4(num));
                    mAnswer = mQuestionsC.getCorrectAnswer(num);
                }


            }else if(matiere.equals("Cpp")) {
                 if (niveau.equals("niveau1")){
                    question.setText(mQuestionsCpp.getQuestion(num));
                    answer1.setText(mQuestionsCpp.getChoice1(num));
                    answer2.setText(mQuestionsCpp.getChoice2(num));
                    answer3.setText(mQuestionsCpp.getChoice3(num));
                    answer4.setText(mQuestionsCpp.getChoice4(num));
                    mAnswer = mQuestionsCpp.getCorrectAnswer(num);
                }else if(niveau.equals("niveau2")){
                    question.setText(mQuestionsCpp.getQuestion(num));
                    answer1.setText(mQuestionsCpp.getChoice1(num));
                    answer2.setText(mQuestionsCpp.getChoice2(num));
                    answer3.setText(mQuestionsCpp.getChoice3(num));
                    answer4.setText(mQuestionsCpp.getChoice4(num));
                    mAnswer = mQuestionsCpp.getCorrectAnswer(num);
                }else if(niveau.equals("niveau3")){
                    question.setText(mQuestionsCpp.getQuestion(num));
                    answer1.setText(mQuestionsCpp.getChoice1(num));
                    answer2.setText(mQuestionsCpp.getChoice2(num));
                    answer3.setText(mQuestionsCpp.getChoice3(num));
                    answer4.setText(mQuestionsCpp.getChoice4(num));
                    mAnswer = mQuestionsCpp.getCorrectAnswer(num);
                }


            }else if(matiere.equals("HTML")) {
                if (niveau.equals("niveau1")){
                    question.setText(mQuestionsHtml.getQuestion(num));
                    answer1.setText(mQuestionsHtml.getChoice1(num));
                    answer2.setText(mQuestionsHtml.getChoice2(num));
                    answer3.setText(mQuestionsHtml.getChoice3(num));
                    answer4.setText(mQuestionsHtml.getChoice4(num));
                    mAnswer = mQuestionsHtml.getCorrectAnswer(num);
                }else if(niveau.equals("niveau2")){
                    question.setText(mQuestionsHtml.getQuestion(num));
                    answer1.setText(mQuestionsHtml.getChoice1(num));
                    answer2.setText(mQuestionsHtml.getChoice2(num));
                    answer3.setText(mQuestionsHtml.getChoice3(num));
                    answer4.setText(mQuestionsHtml.getChoice4(num));
                    mAnswer = mQuestionsHtml.getCorrectAnswer(num);
                }else if(niveau.equals("niveau3")){
                    question.setText(mQuestionsHtml.getQuestion(num));
                    answer1.setText(mQuestionsHtml.getChoice1(num));
                    answer2.setText(mQuestionsHtml.getChoice2(num));
                    answer3.setText(mQuestionsHtml.getChoice3(num));
                    answer4.setText(mQuestionsHtml.getChoice4(num));
                    mAnswer = mQuestionsHtml.getCorrectAnswer(num);
                }


            }else if(matiere.equals("PHP")){
                if (niveau.equals("niveau1")) {
                    question.setText(mQuestionsPhp.getQuestion(num));
                    answer1.setText(mQuestionsPhp.getChoice1(num));
                    answer2.setText(mQuestionsPhp.getChoice2(num));
                    answer3.setText(mQuestionsPhp.getChoice3(num));
                    answer4.setText(mQuestionsPhp.getChoice4(num));
                    mAnswer = mQuestionsPhp.getCorrectAnswer(num);
                }else if(niveau.equals("niveau2")){
                    question.setText(mQuestionsPhp.getQuestion(num));
                    answer1.setText(mQuestionsPhp.getChoice1(num));
                    answer2.setText(mQuestionsPhp.getChoice2(num));
                    answer3.setText(mQuestionsPhp.getChoice3(num));
                    answer4.setText(mQuestionsPhp.getChoice4(num));
                    mAnswer = mQuestionsPhp.getCorrectAnswer(num);
                }else if(niveau.equals("niveau3")){
                    question.setText(mQuestionsPhp.getQuestion(num));
                    answer1.setText(mQuestionsPhp.getChoice1(num));
                    answer2.setText(mQuestionsPhp.getChoice2(num));
                    answer3.setText(mQuestionsPhp.getChoice3(num));
                    answer4.setText(mQuestionsPhp.getChoice4(num));
                    mAnswer = mQuestionsPhp.getCorrectAnswer(num);
                }
            }
        }

    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quizz_Menu.this);
        alertDialogBuilder.
                setMessage("game Over! Your score is "+mScore+" points.").
                setCancelable(false)
                .setPositiveButton("News Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(),Quizz_Menu.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("cours", matiere);
                        bundle.putString("niveau", niveau);
                        intent.putExtras(bundle);
                        startActivity(intent);

                        finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity (new Intent (getApplicationContext (),Quizz_Detail.class));
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        enregistrerScore();
        storiesProgressView.destroy();
    }

    public void enregistrerScore(){
//        Cours cours = new Cours (2,"java");
        Quizz quizz = null;
        if(matiere.equals("JAVA")){
            List<Cours> cours = dataBaseManager.getCours(matiere);
            quizz = new Quizz (mScore,getTime(),niveau,cours.get(0));
            if( mScore == 5 && niveau.equals ("niveau1")){
                sharedPreference.saveBooleanJava (this,true);
            }
            else if( mScore == 5 && niveau.equals ("niveau2")){
                sharedPreference.saveBooleanJava1 (this,true);
            }
        }else if(matiere.equals("JavaScript")){
            List<Cours> cours = dataBaseManager.getCours(matiere);
            quizz = new Quizz (mScore,getTime(),niveau,cours.get(0));
            if( mScore == 5 && niveau.equals ("niveau1")){
                sharedPreference.saveBooleanJS (this,true);
            }
            else if( mScore == 5 && niveau.equals ("niveau2")){
                sharedPreference.saveBooleanJS1 (this,true);
            }
        }else if(matiere.equals("Cpp")){
            List<Cours> cours = dataBaseManager.getCours(matiere);
            quizz = new Quizz (mScore,getTime(),niveau,cours.get(0));
            if( mScore == 5 && niveau.equals ("niveau1")){
                sharedPreference.saveBooleanCPP(this,true);
            }
            else if( mScore == 5 && niveau.equals ("niveau2")){
                sharedPreference.saveBooleanCPP1(this,true);
            }
        }else if(matiere.equals("C")){
            List<Cours> cours = dataBaseManager.getCours(matiere);
            quizz = new Quizz (mScore,getTime(),niveau,cours.get(0));
            if( mScore == 5 && niveau.equals ("niveau1")){
                sharedPreference.saveBooleanC (this,true);
            }
            else if( mScore == 5 && niveau.equals ("niveau2")){
                sharedPreference.saveBooleanC1 (this,true);
            }
        }else if(matiere.equals("HTML")){
            List<Cours> cours = dataBaseManager.getCours(matiere);
            quizz = new Quizz (mScore,getTime(),niveau,cours.get(0));

            if( mScore == 5 && niveau.equals ("niveau1")){
                sharedPreference.saveBooleanHTML (this,true);
            }
            else if( mScore == 5 && niveau.equals ("niveau2")){
                sharedPreference.saveBooleanHTML1 (this,true);
            }

        }else if(matiere.equals("PHP")){
            List<Cours> cours = dataBaseManager.getCours(matiere);
            quizz = new Quizz (mScore,getTime(),niveau,cours.get(0));

            if( mScore == 5 && niveau.equals ("niveau1")){
                sharedPreference.saveBooleanPHP(this,true);
            }
            else if( mScore == 5 && niveau.equals ("niveau2")){
                sharedPreference.saveBooleanPHP1(this,true);
            }

        }

        dataBaseManager.insertQuizz(quizz);

        List<Quizz> moduleList = dataBaseManager.readQuizze ();
        for(Quizz m : moduleList){
            Log.i("Statistiques",m.toString());
        }
    }

    public void barreDeProgression(){
        storiesProgressView = (StoriesProgressView) findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(3);
        storiesProgressView.setStoryDuration(24000L);
        storiesProgressView.setStoriesListener(new StoriesProgressView.StoriesListener() {
            @Override
            public void onNext() {

            }
            @Override
            public void onComplete() {
                gameOver();
            }
        });
        storiesProgressView.startStories();
    }
    public String getTime(){
        int day = new Date().getDay();
        int month = new Date().getMonth()+1;
        int year = new Date().getYear()+1900;

        int hours = new Date().getHours();
        int minutes = new Date().getMinutes();
        int seconds = new Date().getSeconds();

        return ""+day+"/"+month+"/"+year+"  "+hours+":"+minutes+":"+seconds;
    }

    @Override
    protected void onDestroy() {
        storiesProgressView.destroy();
        super.onDestroy();
    }
    public void enableDisablempC(){
        if(sound) {
            mpC.start();
        }else{
            mpC.stop();
        }
    }
    public void enableDisablempF(){
        if(sound) {
            mpF.start();
        }else{
            mpF.stop();
        }
    }
}
