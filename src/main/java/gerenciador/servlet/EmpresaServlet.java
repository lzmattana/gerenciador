package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/empresa")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova Empresa.");
		String nomeEmpresa = request.getParameter("nome"); // metodod para receber parametro
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
	}

}
