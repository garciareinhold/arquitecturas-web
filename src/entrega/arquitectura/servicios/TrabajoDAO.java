package entrega.arquitectura.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entrega.arquitectura.entidades.Trabajo;
import entrega.arquitectura.entidades.Usuario;

public class TrabajoDAO implements DAO<Trabajo,Integer>{

	private static TrabajoDAO daoTrabajo;
	
	private TrabajoDAO(){}

	public static TrabajoDAO getInstance() {
		if(daoTrabajo==null)
			daoTrabajo=new TrabajoDAO();
		return daoTrabajo;
	}

	public Trabajo findById(Integer id,EntityManager entityManager) {
		Trabajo work=entityManager.find(Trabajo.class, id);
		return work;
	
	}
	public Trabajo persist(Trabajo work,EntityManager entityManager) {
		entityManager.getTransaction().begin();
		entityManager.persist(work);
		entityManager.getTransaction().commit();
		return work;
	}
	public List<Trabajo> findAll(EntityManager entityManager) {
		throw new UnsupportedOperationException();
	}

	
	public boolean delete(Integer id, EntityManager entityManager) {
		throw new UnsupportedOperationException();
	}



	@Override
	public Trabajo update(Integer id, Trabajo newEntityValues, EntityManager entityManager) {
		// TODO Auto-generated method stub
		return null;
	}
}
