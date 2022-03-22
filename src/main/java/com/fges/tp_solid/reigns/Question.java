/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

import java.util.Map;

/**
 *
 * @author julie.jacques
 */
public class Question {
    
    // nom du perso qui pose la question
    protected String nomPersonnage;
    protected String question;
    protected LesEffets effets;
    
    public Question(String nomPersonnage, 
                    String question,
                    String effetGauche,
                    String effetDroite,
                    Map<TypeJauge,Jauge>  jauge){
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effets = new LesEffets(effetGauche, effetDroite, jauge);
    }
    
    public void afficheQuestion(){
        String result = "["+nomPersonnage+"] "
                + question;
        System.out.println(result);
        effets.afficherEffets();
        System.out.flush();
        
    }
    
    private void appliqueEffets(String select){
        this.effets.appliquerLesEffets(select);
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
}
