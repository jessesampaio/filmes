package dao;

import java.util.List;

import dominio.Artista;

public interface ArtistaDao {

	public void inserirAtuaizar(Artista x);
	public void ecluir(Artista x);
	public Artista buscar(int cod);
	public List<Artista> buscarTodos();
	
}
