package sn.project.android.coderlefutur.quizz;

public class Questions_Php {

    public String mQuestions[]= {
            "Que signifie PHP?",
            "Les scripts de serveur PHP sont entourés de délimiteurs, lesquels?",
            "Comment écrivez-vous \"Hello World\" en PHP",
            "Toutes les variables en PHP commencent par quel symbole?",
            "Quelle est la bonne façon de mettre fin à une déclaration PHP?",

            //Niveau 2
            "La syntaxe PHP ressemble le plus à:",
            "Comment obtenez-vous des informations à partir d'un formulaire soumis à l'aide de la méthode \"get\"?",
            "Lorsque vous utilisez la méthode POST, les variables sont affichées ou:",
            "Quelle delimiteur est utilise pour les pour les chaînes:",
            "Quelle extension doit avoir Les fichiers d'inclusion ?",
            // Niveau 3

            "Quelle est la bonne façon d'inclure le fichier \"time.inc\"?",
            "Quelle est la bonne façon de créer une fonction en PHP?",
            "Comment ouvrir correctement le fichier \"time.txt\"?",
            "Quelle variable superglobal contient des informations sur les en-têtes, les chemins et les emplacements de script?",
            "Quelle est la bonne façon d’ajouter 1 à la variable $ count?"
    };
    private String mChoices[][]= {
            {"Page d'accueil privée",
                    "Processeur hypertexte personnel",
                    "PHP: préprocesseur hypertexte",
                    "Pas de bonne réponse"},
            {"<? php ...?>",
                    "<script> ... </ script>",
                    "<? php> ... </?>",
                    "<&> ... </>>"},
            {"echo \"Hello World\";",
                    "Document.Write (\"Hello World\");",
                    "\"Bonjour le monde\";",
                    "Pas de réponse"},
            {"&",
                    "$",
                    "!",
                    "#"},
            {"Nouvelle ligne",
                    "</php>",
                    ".",
                    ";"},

            // Niveau 2
            {"VBScript",
                    "JavaScript",
                    "Perl et C",
                    "Pas de réponse"},
            {"$_GET[];",
                    "Request.Form;",
                    "Request.QueryString;",
                    "$_POST[];"},
            {"au niveau du HEADER",
                    "dans l'entete HTTP",
                    "dans l'URL",
                    "au niveau du BODY"},
            {"'",
                    "*",
                    "$",
                    "#"},
            {".include",
                    ".inc",
                    ".includ",
                    "Pas de bonne réponse"},

            //Niveau 3
            {"<?php include \"time.inc\"; ?>",
                    "<?php include:\"time.inc\"; ?>",
                    "<!-- include file=\"time.inc\" -->",
                    "<?php include file=\"time.inc\"; ?>"},
            {"function myFunction()",
                    "new_function myFunction()",
                    "create myFunction()",
                    "Pas de bonne réponse"},
            {"fopen(\"time.txt\",\"r\");",
                    "open(\"time.txt\");",
                    "open(\"time.txt\",\"read\");",
                    "fopen(\"time.txt\",\"r+\");"},
            {"$_SESSION",
                    "$_GET",
                    "$_GLOBALS",
                    "$_SERVER"},
            {"$count++;",
                    "count++;",
                    "$count =+1",
                    "++count"},
    };

    private String mCorrectAnswers[] = {
            "PHP: préprocesseur hypertexte",
            "<? php ...?>",
            "echo \"Hello World\";",
            "$",
            ";",

            //Niveau 2
            "Perl et C",
            "$_GET[];",
            "dans l'entete HTTP",
            "$",
            ".include",

            //Niveau 3
            "<?php include \"time.inc\"; ?>",
            "function myFunction()",
            "fopen(\"time.txt\",\"r+\");",
            "$_GLOBALS",
            "$count++;"
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
