/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

import static com.fges.tp_solid.reigns.Genre.REINE;
import static com.fges.tp_solid.reigns.Genre.ROI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author julie.jacques
 */
public class Jeu {
    
    private static Personnage personnage;
    private static BanqueDeQuestion questions;
    private static Map<TypeJauge,Jauge> ma_listeJauges;
    private static JeuGOT jeuGOT;
    
    public static void main(String args[]){
        
        // début du jeu 
        System.out.println("Bienvenue sur Reigns"); 
               
        System.out.println("Création du personnage...");
        initGoat();
        initPersonnage();
        initBanqueQuestions();
        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());
        
        personnage.AfficheJauges();
        
        // tirage des questions
        int nbTours = 0;
        while(!personnage.finDuJeu()){
            nbTours++;
            jeuGOT.affichageHiver(nbTours);
            Question question = questions.getQuestionAleatoire();
            reponseQuestion(question);
            personnage.AfficheJauges();
        }
        
        // fin du jeu
        System.out.println(
            personnage.getNom() 
            + " a perdu ! Son règne a duré "
            +nbTours
            + " tours");
         
    }
    
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        question.effets.appliquerLesEffets(reponse);
    }
    
    
    private static void initPersonnage(){        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
            "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine; 
        if(genre==1){
            roiReine = ROI;
        }else{
            roiReine = REINE;
        }
        
        // initialisation des jauges entre 15 et 35 points
        ma_listeJauges = new HashMap<TypeJauge,Jauge>();
        Jauge jaugeClerge = new Jauge("Clergé",(int) (15 + Math.random() * ( 35 - 15 )));
        ma_listeJauges.put(TypeJauge.CLERGE, jaugeClerge);
        Jauge jaugePeuple = new Jauge("Peuple",(int) (15 + Math.random() * ( 35 - 15 )));
        ma_listeJauges.put(TypeJauge.PEUPLE,jaugePeuple);
        Jauge jaugeArmee = new Jauge("Armée",(int) (15 + Math.random() * ( 35 - 15 )));
        ma_listeJauges.put(TypeJauge.ARMEE,jaugeArmee);
        Jauge jaugeFinance = new Jauge("Finance",(int) (15 + Math.random() * ( 35 - 15 )));
        ma_listeJauges.put(TypeJauge.FINANCE,jaugeFinance);
        System.out.println(ma_listeJauges);
        Jeu.personnage = new Personnage(nom,roiReine, ma_listeJauges);

    }
    
    private static void initBanqueQuestions(){
        questions = new BanqueDeQuestion(ma_listeJauges, personnage, jeuGOT.hiver);
    }

    private static void initGoat(){
        System.out.println("Voulez-vous jouer à la version GOT");
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("1") && !reponse.equals("2")){
            System.out.println("1 - OUI, 2- NON");
            System.out.flush();
            reponse = scanner.nextLine();
        }

        if(reponse.equals("1")){
            jeuGOT = new JeuGOT(true);
        }
        else{
            jeuGOT = new JeuGOT(false);
        }
    }
    
    
}
