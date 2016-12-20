package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.Transacion;
import dominio.Participacao;

public class ParticipacaoServico {

	private ParticipacaoDao dao;

	public ParticipacaoServico() {
		dao = DaoFactory.criarParticipacaoDao();
	}

	public void inserirAtualizar(Participacao x) {
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

	public void excluir(Participacao x) {
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

	public Participacao buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Participacao> buscarTodos() {
		return dao.buscarTodos();
	}
}
