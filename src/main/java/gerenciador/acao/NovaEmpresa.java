package gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class NovaEmpresa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		request.setAttribute("empresa", empresa.getNome()); // seta parametro jsp
		// fazendo um redirecionamento ClientSide
		return "redirect:entrada?acao=ListaEmpresas";
		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
		
//		// chamando JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome()); // seta parametro jsp
//		rd.forward(request, response); // envia jsp
	}
}
