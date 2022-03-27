package com.fges.tp_solid.reigns;

public class Effet {
    private TypeJauge laJauge;
    private int leNombre;
    private boolean hiver;

    public Effet(TypeJauge jauge, int nombre, boolean GOT){
        this.laJauge = jauge;
        this.leNombre = nombre;
        this.hiver = GOT;
    }

    public void appliquerEffet(Jauge jauge){
        if(hiver){
            jauge.setValeur(jauge.valeur + this.leNombre*2);
        }else{
            jauge.setValeur(jauge.valeur + this.leNombre);
        }
        
    }

    public void afficheEffets(){
        if(hiver){
            System.out.println( " jauge" + this.laJauge + " : " + this.leNombre*2 + ";");
        }else{
            System.out.println( " jauge" + this.laJauge + " : " + this.leNombre + ";");
        }
        
    }

    public int getLeNombre(){
        return this.leNombre;
    }

    public void setLeNombre(int nombre){
        this.leNombre = nombre;
    }

    public TypeJauge getLaJauge(){
        return this.laJauge;
    }

    public void setLaJauge(TypeJauge jauge){
        this.laJauge = jauge;
    }
}
