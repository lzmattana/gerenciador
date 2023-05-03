package gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebendo info
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando " + login);
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("usuario existe");
			// requisicao do obj session, obj para usuario guardar info, cookie
			HttpSession sessao = request.getSession(); 
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
