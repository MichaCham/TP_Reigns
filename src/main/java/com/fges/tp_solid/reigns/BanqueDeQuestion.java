package com.fges.tp_solid.reigns;

import java.util.ArrayList;
import java.util.Map;

public class BanqueDeQuestion {
    ArrayList<Question> banqueDeQuestions;
    Personnage personnage;
    
    public BanqueDeQuestion(Map<TypeJauge,Jauge> ma_listeJauges, Personnage personnage){
        this.personnage = personnage;
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

        Question question6 = new Question(
                    "Main du Roi",
                    "Les caisses sont vides...",
                    "Augmenter les taxes",
                    "Emprunter",
                    ma_listeJauges);
        question6.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.FINANCE, +10));
        question6.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.PEUPLE, -5));
        question6.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.FINANCE, +1));
        question6.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.PEUPLE, -3));
        question6.conditions.add(new Condition(TypeJauge.FINANCE, "<", 10));
        banqueDeQuestions.add(question6);
        Question question7 = new Question(
                    "Prêtre",
                    "J'aimerai qu'on nous considère en tant que tel",
                    "Construire un monastère",
                    "Ecouter sans rien faire",
                    ma_listeJauges);
        question7.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.FINANCE, +10));
        question7.effets.ajouterEffetJaugeGauche(new Effet(TypeJauge.PEUPLE, -5));
        question7.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.FINANCE, +1));
        question7.effets.ajouterEffetJaugeDroite(new Effet(TypeJauge.PEUPLE, -3));
        question7.conditions.add(new Condition(TypeJauge.CLERGE, "<", 10));
        question7.conditions.add(new Condition(TypeJauge.FINANCE, ">", 30));
        banqueDeQuestions.add(question7);


    }

    public ArrayList<Question> getBanqueDeQuestions() {
        return banqueDeQuestions;
    }

    public void setBanqueDeQuestions(ArrayList<Question> banqueDeQuestions) {
        this.banqueDeQuestions = banqueDeQuestions;
    }

    public Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()* this.banqueDeQuestions.size());
        boolean boolCondition = false;
        if(this.banqueDeQuestions.get(numQuestion).conditions.size() >= 1){
            for (Condition condition : this.banqueDeQuestions.get(numQuestion).conditions) {
                boolCondition = condition.verifCondition(this.personnage.getJauge().get(condition.getTypeJauge()));

                if(boolCondition == false){
                    return getQuestionAleatoire();
                }
            }
        }
        return this.banqueDeQuestions.get(numQuestion);
    }


}
