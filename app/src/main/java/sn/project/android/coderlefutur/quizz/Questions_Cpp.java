package sn.project.android.coderlefutur.quizz;

public class Questions_Cpp {

    public String mQuestions[]= {
            "Comment s'appelle l'inventeur du C++ ?",
            "Comment s'appelle l'outil qui combine un éditeur de texte, un compilateur et un debugger ?",
            "Que fait ce code source ? cout << \"Hello world!\" << endl;",
            "Je souhaite mémoriser le nom de l'utilisateur dans une variable. Quel est le type le plus approprié ?",
            "Si ma variable vaut 5 et que j'écris le code suivant, combien vaudra ensuite ma variable \n variable++;",

            //Niveau 2
            "Combien vaut resultat à la fin ?\n" +
                    "   int a(20), b(10), resultat(0);\n" +
                    "   resultat = a + b;",
            "Quel sera l'effet du code suivant ?\n" +
                    "   int const hauteur(15);\n" +
                    "   hauteur++;",
            "Est-ce qu'un tableau comme celui-ci peut contenir des booléens de type bool ?",
            "Comment obtient-on l'adresse à laquelle une variable est stockée en mémoie, si cette variable est nommée prix ?",
            "#include <iostream>\n" +
                    "#include <fstream>\n" +
                    "using namespace std;\n" +
                    "int main()\n" +
                    "{\n" +
                    "   ofstream monFlux(\"C:/test.txt\");\n" +
                    "   return 0;\n" +
                    "}",
            // Niveau 3

            "void swap(int x, int y) {int t=x; x=y; y=t;cout << x << y;}\n" +
                    " void main() {int a=1, b=2; swap(a, b);cout << a << b;}",
            "Quel est le rôle principal du constructeur d'une classe ?",

            "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "main() { \n" +
                    "   float t = 2;\n" +
                    "\tswitch(t) {\n" +
                    "      case 2: cout<<”Hi”;\n" +
                    "\tdefault: cout<<\"Hello\";\n" +
                    "}}",
            "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "void f() {\n" +
                    "\tstatic int i = 3;\n" +
                    "\tcout<<i;\n" +
                    "\tif(--i) f();\n" +
                    "}\n" +
                    "main() {\tf();\t}",
            "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "void main() {\n" +
                    "   char s[] = \"C++\";\n" +
                    "\tcout<<s<<\" \";\n" +
                    "\ts++;\n" +
                    "\tcout<<s<<\" \";\n" +
                    "}"
    };
    private String mChoices[][]= {
            {"Birj Tromman",
                    "Bjarne Stroustrup",
                    "Barj Grossoup",
                    "Aucun d'eux"},
            {"Un IDE",
                    "Un IDLE",
                    "Un DSI",
                    "Un couteau suisse"},
            {"Affiche un message à l'écran",
                    "Demande à saisir du texte au clavier",
                    "Ouvre une nouvelle fenêtre",
                    "Pas de réponse"},
            {"int",
                    "bool",
                    "string",
                    "char"},
            {"4",
                    "5",
                    "6",
                    "7"},

            // Niveau 2
            {"0",
                    "10",
                    "20",
                    "30"},
            {"hauteur vaudra 16",
                    "hauteur vaudra toujours 15",
                    "Le code plantera",
                    "Pas de réponnse"},
            {"Oui",
                    "Non",
                    "Peut être",
                    "Pas de réponse"},
            {"&prix",
                    "prix",
                    "prix.address",
                    "@prix"},
            {"Ouvre le fichier pour pouvoir écrire dedans puis le ferme juste après",
                    "Ecrit 0 dans le fichier",
                    "Crée une copie du fichier test.txt",
                    "Pas de réponse"},

            //Niveau 3
            {"0",
                    "1",
                    "01",
                    "12"},
            {"Allouer la mémoire nécessaire à une instance de cette classe",
                    "Initialiser une instance de cette classe",
                    "Les deux",
                    "Pas de réponse"},
            {"Hi",
                    "HiHello",
                    "Hello",
                    "Error"},
            {"3 2 1 0",
                    "3 2 1",
                    "3 3 3",
                    "Compile error"},
            {"C++ C++",
                    "C++ ++",
                    "++ ++",
                    "Compile error"},
    };

    private String mCorrectAnswers[] = {
            "Bjarne Stroustrup",
            "Un IDE",
            "Affiche un message à l'écran",
            "string",
            "6",

            //Niveau 2
            "30",
            "Le code plantera",
            "Non",
            "&prix",
            "Ouvre le fichier pour pouvoir écrire dedans puis le ferme juste après",

            //Niveau 3
            "12",
            "Initialiser une instance de cette classe",
            "Error",
            "3 2 1",
            "Compile error"
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
