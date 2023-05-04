package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.acao.Acao;

@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest; // cast de algo mais generico pra especifico
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// metodo para liberar sessao e trabalhar com o cookie

		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "gerenciador.acao." + paramAcao; // string do nome da classe para encapsulamento

		// objeto carregado na MV
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); // carrega a classe com o nome
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj; // transformando o obj generico
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}

}
