/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Warren Schneerberger
 */
public class ParticipantModel {
   
    private String nom;
    private String prenom;
    private String email;
    private String date_naiss;
    private String organisation;
    private String observation;
    
    /**
     * 
     * @param nom
     * @param prenom
     * @param email
     * @param date_naiss
     * @param organisation
     * @param observation 
     * 
     * @return boolean
     */
    public boolean insert(Object nom,Object prenom,Object email,Object date_naiss,Object organisation,Object observation){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cvvenjava","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            setNom(nom);
            setPrenom(prenom);
            setEmail(email);
            setDate_naiss(date_naiss);
            setOrganisation(organisation);
            setObservation(observation);
            
            st.execute("INSERT INTO participant (nom,prenom,email,date_naiss,organisation,observation) VALUE('"+this.nom+"','"+this.prenom+"','"+this.email+"','"+this.date_naiss+"','"+this.organisation+"','"+this.observation+"')");
            
            cn.close();
            st.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(ClassNotFoundException e){ 
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @param nom 
     */
    public void setNom(Object nom) {
        this.nom = nom.toString();
    }

    /**
     * 
     * @return String
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * 
     * @param prenom 
     */
    public void setPrenom(Object prenom) {
        this.prenom = prenom.toString();
    }

    /**
     * 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(Object email) {
        this.email = email.toString();
    }

    /**
     * 
     * @return String
     */
    public String getDate_naiss() {
        return date_naiss;
    }

    /**
     * 
     * @param date_naiss 
     */
    public void setDate_naiss(Object date_naiss) {
        this.date_naiss = date_naiss.toString();
    }

    /**
     * 
     * @return String
     */
    public String getOrganisation() {
        return organisation;
    }

    /**
     * 
     * @param organisation 
     */
    public void setOrganisation(Object organisation) {
        this.organisation = organisation.toString();
    }

    /**
     * 
     * @return String
     */
    public String getObservation() {
        return observation;
    }

    /**
     * 
     * @param observation 
     */
    public void setObservation(Object observation) {
        this.observation = observation.toString();
    }
    
    
}
