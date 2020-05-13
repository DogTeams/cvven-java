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
import java.util.ArrayList;

/**
 * 
 * @author Warren Schneerberger
 */
public class EvenementModel {

    private int num_event;
    private String intitule;
    private String theme;
    private String date_debut;
    private String duree;
    private int nb_part_max;
    private String description;
    private String organisateur;
    private String type_event;

    /**
     * Permet d'insérer un événement dans la table
     * 
     * @param intitule
     * @param theme
     * @param date_debut
     * @param duree
     * @param description
     * @param organisateur
     * @param type_event 
     */
    public boolean insert(String intitule,String theme,String date_debut,String duree,String description,String organisateur,String type_event){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cvvenjava","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            setIntitule(intitule);
            setTheme(theme);
            setDate_debut(date_debut);
            setDuree(duree);
            setDescription(description);
            setOrganisateur(organisateur);
            setType_event(type_event); 
            
            st.execute("INSERT INTO evenement (intitule,theme,date_debut,duree,description,organisateur,type_event) VALUE('"+this.intitule+"','"+this.theme+"','"+this.date_debut+"','"+this.duree+"','"+this.description+"','"+this.organisateur+"','"+this.type_event+"')");
            
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
     * @return 
     */
    public static ArrayList getAllIntitule(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cvvenjava","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            var query = st.executeQuery("SELECT num_event, intitule FROM evenement");
            ArrayList Intitules = new ArrayList();
   
            while(!query.isClosed()){
                query.next();
                Intitules.add(query.getString("intitule"));
                if(query.isLast()){
                    query.close();
                }
            }
            cn.close();
            st.close();
            return Intitules;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){ 
            e.printStackTrace();
            return null;
        }
    }
    public void setNum_event(int num_event) {
        this.num_event = num_event;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setNb_part_max(int nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }
    
    /**
     * 
     * @return int
     */
    public int getNum_event() {
        return num_event;
    }
    /**
     * 
     * @return String
     */
    public String getIntitule() {
        return intitule;
    }
    /**
     * 
     * @return String
     */
    public String getTheme() {
        return theme;
    }
    /**
     * 
     * @return Date
     */
    public String getDate_debut() {
        return date_debut;
    }
    /**
     * 
     * @return Time
     */
    public String getDuree() {
        return duree;
    }
    /**
     * 
     * @return int
     */
    public int getNb_part_max() {
        return nb_part_max;
    }
    /**
     * 
     * @return String
     */
    public String getDescription() {
        return description;
    }
    /**
     * 
     * @return String
     */
    public String getOrganisateur() {
        return organisateur;
    }
    /**
     * 
     * @return String
     */
    public String getType_event() {
        return type_event;
    }
    
}
