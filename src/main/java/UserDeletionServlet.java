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

@WebServlet("/UserDeletionServlet")
public class UserDeletionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String Email = (String) session.getAttribute("email");

        Connection conn = null;
        try {
            conn = DatabaseManager.getDatabaseManager();

            String sql = "DELETE FROM signup WHERE Email=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Email);
            pstmt.executeUpdate();
            pstmt.close();
            response.sendRedirect("delete.jsp");
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
