package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	private EntityManager em;

	public ArtistaDaoImpl() {
		this.em = EM.getLocalEm();
	}

	public void inserirAtualizar(Artista x) {
		if (x.getCodArtista() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	public void excluir(Artista x) {
		x = em.merge(x);
		em.remove(x);
	}

	public Artista buscar(int cod) {
		return em.find(Artista.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodos() {
		String jpql = "SELECT x FROM Artista x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Artista x ORDER BY x.nome";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Artista buscaNomeExato(String nome) {
		String jpql = "SELECT x FROM Artista x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Artista> aux = query.getResultList();
		// se o aux.size > 0 retorna o primeiro elemento, senão
		// retorna nulo, não tem artista com esse nome
		return (aux.size() > 0) ? aux.get(0) : null;
	}
}
