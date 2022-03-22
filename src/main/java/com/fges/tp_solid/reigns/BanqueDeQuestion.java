package com.fges.tp_solid.reigns;

import java.util.ArrayList;
import java.util.Map;

public class BanqueDeQuestion {
    ArrayList<Question> banqueDeQuestions;
    
    public BanqueDeQuestion(Map<TypeJauge,Jauge> ma_listeJauges){
        banqueDeQuestions = new ArrayList<>();
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non",
                ma_listeJauges);
        question1.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.PEUPLE, -7));
        question1.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.ARMEE, -5));
        question1.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.PEUPLE, +5));
        banqueDeQuestions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire",
                ma_listeJauges);
        question2.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.FINANCE,-5));
        question2.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.PEUPLE, +5));
        question2.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.PEUPLE, -5));
        banqueDeQuestions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire",
                ma_listeJauges);
        question3.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.CLERGE, +5));
        question3.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.PEUPLE, -3));
        question3.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.CLERGE, -5));
        banqueDeQuestions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre",
                ma_listeJauges);
        question4.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.ARMEE, +3));
        question4.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.FINANCE, -3));
        question4.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.CLERGE, -3));
        question4.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.PEUPLE, +3));
        banqueDeQuestions.add(question4);
        Question question5 = new Question(
                    "Paysan",
                    "Abondance de récoltes cette année",
                    "Taxer énormément",
                    "Taxer un tout petit peu",
                    ma_listeJauges);
        question5.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.FINANCE, +10));
        question5.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.PEUPLE, -5));
        question5.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.FINANCE, +1));
        question5.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.PEUPLE, -3));
        banqueDeQuestions.add(question5);
    }

    public ArrayList<Question> getBanqueDeQuestions() {
        return banqueDeQuestions;
    }

    public void setBanqueDeQuestions(ArrayList<Question> banqueDeQuestions) {
        this.banqueDeQuestions = banqueDeQuestions;
    }


}
