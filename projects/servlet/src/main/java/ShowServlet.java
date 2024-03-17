import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
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
        String query = "SELECT * FROM product";
        try {
            PreparedStatement stmt = this.dbConnection.getConnection().prepareStatement(query);
            List<ProductBean> products = new ArrayList<ProductBean>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(
                        new ProductBean(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("quantity")) //
                ); //
            }
            req.setAttribute("products", products);
            req.getRequestDispatcher("show.jsp").forward(req, resp);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
