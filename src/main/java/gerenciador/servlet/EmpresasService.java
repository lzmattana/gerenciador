package gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();
		
		//obj gson 
		Gson gson = new Gson();
		String json = gson.toJson(empresas); 
		
		// definindo qual tipo de conteudo app/json boa pratica
		response.setContentType("application/json");
		//metodo para imprimir json
		response.getWriter().print(json);
	}

}
