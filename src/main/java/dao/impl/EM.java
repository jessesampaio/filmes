package dao.impl;

import javax.persistence.EntityManager;

public class EM {
	//Padr�o de Projeto chamado Registre
	//Classe que antem uma �nica inst�ncia do EntityManager
	//por Thread 
	private static ThreadLocal<EntityManager> localEm = new ThreadLocal<EntityManager>();
	
	public static synchronized EntityManager getLocalEm(){
		EntityManager em = localEm.get();
		if(em == null){
			em = EMF.get().createEntityManager();
			localEm.set(em);
		}
		return em;
	}
	
	public static void closeLocalEm(){
		EntityManager em = localEm.get();
		if(em == null){
			localEm.get().close();
			localEm.set(null);
		}
		
	}
	
	
}
