import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SignupForm")
public class SignupForm extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       
        String Name = request.getParameter("name");
        String Email = request.getParameter("email");
        String Department = request.getParameter("department");
        String Adress = request.getParameter("adress");
        String Contact = request.getParameter("contact");
        String Password = request.getParameter("password");
        
        
        Connection conn= DatabaseManager.getDatabaseManager();
    	
        try {
           
            String sql = "INSERT INTO signup (Name, Email, Department, Adress, Contact, Password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Name);
            pstmt.setString(2, Email);
            pstmt.setString(3, Department);
            pstmt.setString(4, Adress);
            pstmt.setString(5, Contact);
            pstmt.setString(6, Password);
            
           
            pstmt.executeUpdate();
            
           
            
           
            response.sendRedirect("Login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {  
        	  try {
        		  conn.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
              
        }
    }
}