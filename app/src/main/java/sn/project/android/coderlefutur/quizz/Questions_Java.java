package sn.project.android.coderlefutur.quizz;

public class Questions_Java {

    public String mQuestions[]= {
            "Que se passe-t-il lorsque la méthode sleep () de thread est appelée?",
            "La surcharge de méthode est un exemple de",
            "Qu'est-ce qu'une interface?",
            "Quel mot-clé doit-on utiliser pour instancier un objet ?",
            "Avec quel mot-clé peut-on restreindre l’étendue d’une variable, d’une méthode ou d’une classe ?",

            // niveau 2
            "Quel mot-clé permet de créer une variable de classe ?",
            "Qu'est-ce qui permet de retirer des éléments d'une collection?",
            "int Output = 10;\n" +
                    "boolean b1 = false;\n" +
                    "if((b1 == true) && ((Output += 10) == 20))\n" +
                    "{\n" +
                    "    System.out.println(\"Nous sommes égaux à \" + Output);\n" +
                    "}\n" +
                    "else\n" +
                    "{\n" +
                    "    System.out.println(\"Pas égal à \" + Output);\n" +
                    "}",
            "Comment indiquer qu'une classe A hérite d'une classe B ?",
            "public class Test\\n\" +\n" +
                    "                    \"{\\n\" +\n" +
                    "                    \"    public void method()\\n\" +\n" +
                    "                    \"    {\\n\" +\n" +
                    "                    \"        for(int i = 0; i < 3; i++)\\n\" +\n" +
                    "                    \"        {\\n\" +\n" +
                    "                    \"            System.out.print(i);\\n\" +\n" +
                    "                    \"        }\\n\" +\n" +
                    "                    \"        System.out.print(i);\\n\" +\n" +
                    "                    \"    }\\n\" +\n" +
                    "                    \"}",

            // Niveau 3
            "String s1 = new String(\"Test\");\n" +
                    "String s2 = new String(\"Test\");\n" +
                    "if (s1==s2)\n" +
                    "    System.out.println(\"Même\");\n" +
                    "if (s1.equals(s2))\n" +
                    "    System.out.println(\"Egale\");",
            "Peut-on utiliser plusieurs blocs catch après un bloc try ?",

            "Dans quelle situation utilise t-on la séquence : try-catch-finally ?",
            "import static java.lang.System.*; \n" +
                    "class StaticImportDemo \n" +
                    "{ \n" +
                    "   public static void main(String args[]) \n" +
                    "   {       \n" +
                    "        out.println(\"GeeksforGeeks\"); \n" +
                    "   } \n" +
                    "} ",
            "public class Ternary\n" +
                    "{\n" +
                    "    public static void main(String args[])\n" +
                    "    {\n" +
                    "        int a = 5;\n" +
                    "        System.out.println(\"Value est - \" + ((a < 5) ? 9.9 : 9));\n" +
                    "    }\n" +
                    "}"

    };
    private String mChoices[][]= {
            {"Le fil retourne à l'état prêt.","Le fil retourne à l'état d'attente.",
                    "Le thread commence à fonctionner.","Pas de réponse"},
            {"Reliure statique.","Reliure dynamique.",
                    "Les deux.","Aucune de ces réponses."},
            {"Une interface est un ensemble de méthodes abstraites.","Interface est une classe abstraite.",
                    "Interface est une classe concrète.","Aucune de ces réponses"},
            {"new","this","public","class"},
            {"public","void","private","this"},

            //Niveau 2
            {"class","public","static","this"},
            {"Enumeration","Iterator","les deux","one"},
            {" Erreur de compilation.","Compilation et sortie de \"Nous sommes égaux à 10\".",
                    "Compilation et sortie de \"Pas égal à 20\".","Compilation et sortie de \"Pas égal à 10\"."},
            {"Class A ::B","Class A extends B","Class A implements B","Class A inherit B"},
            {"0122","0123","Erreur de compilation","Pas de réponse"},

            //niveau 3
            {"Même","Egale", "Le code ne parvient pas à compiler","Pas de réponse"},
            {"Vrai","Faux","Dans certains cas","Jamais"},
            {"Pour traiter les exceptions",
                    "Pour sortir du programme",
                    "Pour déboguer le code",
                    "Pas de réponse"},
            {"Erreur du compilateur","Erreur d'exécution","GeeksforGeeks","Pas de réponse"},
            {"valeur est - 7","valeur est - 5","Erreur de compilation","Pas de réponse"}
    };

    private String mCorrectAnswers[] = {"Le fil retourne à l'état d'attente.",
            "Reliure statique.",
            "Interface est une classe concrète.",
            "new",
            "private",

            //Niveau 2
            "static",
            "Iterator",
            "Compilation et sortie de \"Pas égal à 10\".",
            "Class A extends B",
            "Erreur de compilation",

            //Niveau 3
            "Egale",
            "Vrai",
            "Pour traiter les exceptions",
            "GeeksforGeeks",
            "Pas de réponse"
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
