package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.impl.EM;
import dominio.Participacao;

public class ParticipacaoServico {

	private ParticipacaoDao dao;

	public ParticipacaoServico() {
		dao = DaoFactory.criarParticipacaoDao();
	}

	public void inserirAtuaizar(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtuaizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public void ecluir(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.ecluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public Participacao buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Participacao> buscarTodos() {
		return dao.buscarTodos();
	}
}
