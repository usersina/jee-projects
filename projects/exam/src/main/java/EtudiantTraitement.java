import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/etudiant-trait")
public class EtudiantTraitement extends HttpServlet {
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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String cin = (String) req.getSession().getAttribute("CIN");

        try {
            Statement stmt = this.dbConnection.getConnection().createStatement();
            String query = "SELECT * FROM utilisateur WHERE cin = '" + cin + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                out.println("<h1>Student Information</h1>");
                out.println("<p>Name: " + rs.getString("nom") + "</p>");
                out.println("<p>First Name: " + rs.getString("prenom") + "</p>");
                out.println("<p>Address: " + rs.getString("addresse") + "</p>");
            } else {
                System.err.println("Illegal: No user found with CIN: " + cin);
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
