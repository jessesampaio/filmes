package dao;

import java.util.List;

import dominio.Filme;

public interface FilmeDao {

	public void inserirAtuaizar(Filme x);
	public void ecluir(Filme x);
	public Filme buscar(int cod);
	public List<Filme> buscarTodos();
	
}
