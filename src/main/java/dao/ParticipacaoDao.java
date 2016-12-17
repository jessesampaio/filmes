package dao;

import java.util.List;

import dominio.Participacao;

public interface ParticipacaoDao {

	public void inserirAtuaizar(Participacao x);
	public void ecluir(Participacao x);
	public Participacao buscar(int cod);
	public List<Participacao> buscarTodos();
	
}
