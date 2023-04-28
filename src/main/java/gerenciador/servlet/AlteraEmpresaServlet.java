package gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando Empresa.");
		
		String nomeEmpresa = request.getParameter("nome"); // metodod para receber parametro
		String paramDataEmpresa = request.getParameter("data"); // metodod para receber parametro
		String paramId = request.getParameter("id"); // metodod para receber parametro
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null; // variavel locar para poder setar data
		try { // try necessario da data
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // transformar o getParameter que vem como string pra data
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);		
		}
		
		System.out.println(id);
		
		//modificando os parametros
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listaEmpresas");
		
	}

}
