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

	public void inserir(Artista x) throws ServicoException {
		try {
			Artista aux = dao.buscaNomeExato(x.getNome());
			if (aux != null) {
				throw new ServicoException("J� Existe um artista com esse nome!", 1);
			}
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
	public void atualizar(Artista x) throws ServicoException {
		try {
			Artista aux = dao.buscaNomeExatoDiferente(x.getCodArtista(), x.getNome());
			if (aux != null) {
				throw new ServicoException("J� Existe um artista com esse nome!", 1);
			}
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

	public void excluir(Artista x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodArtista());
			if (!x.getParticipacoes().isEmpty()) {
				throw new ServicoException("Exclus�o n�o permitida: Este artista possui participa��es", 2);
			}
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

	public Artista buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Artista> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Artista> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}

	public List<Artista> buscarPorNome(String trecho) {
		return dao.buscarPorNome(trecho);
	}
}
