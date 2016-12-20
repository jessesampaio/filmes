package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FilmeDao;
import dao.impl.EM;
import dominio.Filme;

public class FilmeServico {

	private FilmeDao dao;

	public FilmeServico() {
		dao = DaoFactory.criarFilmeDao();
	}

	public void inserirAtuaizar(Filme x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtuaizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public void ecluir(Filme x) {
		EM.getLocalEm().getTransaction().begin();
		dao.ecluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public Filme buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Filme> buscarTodos() {
		return dao.buscarTodos();
	}
}
