package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/oi") // caminho de acesso
public class OiTeste extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter(); // cria obj
		out.println("<html>");
		out.println("<body>");
		out.println("TESTE INICIAL HTTP");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("OBJ CHAMADO"); // teste console de acesso
	}
}