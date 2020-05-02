/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Warren Schneerberger
 */
public class EvenementsController {
    public static boolean insert(String intitule,String theme,String date_debut,String duree,String description,String organisateur,String type_event){
        Modele.EvenementModel event = new Modele.EvenementModel();
        return event.insert(intitule, theme, date_debut, duree, description, organisateur, type_event);
    }
}
