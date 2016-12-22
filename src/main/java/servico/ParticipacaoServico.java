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

	public void inserir(Participacao x) throws ServicoException{
		Participacao aux = dao.buscarExato(x.getPersonagem(),x.getArtista(),x.getFilme());
		if(aux != null){
			throw new ServicoException("Já existe esse mesmo personagem cadastrado para o"+
					" artista " + x.getArtista().getNome() + " no filme: " + x.getFilme().getTitulo(), 1);
		}	
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

	public void atualizar(Participacao x) throws ServicoException{
		Participacao aux = dao.buscarExatoDiferente(x.getCodParticipacao(), x.getPersonagem(),x.getArtista(),x.getFilme());
		if(aux != null){
			throw new ServicoException("Já existe esse mesmo personagem cadastrado para o"+
					" artista " + x.getArtista().getNome() + " no filme: " + x.getFilme().getTitulo(), 1);
		}

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
