package entrega.arquitectura.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entrega.arquitectura.entidades.Revision;

public class RevisionDAO implements DAO<Revision,Integer>{
	private static RevisionDAO daoRevision;
	
	private RevisionDAO(){}

	public static RevisionDAO getInstance() {
		if(daoRevision==null)
			daoRevision=new RevisionDAO();
		return daoRevision;
	}

	public Revision findById(Integer id, EntityManager entityManager) {
		Revision review=entityManager.find(Revision.class, id);
		return review;
	
	}
	public Revision persist(Revision review,EntityManager entityManager) {
		entityManager.getTransaction().begin();
		entityManager.persist(review);
		entityManager.getTransaction().commit();
		return review;
	}
	public List<Revision> findAll(EntityManager entityManager) {
		throw new UnsupportedOperationException();
	}

	
	public boolean delete(Integer id,EntityManager entityManager) {
		throw new UnsupportedOperationException();
	}

	public Revision update(Integer id, Revision newEntityValues, EntityManager entityManager) {
		// TODO Auto-generated method stub
		return null;
	}


}
