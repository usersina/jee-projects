import java.io.IOException;
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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// clear the session
		request.getSession().invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Logging in new user");

		// Get the parameters from the form
		String cin = request.getParameter("cin");
		String password = request.getParameter("password");

		try {
			// Check if the user exists in the database
			Statement stmt = this.dbConnection.getConnection().createStatement();
			String query = "SELECT * FROM utilisateur WHERE cin = '" + cin + "' AND password = '" + password + "'";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				String role = rs.getString("role");

				// If the user exists, save the CIN, nom and role in the session
				request.getSession().setAttribute("CIN", cin);
				request.getSession().setAttribute("nom", rs.getString("nom"));
				request.getSession().setAttribute("role", role);

				// Redirect the user to the appropriate page
				if (role.equals("admin")) {
					response.sendRedirect(request.getContextPath() + "/menu.jsp");
				} else {
					response.sendRedirect(request.getContextPath() + "/etudiant-trait");
				}
			} else {
				// If the user doesn't exist, simply redirect to the login page
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
