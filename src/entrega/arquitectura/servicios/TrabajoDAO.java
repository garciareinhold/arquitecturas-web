package entrega.arquitectura.servicios;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entrega.arquitectura.entidades.Revision;
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
	public Trabajo findByNombre(String nombre,EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT * FROM trabajo WHERE nombre= :name", Trabajo.class);
		query.setParameter("name", nombre);
		entityManager.getTransaction().commit();
		Trabajo work=(Trabajo)query.getSingleResult();
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

	public List<Trabajo> findByUserTema(int id, String campo, EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT t.* FROM trabajo t JOIN usuario_trabajo u on(u.trabajos_id= t.id) WHERE (autores_dni= :userId) AND (t.temasConocimiento LIKE :tema)", Trabajo.class);
		query.setParameter("userId", id);
		query.setParameter("tema", "%" + campo + "%");
		entityManager.getTransaction().commit();
		List <Trabajo>trabajos=query.getResultList();
		return trabajos;
	}
}
