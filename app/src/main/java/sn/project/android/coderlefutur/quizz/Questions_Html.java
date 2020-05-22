package sn.project.android.coderlefutur.quizz;

public class Questions_Html {

    public String mQuestions[]= {
            "Que signifie HTML?",
            "Qui fait les standards Web?",
            "Choisissez l’élément HTML correct pour la plus grande en-tête:",
            "Quel est l'élément HTML correct pour insérer un saut de ligne?",
            "Quel est le code HTML correct pour l'ajout d'une couleur d'arrière-plan?",

            //Niveau 2
            "Choisissez le bon élément HTML pour définir le texte important",
            "Choisissez le bon élément HTML pour définir le texte souligné",
            "Quel est le code HTML correct pour créer un lien hypertexte?",
            "Quel caractère est utilisé pour indiquer une balise de fin?",
            "Comment pouvez-vous ouvrir un lien dans une nouvelle fenêtre d'onglet / navigateur?",

            // Niveau 3
            "Lesquels de ces éléments sont tous des éléments <table>?",
            "Comment pouvez-vous faire une liste numérotée?",
            "Quel est le code HTML correct pour créer une case à cocher?",
            "Quel est le code HTML correct pour créer un champ de saisie de texte?",
            "Quel est le code HTML correct pour créer une liste déroulante?"
    };
    private String mChoices[][]= {
            {"Hyper Text Markup Language",
                    "Hyperlinks and Text Markup Language",
                    "Home Tool Markup Language",
                    "Pas de bonne reponse"},
            {"Google",
                    "Le World Wide Web Consortium",
                    "Microsoft",
                    "Mozilla"},
            {"<head>",
                    "<heading>",
                    "<h6>",
                    "<h1>"},
            {"<lb>",
                    "<break>",
                    "<br>",
                    "<\\n>"},
            {"<body bg=\"yellow\">",
                    "<body style=\"background-color:yellow;\">",
                    "<background>yellow</background>",
                    "<background style=\"background-color\">yellow</background>"},

            // Niveau 2
            {"<i>",
                    "<strong>",
                    "<b>",
                    "<important>"},
            {"<i>",
                    "<u>",
                    "<italic>",
                    "<em>"},
            {"<a href=\"http://www.w3schools.com\">W3Schools</a>",
                    "<a name=\"http://www.w3schools.com\">W3Schools.com</a>",
                    "<a url=\"http://www.w3schools.com\">W3Schools.com</a>",
                    "<a>http://www.w3schools.com</a>"},
            {"/",
                    "^",
                    "<",
                    "*"},

            {"<a href=\"url\" new>",
                    "<a href=\"url\" target=\"_blank\">",
                    "<a href=\"url\" target=\"new\">",
                    "<a href=\"_blank\" target=\"new\">"},

            //Niveau 3
            {"<table><tr><tt>",
                    "<table><head><tfoot>",
                    "<thead><body><tr>",
                    "<table><tr><td>"},
            {"<ol>",
                    "<ul>",
                    "<list>",
                    "<dl>"},
            {"<input type=\"checkbox\">",
                    "<input type=\"check\">",
                    "<check>",
                    "<checkbox>"},
            {"<textfield>",
                    "<textinput type=\"text\">",
                    "<input type=\"text\">",
                    "<input type=\"textfield\">"},
            {"<select>",
                    "<input type=\"dropdown\">",
                    "<list>",
                    "<input type=\"list\">"},
    };

    private String mCorrectAnswers[] = {
            "Hyper Text Markup Language",
            "Le World Wide Web Consortium",
            "<head>",
            "<br>",
            "<body style=\"background-color:yellow;\">",

            //Niveau 2
            "<strong>",
            "<em>",
            "<a href=\"http://www.w3schools.com\">W3Schools</a>",
            "/",
            "<a href=\"url\" target=\"_blank\">",

            //Niveau 3
            "<table><tr><td>",
            "<ol>",
            "<input type=\"checkbox\">",
            "<input type=\"text\">",
            "<input type=\"dropdown\">"
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
