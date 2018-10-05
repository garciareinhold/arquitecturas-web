package entrega.arquitectura.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entrega.arquitectura.entidades.Trabajo;
import entrega.arquitectura.entidades.Usuario;


public class UsuarioDAO implements DAO<Usuario,Integer>{
	
	private static UsuarioDAO daoUsuario;
	
	private UsuarioDAO(){}

	public static UsuarioDAO getInstance() {
		if(daoUsuario==null) {
			daoUsuario=new UsuarioDAO();;
		}
		
		return daoUsuario;
	}

	public Usuario findById(Integer id, EntityManager entityManager) {
		Usuario user=entityManager.find(Usuario.class, id);
		return user;
	
	}
	public Usuario persist(Usuario user,EntityManager entityManager) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		return user;
	}
	public List<Usuario> findAll(EntityManager entityManager) {
		throw new UnsupportedOperationException();
	}

	
	public boolean delete(Integer id,EntityManager entityManager) {
		Usuario user= this.findById(id, entityManager);
		if(user!=null) {
			entityManager.getTransaction().begin();
			entityManager.remove(user);
			entityManager.getTransaction().commit();
			return true;
		}
		else {
			return false;
		}
	}
	public List<Trabajo> findTrabajos(Integer id,EntityManager entityManager){
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT t.* FROM revision r Join trabajo t on(r.trabajo_id=t.id and r.evaluador_dni = :revId)", Trabajo.class);
		query.setParameter("revId", id);
		entityManager.getTransaction().commit();
		List <Trabajo>trabajos=query.getResultList();
		return trabajos;
	}

	public Usuario update(Integer id, Usuario newEntityValues, EntityManager entityManager) {
		return null;
	}


}
