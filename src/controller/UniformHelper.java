package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PlayerUniform;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Jan 30, 2024  
*/
public class UniformHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk03Assessment1");
	
	public void insertUniform(PlayerUniform li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PlayerUniform> showUniforms(){
		EntityManager em = emfactory.createEntityManager();
		List<PlayerUniform> allItems = em.createQuery("SELECT i FROM PlayerUniform\r\n"
				+ "i").getResultList();
		return allItems;
	}
	
	public void deleteUniform(PlayerUniform toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PlayerUniform> typedQuery = em.createQuery("select li from "
				+ "PlayerUniform li where li.number = :selectedNumber and li.name = :selectedName", PlayerUniform.class);
		typedQuery.setParameter("selectedNumber", toDelete.getNumber());
		typedQuery.setParameter("selectedName",
		toDelete.getName());
		typedQuery.setMaxResults(1);
		PlayerUniform result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PlayerUniform> searchForUniformByNumber(String numberN) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PlayerUniform> typedQuery = em.createQuery("select li from PlayerUniform li where li.number = :selectedNumber",
				PlayerUniform.class);
		typedQuery.setParameter("selectedNumber", numberN);
		List<PlayerUniform> foundUnis = typedQuery.getResultList();
		em.close();
		return foundUnis;
	}

	public List<PlayerUniform> searchForUniformByName(String nameN) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PlayerUniform> typedQuery = em.createQuery("select li from PlayerUniform li where li.name = :selectedName",
				PlayerUniform.class);
		typedQuery.setParameter("selectedName", nameN);
		List<PlayerUniform> foundUnis = typedQuery.getResultList();
		em.close();
		return foundUnis;
	}

	public PlayerUniform searchForUniformById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PlayerUniform found = em.find(PlayerUniform.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(PlayerUniform toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	
	public void cleanUp() {
		emfactory.close();
	}
}
