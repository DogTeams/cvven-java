/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Warren Schneerberger
 */
public class ParticipantsController { 

    /**
     * 
     * @param nom
     * @param prenom
     * @param email
     * @param date_naiss
     * @param organisation
     * @param observation 
     */
    public void insert(ArrayList nom,ArrayList prenom,ArrayList email,ArrayList date_naiss,ArrayList organisation,ArrayList observation){
        if(this.Verif(nom, prenom, email, date_naiss, organisation, observation)){
            for(int i = 0; i<nom.size();i++){
                Modele.ParticipantModel participant = new Modele.ParticipantModel();

                participant.insert(nom.get(i), prenom.get(i), email.get(i), date_naiss.get(i), organisation.get(i), observation.get(i));
            }
        }
    }

    /**
     * 
     * @param nom
     * @param prenom
     * @param email
     * @param date_naiss
     * @param organisation
     * @param observation
     * @return 
     */
    private boolean Verif(ArrayList nom,ArrayList prenom,ArrayList email,ArrayList date_naiss,ArrayList organisation,ArrayList observation){
        int nbNom = this.Nom(nom);
        int nbPrenom = this.Prenom(prenom);
        int nbEmail = this.Email(email);
        int nbDate_naiss = this.Date_naiss(date_naiss);
        int nbOrganisation = this.Organisation(organisation);
        int nbObservation = this.Observation(observation);
        if(this.isEgale(nbNom,nbPrenom,nbEmail,nbDate_naiss,nbOrganisation,nbObservation)){
            return true;
        }
            return false;
    }
    /**
     * 
     * @param nbNom
     * @param nbPrenom
     * @param nbEmail
     * @param nbDate_naiss
     * @param nbOrganisation
     * @param nbObservation
     * @return 
     */
    private boolean isEgale(int nbNom,int nbPrenom,int nbEmail,int nbDate_naiss,int nbOrganisation,int nbObservation){
        int res = (nbNom + nbPrenom + nbEmail + nbDate_naiss + nbOrganisation + nbObservation)/6;
        if(res==nbNom){if(res==nbPrenom){if(res==nbEmail){if(res==nbDate_naiss){if(res==nbOrganisation){if(res==nbObservation){return true;}
        else{return false;}}else{return false;}}else{return false;}}else{return false;}}else{return false;}}else{return false;}
    }
    /**
     * 
     * @param nom
     * @return 
     */
    private int Nom(ArrayList nom){
        return nom.size();
    }
    /**
     * 
     * @param prenom
     * @return 
     */
    private int Prenom(ArrayList prenom){
        return prenom.size();
    }
    /**
     * 
     * @param email
     * @return 
     */
    private int Email(ArrayList email){
        return email.size();
    }
    /**
     * 
     * @param date_naiss
     * @return 
     */
    private int Date_naiss(ArrayList date_naiss){
        return date_naiss.size();
    }
    /**
     * 
     * @param organisation
     * @return 
     */
    private int Organisation(ArrayList organisation){
        return organisation.size();
    }
    /**
     * 
     * @param observation
     * @return 
     */
    private int Observation(ArrayList observation){
        return observation.size();
    }


    
}
