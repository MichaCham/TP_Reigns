package com.fges.tp_solid.reigns;

public class Effet {
    private TypeJauge laJauge;
    private int leNombre;

    public Effet(TypeJauge jauge, int nombre){
        this.laJauge = jauge;
        this.leNombre = nombre;
    }

    public void appliquerEffet(Jauge jauge){
        jauge.setValeur(jauge.valeur + this.leNombre);
    }

    public void afficheEffets(){
        System.out.println( " jauge" + this.laJauge + " : " + this.leNombre + ";");
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
