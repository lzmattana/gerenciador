package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//mapeamento do filtro
@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// t1 de exec
		long antes = System.currentTimeMillis();

		String acao = request.getParameter("acao");
		
		// executa a acao
		chain.doFilter(request, response);

		// t2 de exec
		long depois = System.currentTimeMillis();

		// calc tempo exec
		System.out.println("Tempo de execução da ação: " + acao + " -> " + (depois - antes));
	}

}
