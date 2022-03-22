package com.fges.tp_solid.reigns;

import java.util.ArrayList;
import java.util.Map;


public class LesEffets {
    protected ArrayList<Effet> effetJaugeGauche;
    protected ArrayList<Effet> effetJaugeDroite;
    protected String effetGauche;
    protected String effetDroite;
    protected Map<TypeJauge,Jauge> jauges;

    public LesEffets(String effetGauche, String effetDroite, Map<TypeJauge,Jauge> jauge){
        this.effetJaugeGauche = new ArrayList<Effet>();
        this.effetJaugeDroite = new ArrayList<Effet>();
        this.jauges = jauge;
        this.effetDroite = effetDroite;
        this.effetGauche = effetGauche;


    }

    public void ajouterEffetJaugeGauche(Effet e){
        this.effetJaugeGauche.add(e);
    }

    public void ajouterEffetJaugeDroite(Effet e){
        this.effetJaugeDroite.add(e);
    }

    public void appliquerLesEffets(String select){
        if(select.equals("D")){
            System.out.println("D");
            appliquerEffetDroite();
        }else{
            System.out.println("G");
            appliquerEffetGauche();
        }
    }

    private void appliquerEffetGauche(){
        System.out.println("GAUCHE");
        System.out.println(this.effetJaugeGauche);
        for (Effet effet : this.effetJaugeGauche) {
            switch (effet.getLaJauge()) {
                case ARMEE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.ARMEE));     
                    break;
                case CLERGE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.CLERGE));
                    break;
                case FINANCE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.FINANCE));
                    break;
                case PEUPLE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.PEUPLE));
                    break;
            }
        }
    }

    private void appliquerEffetDroite(){
        System.out.println("DROITE");
        System.out.println(this.effetJaugeDroite);
        for (Effet effet : this.effetJaugeDroite) {
            switch (effet.getLaJauge()) {
                case ARMEE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.ARMEE));     
                    break;
                case CLERGE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.CLERGE));
                    break;
                case FINANCE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.FINANCE));
                    break;
                case PEUPLE:
                    effet.appliquerEffet(this.jauges.get(TypeJauge.PEUPLE));
                    break;
            }
        }
    }

    public void afficherEffets(){
        System.out.println("[G: "+ this.effetGauche+",D: "+ this.effetDroite + "]");
        afficherEffetsGauche();
        afficherEffetsDroite();
        
    }

    public void afficherEffetsGauche(){
        System.out.println("Effet G:");
        for (Effet effet : this.effetJaugeGauche) {
            effet.afficheEffets();
        }
    }

    public void afficherEffetsDroite(){
        System.out.println("Effet D:");
        for (Effet effet : this.effetJaugeDroite) {
            effet.afficheEffets();
        }
    }
    

    public ArrayList<Effet> getEffetJaugeGauche(){
        return this.effetJaugeGauche;
    }

    public ArrayList<Effet> getEffetJaugeDroite(){
        return this.effetJaugeDroite;
    }

    public String getEffetDroite(){
        return this.effetDroite;
    }

    public String getEffetGauche(){
        return this.effetGauche;
    }

    public void setEffetJaugeDroite(ArrayList<Effet> droite){
        this.effetJaugeDroite = droite;
    }

    public void getEffetJaugeGauche(ArrayList<Effet> gauche){
        this.effetJaugeGauche = gauche;
    }

    public void setEffetDroite(String droite){
        this.effetDroite = droite;
    }

    public void setEffetGauche(String gauche){
        this.effetGauche = gauche;
    }
}
