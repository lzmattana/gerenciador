package gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>(); // lista para guardar empresas
	
	// bloco estatico carregado ao iniciar MV
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("ORACLE");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("GOOGLE");
		lista.add(empresa);
		lista.add(empresa2);

	}
	
	public void adiciona(Empresa empresa) {		
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
