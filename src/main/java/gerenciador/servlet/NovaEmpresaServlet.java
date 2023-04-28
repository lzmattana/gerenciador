package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando nova Empresa.");
		String nomeEmpresa = request.getParameter("nome"); // metodod para receber parametro
		String paramDataEmpresa = request.getParameter("data"); // metodod para receber parametro
		
		Date dataAbertura = null; // variavel locar para poder setar data
		try { // try necessario da data
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // transformar o getParameter que vem como string pra data
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);		
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
		
		// chamando JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome()); // seta parametro jsp
		rd.forward(request, response); // envia jsp
	}

}
