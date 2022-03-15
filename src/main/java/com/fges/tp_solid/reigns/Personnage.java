/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author julie.jacques
 */
public class Personnage {
    
    protected String nom;
    protected Genre genre;
    protected Map<String,Jauge> listeJauge;
    
    public Personnage(String nom, Genre genre, Map<String,Jauge>  mes_Jauges){
        this.nom = nom;
        this.genre = genre;
        this.listeJauge = mes_Jauges;
    }
    
    /**
     * Affiche les jauges dans la console
     */
    public void AfficheJauges(){
        for (Map.Entry<String,Jauge> jauge : listeJauge.entrySet()) {
            afficheJauge(jauge.getValue());
        }
        System.out.flush();
    }
    
    /**
     * Le jeu s'arrête si une des jauges atteint 0 ou 50
     * @return 
     */
    public boolean finDuJeu(){
        for (Map.Entry<String,Jauge> jauge : listeJauge.entrySet()) {
            if(jauge.getValue().getValeur()<= 0 || jauge.getValue().getValeur() >=50){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Affiche une jauge dans la console (
     */
    private void afficheJauge(Jauge jauge){
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setJauge(Map<String,Jauge> jauge){
        this.listeJauge = jauge;
    }

    public Map<String,Jauge> getJauge(){
        return this.listeJauge;
    }
    
}
