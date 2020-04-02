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
public class UserModel {
    private int id;
    private String login;
    private String password;
    
    UserModel(){
        
    }
    public void connexion(String login, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cvvenjava","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            
            
            cn.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){ 
            e.printStackTrace();
        }
    }
    /**
     * Accesseur permtant de récupérer l'id de l'utilisateur
     * 
     * @return int id de l'utilisateur
     */
    public int getId(){
        return this.id;
    }
    /**
     * Accesseur permtant de récupérer le login de l'utilisateur
     * 
     * @return String le login unique de l'utilisateur
     */
    public String getLogin(){
        return this.login;
    }
    /**
     * Accesseur permtant de récupérer le mot de passe crypté de l'utilisateur
     * 
     * @return String le mot de passe crypté de l'utilisateur
     */
    public String getPassword(){
        return this.password;
    }
}
