package servico;

import java.util.List;

import dao.ArtistaDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Artista;

public class ArtistaServico {

	private ArtistaDao dao;

	public ArtistaServico() {
		dao = DaoFactory.criarArtistaDao();
	}
	
	public void inserirAtuaizar(Artista x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtuaizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public void ecluir(Artista x) {
		EM.getLocalEm().getTransaction().begin();
		dao.ecluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public Artista buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Artista> buscarTodos() {
		return dao.buscarTodos();
	}
}
