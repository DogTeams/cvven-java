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
public class AuthentificationController {
    
    public static boolean isLogin;
    
    public static void connexion(String login, String password){
        Modele.UserModel te = new Modele.UserModel();
        te.connexion(login,password);
        isLogin = te.isConnexion();
        
    }
    
}
