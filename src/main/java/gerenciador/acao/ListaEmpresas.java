package gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class ListaEmpresas {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando empresas");
		
		Banco banco = new Banco(); // iniciando obj 
		List<Empresa> lista = banco.getEmpresas(); //recuperando lista de empresas
		request.setAttribute("empresas", lista);
		
		return "forward:/listaEmpresas.jsp"; // retorna uma string por conta do metodo 
	}
}
