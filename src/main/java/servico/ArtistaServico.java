package servico;

import java.util.List;

import dao.ArtistaDao;
import dao.DaoFactory;
import dao.Transacion;
import dominio.Artista;

public class ArtistaServico {

	private ArtistaDao dao;

	public ArtistaServico() {
		dao = DaoFactory.criarArtistaDao();
	}
	
	public void inserirAtualizar(Artista x) {
		try {
			Transacion.begin();
			dao.inserirAtualizar(x);
			Transacion.commit();
		} catch (RuntimeException e) {
			if(Transacion.isActive()){
				Transacion.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluir(Artista x) {
		try {
			Transacion.begin();
			dao.excluir(x);
			Transacion.commit();
		} catch (RuntimeException e) {
			if(Transacion.isActive()){
				Transacion.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Artista buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Artista> buscarTodos() {
		return dao.buscarTodos();
	}
}
