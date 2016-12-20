package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ParticipacaoDao;
import dominio.Participacao;

public class ParticipacaoDaoImpl implements ParticipacaoDao {

	private EntityManager em;
	
	public ParticipacaoDaoImpl(){
		this.em = EM.getLocalEm();
	}
	public void inserirAtualizar(Participacao x) {
		if(x.getCodParticipacao() != null){
			x = em.merge(x);
		}
		em.persist(x);
	}
	public void excluir(Participacao x) {
		x = em.merge(x);
		em.remove(x);

	}
	public Participacao buscar(int cod) {
		return em.find(Participacao.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Participacao> buscarTodos() {
		String jpql = "SELECT X FROM Participacao x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
