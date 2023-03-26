import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String adress = request.getParameter("adress");
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");
        

        try (Connection conn = DatabaseManager.getDatabaseManager()) {
            String sql = "UPDATE signup SET Name=?, Adress=?, Department=?, Contact=?, Password=? WHERE Email=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, adress);
            pstmt.setString(3, department);
            pstmt.setString(4, contact);
            pstmt.setString(5, password); 
            pstmt.setString(6, email); 
            pstmt.executeUpdate();
            pstmt.close();
            
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
