import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/connection")
public class Connection extends HttpServlet {
    DBConnection dbConnection;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            this.dbConnection = new DBConnection();
            java.sql.Connection conn = dbConnection.getConnection();
            if (conn == null) {
                throw new SQLException("Can't get database connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nom = (String) session.getAttribute("nom");
        if (nom == null) {
            String login = request.getParameter("login");
            String password = request.getParameter("mdp");
            String query = "SELECT * FROM users WHERE login = ? AND mdp = ?";
            try {
                PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
                stmt.setString(1, login);
                stmt.setString(2, password);
                if (stmt.executeQuery().next()) {
                    session.setAttribute("nom", login);
                    response.sendRedirect("./menu.jsp");
                } else {
                    response.sendRedirect("./login.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("./menu.jsp");
        }
    }
}
