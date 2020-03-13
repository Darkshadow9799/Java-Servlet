/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author THE IRON MAN
 */
public class DaoLogin {
    String query="select * from login where uname=? and pass=?";
    public boolean check(String uname,String pass)
    {
        
                try{
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:D://a.db");
        PreparedStatement st=con.prepareCall(query);
        st.setString(0, uname);
        st.setString(1, pass);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            return true;
        }
        }catch(Exception e){
            System.out.println("Dao.LoginDao.check()");}
        return false;
    }
    
}
