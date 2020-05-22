package sn.project.android.coderlefutur.quizz;

public class Questions_C {

    public String mQuestions[]= {
            "Dans ce langage, tout part d'une seule fonction. Laquelle ?",
            "Que fera l'instruction suivante : printf (\"Bonjour ! \") ?",
            "Il existe 5 variables principales dans ce langage. Lesquelles ?",
            "Grâce à la SDL, une bibliothèque, quels genres de programmes peut-on établir ?",
            "Il existe 3 boucles. Lesquelles ?",

            //Niveau 2
            "Qu'est ce qu'un IDE ?",
            "Qui a développé le langage C ?",
            "Lesquelles de ces définitions de fonctions sont correctes si elles sont sensées calculer « x » élevé à la puissance « N » entière. ?",
            "Où sont déclarées les variables locales ?",
            "Quelles sont les manières correctes pour passer le tableau « tab » en paramètre ?",
            // Niveau 3

            "Le processus de suppression d'un bogue s'appelle",
            "main( ) \n" +
                    "{ \n" +
                    "   float a; int x = 6; \n" +
                    "   y = 4; a = x/y; \n" +
                    "  print (“%f”,a) \n" +
                    "}",
            "Quelle fonction retourne un seul caractère",
            "Le nombre minimum de fois que la boucle for est exécutée est",
            "La variable globale peut être déclarée"
    };
    private String mChoices[][]= {
            {"La fonction main()",
                    "La fonction first()",
                    "La fonction principale()",
                    "Pas de réponse"},
            {"Elle affichera 'Bonjour ! ' en différentes polices.",
                    "Elle affichera 'Bonjour ! '",
                    "Elle ne fera rien.","Pas de réponse",
                    "Pas de réponse"},
            {"Char, int, double, float et long.",
                    "If, else, switch, signed et main.",
                    "While, do, for, do. . while et if... else",
                    "Pas de réponse"},
            {"Des programmes ' console '",
                    "Des programmes ' fenêtre '",
                    "Les deux.",
                    "Aucun des deux."},
            {"Do. . while, do et for.",
                    "If. . else, else, switch",
                    "Var, char, for",
                    "Pas de réponse"},

            // Niveau 2
            {"Un environnement de développement",
                    "Une fonction",
                    "Une condition",
                    "Pas de réponse"},
            {"Dennis Ritchie, seul",
                    "Dennis Ritchie & Bell Labs",
                    "Bell Labs, seul",
                    "Aucun d'eux"},
            {"float puissance (float X , int N)",
                    "puissance (float X ; int N )",
                    "puissance (float x , int N) float",
                    "void puissance (float X , int N )"},
            {"En début du programme principal.",
                    "Au début de chaque fonction où elles interviennent.",
                    "Elles sont passées en paramètres dans l'énoncé de la fonction.",
                    "Pas de réponse"},
            {"void proc(int *tab)",
                    "void proc(int tab[])",
                    "void proc(int &tab)",
                    "Pas de réponse"},

            //Niveau 3
            {"Une débogage",
                    "Compilation",
                    "L'exécution",
                    "Pas de réponse"},
            {"Error",
                    "1.5",
                    "0.5",
                    "1.00"},
            {"Printf",
                    "Putchar",
                    "Scanf",
                    "Getchar"},
            {"0",
                    "Ne peut être prédit",
                    "1",
                    "2"},
            {"After main",
                    "After block",
                    "Before main",
                    "Within block"},
    };

    private String mCorrectAnswers[] = {
            "La fonction main()",
            "Elle affichera 'Bonjour ! '",
            "Char, int, double, float et long.",
            "Des programmes ' fenêtre '",
            "Do. . while, do et for.",

            //Niveau 2
            "Un environnement de développement",
            "Dennis Ritchie & Bell Labs",
            "float puissance (float X , int N)",
            "Au début de chaque fonction où elles interviennent.",
            "void proc(int tab[])",

            //Niveau 3
            "Une débogage",
            "Error",
            "Getchar",
            "0",
            "After main"
             };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
