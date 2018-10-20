package entrega.arquitectura.servicios;

import java.util.List;

import javax.persistence.EntityManager;

import entrega.arquitectura.entidades.Tema;
import entrega.arquitectura.entidades.Usuario;


public class TemaDAO implements DAO<Tema,Integer>{
	private static TemaDAO daoTema;
	public TemaDAO() {}
	public static TemaDAO getInstance() {
		if(daoTema==null) {
			daoTema=new TemaDAO();;
		}
		
		return daoTema;
	}

	@Override
	public Tema persist(Tema tema, EntityManager entityManager) {
		entityManager.getTransaction().begin();
		entityManager.persist(tema);
		entityManager.getTransaction().commit();

		return tema;
	}

	@Override
	public Tema update(Integer id, Tema newEntityValues, EntityManager entityManager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema findById(Integer id, EntityManager entityManager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tema> findAll(EntityManager entityManager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id, EntityManager entityManager) {
		Tema tema= this.findById(id, entityManager);
		if(tema!=null) {
			entityManager.getTransaction().begin();
			entityManager.remove(tema);
			entityManager.getTransaction().commit();
			return true;
		}
		else {
			return false;
		}
	}
	
}
