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

public class AlteraEmpresa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("nome"); // metodod para receber parametro
		String paramDataEmpresa = request.getParameter("data"); // metodod para receber parametro
		String paramId = request.getParameter("id"); // metodod para receber parametro
		Integer id = Integer.valueOf(paramId);

		System.out.println("acao alterando empresa " + id);

		Date dataAbertura = null; // variavel locar para poder setar data
		try { // try necessario da data
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // transformar o getParameter que vem como string
																		// pra data
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		// modificando os parametros
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		return "redirect:entrada?acao=ListaEmpresas";
	}
}
