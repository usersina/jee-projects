import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		System.out.println("Processing post request");

		response.setContentType("text/html");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Nom: " + nom + "<br>");
		out.println("Prenom: " + prenom + "<br>");
		out.println("</body></html>");
	}
}
