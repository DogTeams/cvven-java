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
public class SalleModel {
    private int id;
    private boolean etatsalle;
    private int num_max;
    
    public void insert(boolean etatsalle, int num_max){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cvvenjava","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            st.execute("INSERT INTO salle (etatsalle, num_max) VALUE("+etatsalle+","+num_max+")");
            
            cn.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){ 
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public boolean isEtatsalle() {
        return etatsalle;
    }

    public int getNum_max() {
        return num_max;
    }
    
    
}
