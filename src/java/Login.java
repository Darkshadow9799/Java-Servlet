/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author THE IRON MAN
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String  uname= request.getParameter("uname");
        String pass=request.getParameter("pass");
        System.out.println("Login");
        /*if(check(uname,pass)){
            HttpSession session=request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }*/if(uname.equals("dark") && pass.equals("aayush")){
            HttpSession session=request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    String query="select * from login where uname=? and pass=?";
    public boolean check(String uname,String pass)
    {
        
        try{
        Class.forName("org.sqlite.JDBC");
           
        Connection con=DriverManager.getConnection("jdbc:sqlite:D://a.db");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from login where uname="+uname+" and pass="+pass+"");
         System.out.println("Login.check()");
        if(rs.next()){
            return true;
        }
        }catch(Exception e){
            System.out.println(e);}
        return false;
    }
}
