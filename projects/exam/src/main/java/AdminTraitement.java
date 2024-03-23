import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin-trait")
public class AdminTraitement extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DBConnection dbConnection;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            this.dbConnection = new DBConnection();
            Connection conn = dbConnection.getConnection();
            if (conn == null) {
                throw new SQLException("Can't get database connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Statement stmt = this.dbConnection.getConnection().createStatement();
            String query = "SELECT * FROM chambre";
            ResultSet rs = stmt.executeQuery(query);

            List<Chambre> chambres = new ArrayList<>();
            while (rs.next()) {
                Chambre chambre = new Chambre(rs.getInt("id"), rs.getString("nom"), rs.getString("etat"));
                chambres.add(chambre);
            }

            req.setAttribute("chambres", chambres);
            req.getRequestDispatcher("/affiche.jsp").forward(req, resp);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
