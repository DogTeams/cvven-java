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
    
    private boolean connexion;
    

    /**
     * Retourne si la connexion est correcte
     * 
     * @param login
     * @param password
     */
    public void connexion(String login, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cvvenjava","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            setLogin(login);
            setPassword(password);
            
            var isLogin = st.executeQuery("SELECT * FROM utilisateur where utilisateur.login ="+'"'+this.login+'"'+" and utilisateur.password="+'"'+MD5(this.password)+'"');
            if(isLogin.next()){
                connexion = true;
            }
            else{
                connexion = false;
            }
            cn.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){ 
            e.printStackTrace();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Accesseur permetant de récupérer l'id de l'utilisateur
     * 
     * @return int id de l'utilisateur
     */
    public int getId(){
        return this.id;
    }
    /**
     * Accesseur permetant de récupérer le login de l'utilisateur
     * 
     * @return String le login unique de l'utilisateur
     */
    public String getLogin(){
        return this.login;
    }
    /**
     * Accesseur permetant de récupérer le mot de passe crypté de l'utilisateur
     * 
     * @return String le mot de passe crypté de l'utilisateur
     */
    public String getPassword(){
        return this.password;
    }
    /**
     * Accesseur permetant de savoir si la connexion fonctionne
     * 
     * @return boolean
     */
    public boolean isConnexion() {
        return connexion;
    }
    public String MD5(String md5) {
    try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
    }
}
