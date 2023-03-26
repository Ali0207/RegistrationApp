import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Connection conn = null;
      
        try {
            conn = DatabaseManager.getDatabaseManager();

            String sql = "SELECT * FROM signup WHERE Email = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String Name = rs.getString("name");
                String Email = rs.getString("email");
                String Department = rs.getString("department");
                String Adress = rs.getString("adress");
                String Contact = rs.getString("contact");

                HttpSession session = request.getSession();
                session.setAttribute("name", Name);
                session.setAttribute("email", Email);
                session.setAttribute("department", Department);
                session.setAttribute("adress", Adress);
                session.setAttribute("contact", Contact);

                response.sendRedirect("userprofile.jsp");
            } else {
                response.setContentType("text/html");
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h1>Invalid username or password</h1>");
                response.getWriter().println("</body></html>");
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
