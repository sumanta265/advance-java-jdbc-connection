package com.sumanta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class regApp
 */
@WebServlet("/regApp")
public class regApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String url ="jdbc:mysql://localhost:3308/register";
		   String userName ="root";
		   String password ="root";    
			
			  res.setContentType("text/html");
			  PrintWriter out  =res.getWriter();
			  String n= req.getParameter("userName");
			  String p= req.getParameter("userPass");
		      String e= req.getParameter("userEmail");
		      String c= req.getParameter("userCountry");
	       try
	       {
	    	
	    	   
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   Connection con= DriverManager.getConnection(url,userName,password);
	    	   String sql= "insert into REGISTERUSER VALUES(?,?,?,?)";
	           PreparedStatement ps =con.prepareStatement(sql); 
	    	   ps.setString(1,n);
	    	   ps.setString(2,p);
	    	   ps.setString(3,e);
	    	   ps.setString(4,c);
	    	  int i =ps.executeUpdate();
	    	  if(i>0)
	    		  out.println("you are successfully registered...");
	    	  else
	    		  out.println("insertion failed");
	       }catch(Exception e2)
	       {
	    	   System.out.println(e2);
	    	   
	       }
		      
		      out.close();

		
		
		
		
		
		
		
	}

}
