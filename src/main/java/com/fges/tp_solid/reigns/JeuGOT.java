package com.fges.tp_solid.reigns;

public class JeuGOT {
    protected boolean jeuGOTon;
    protected boolean hiver;

    public JeuGOT(Boolean on) {
        this.jeuGOTon = on;
        this.hiver = on;
    }

    public void affichageHiver(int tour){
        if(jeuGOTon){
            if (tour % 10 == 0) {
                this.hiver = true;
                System.out.println("L'hiver arrive");
            }
            if (tour % 11 == 0 || tour % 12 == 0 || tour % 13 == 0 || tour % 14 == 0 || tour % 15 == 0) {
                System.out.println("L'hiver est là");
            }
            if (tour % 16 == 0) {
                this.hiver = false;
                System.out.println("L'hiver est parti");
            }
        }
    }
    
}
