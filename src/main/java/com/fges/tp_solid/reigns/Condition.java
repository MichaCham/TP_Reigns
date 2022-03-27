package com.fges.tp_solid.reigns;

public class Condition {
    public TypeJauge typeJauge;
    public String operateur;
    public int nombre;

    public Condition(TypeJauge typeJauge, String operateur, int nombre) {
        this.typeJauge = typeJauge;
        this.operateur = operateur;
        this.nombre = nombre;
    }
    
    public boolean verifCondition(Jauge jauge){
        if(this.operateur.equals(">")){
            return jauge.valeur >= this.nombre;
        }
        if(this.operateur.equals("<")){
            return jauge.valeur <= this.nombre;
        }
        return false;
    }

    public TypeJauge getTypeJauge(){
        return this.typeJauge;
    }

    public String getOperateur(){
        return this.operateur;
    }

    public int getNombre(){
        return this.nombre;
    }

    public void setTypeJauge(TypeJauge jauge){
        this.typeJauge = jauge;
    }

    public void setOpearteur(String operateur){
        this.operateur = operateur;
    }

    public void setNombre(int nombre){
        this.nombre = nombre;
    }
}
