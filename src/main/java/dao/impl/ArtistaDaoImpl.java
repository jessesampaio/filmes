package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	private EntityManager em;
	
	public ArtistaDaoImpl(){
		this.em = EM.getLocalEm();
	}
	public void inserirAtuaizar(Artista x) {
		if(x.getCodArtista() != null){
			x = em.merge(x);
		}
		em.persist(x);
	}
	public void ecluir(Artista x) {
		x = em.merge(x);
		em.remove(x);

	}
	public Artista buscar(int cod) {
		return em.find(Artista.class, cod);
	}
	
	@SuppressWarnings("uncheked")
	public List<Artista> buscarTodos() {
		String jpql = "SELECT X FROM Artista x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
