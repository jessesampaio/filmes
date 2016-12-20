package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FilmeDao;
import dao.Transacion;
import dominio.Filme;

public class FilmeServico {

	private FilmeDao dao;

	public FilmeServico() {
		dao = DaoFactory.criarFilmeDao();
	}

	public void inserirAtualizar(Filme x) {
		try {
			Transacion.begin();
			dao.inserirAtualizar(x);
			Transacion.commit();
		} catch (RuntimeException e) {
			if (Transacion.isActive()) {
				Transacion.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluir(Filme x) {
		try {
			Transacion.begin();
			dao.excluir(x);
			Transacion.commit();
		} catch (RuntimeException e) {
			if (Transacion.isActive()) {
				Transacion.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Filme buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Filme> buscarTodos() {
		return dao.buscarTodos();
	}
}
