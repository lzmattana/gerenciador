package gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	// CAMADA DE PERCISTENCIA
	
	private static List<Empresa> lista = new ArrayList<>(); // lista para guardar empresas
	private static Integer chaveSequencial = 1; // simulando cad de id
	private static List<Usuario> listaUsuarios = new ArrayList<>(); // lista para guardar usuarios

	// bloco estatico carregado ao iniciar MV
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("ORACLE");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("GOOGLE");
		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("leo");
		u1.setSenha("12345");

		Usuario u2 = new Usuario();
		u2.setLogin("vivi");
		u2.setSenha("12345");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);

	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		// resolvendo exceção
		// usando iterator
		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}

	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.confirma(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
