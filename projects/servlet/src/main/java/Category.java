import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/category")
public class Category extends HttpServlet {
    DBConnection dbConnection;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
        PrintWriter out = resp.getWriter();
        try {
            Statement stmt = this.dbConnection.getConnection().createStatement();
            String query = "SELECT * FROM category";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String link = String.format("<a href=\"./product?categoryId=%s\">%s</a>", rs.getString("id"),
                        rs.getString("name"));
                out.println(link);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
