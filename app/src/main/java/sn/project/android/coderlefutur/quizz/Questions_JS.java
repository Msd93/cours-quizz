package sn.project.android.coderlefutur.quizz;

public class Questions_JS {
    public String mQuestions[]= {
            "Dans quel élément HTML plaçons-nous le JavaScript?",
            "Quelle est la syntaxe JavaScript correcte pour modifier le contenu de l'élément HTML ci-dessous? \n" +
                    "    <p id = \"demo\"> Ceci est une démonstration. </p>",
            "Où est le bon endroit pour insérer un JavaScript?",
            "Quelle est la syntaxe correcte pour faire référence à un script externe appelé \"xxx.js\"?",
            "Comment écrivez-vous \"Hello World\" dans une boîte d’alerte?",

            //Niveau 2
            "Comment créez-vous une fonction en JavaScript?",
            "Comment appelez-vous une fonction nommée \"myFunction\"?",
            "Comment écrire une déclaration IF en JavaScript?",
            "Comment écrire une instruction IF pour exécuter du code si \"i\" n'est PAS égal à 5?",
            "Comment une boucle WHILE commence-t-elle?",
            // Niveau 3

            "Comment une boucle FOR démarre-t-elle?",
            "Comment pouvez-vous ajouter un commentaire dans un JavaScript?",
            "Comment insérer un commentaire qui a plus d'une ligne?",
            "Quelle est la bonne façon d'écrire un tableau JavaScript?",
            "Comment arrondis-tu le nombre 7.25 au nombre entier le plus proche?"
    };
    private String mChoices[][]= {
            {"<script>",
                    "<javascript>",
                    "<scripting>",
                    "<js>"},
            {"document.getElementByName(\"p\").innerHTML = \"Hello World!\";",
                    "document.getElementById(\"demo\").innerHTML = \"Hello World!\";",
                    "document.getElement(\"p\").innerHTML = \"Hello World!\";",
                    "#demo.innerHTML = \"Hello World!\";"},
            {"La section <head> et la section <body> sont correctes",
                    "La section <body>",
                    "La section <head>",
                    "La section <footer>"},
            {"<script href=\"xxx.js\">",
                    "<script name=\"xxx.js\">",
                    "<script src=\"xxx.js\">",
                    "<script include=\"xxx.js\">"},
            {"msg(\"Hello World\");",
                    "alertBox(\"Hello World\");",
                    "msgBox(\"Hello World\");",
                    "alert(\"Hello World\");"},

            // Niveau 2
            {"function myFunction()",
                    "function:myFunction()",
                    "function = myFunction()",
                    "Var myFunction()"},
            {"myFunction()",
                    "call function myFunction()",
                    "call myFunction()",
                    "Pas de bonne response"},
            {"if (i == 5)",
                    "if i = 5 then",
                    "if i = 5",
                    "if i == 5 then"},
            {"if (i != 5)",
                    "if i <> 5",
                    "if i =! 5 then",
                    "if (i <> 5)"},
            {"while (i <= 10; i++)",
                    "while i = 1 to 10",
                    "while (i <= 10)",
                    "Pas de bonne response"},

            //Niveau 3
            {"for (i = 0; i <= 5; i++)",
                    "for i = 1 to 5",
                    "for (i <= 5; i++)",
                    "for (i = 0; i <= 5)"},
            {"<!--This is a comment-->",
                    "'This is a comment",
                    "//This is a comment",
                    "This is a comment"},
            {"<!--This comment -->",
                    "//This comment //",
                    "/*This comment */",
                    "# This comment #"},
            {"var colors = 1 = (\"red\"), 2 = (\"green\"), 3 = (\"blue\")",
                    "var colors = \"red\", \"green\", \"blue\"",
                    "var colors = (1:\"red\", 2:\"green\", 3:\"blue\")",
                    "var colors = [\"red\", \"green\", \"blue\"]"},
            {"round(7.25)",
                    "Math.round(7.25)",
                    "Math.rnd(7.25)",
                    "rnd(7.25)"},
    };

    private String mCorrectAnswers[] = {
            "<script>",
            "document.getElementById(\"demo\").innerHTML = \"Hello World!\";",
            "La section <head>",
            "<script src=\"xxx.js\">",
            "alert(\"Hello World\");",

            //Niveau 2
            "function myFunction()",
            "myFunction()",
            "if (i == 5)",
            "if (i != 5)",
            "while (i <= 10)",

            //Niveau 3
            "for (i = 0; i <= 5; i++)",
            "//This is a comment",
            "/*This comment */",
            "var colors = [\"red\", \"green\", \"blue\"]",
            "Math.round(7.25)"
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
