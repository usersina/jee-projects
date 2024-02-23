import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class Product extends HttpServlet {
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
        PrintWriter out = resp.getWriter();
        String categoryId = req.getParameter("categoryId");
        try {
            String query = "SELECT * FROM product WHERE categoryId = ?";
            PreparedStatement stmt = this.dbConnection.getConnection().prepareStatement(query);
            stmt.setString(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}