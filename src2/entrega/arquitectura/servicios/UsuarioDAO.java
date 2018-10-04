package entrega.arquitectura.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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


	public Usuario update(Integer id, Usuario newEntityValues, EntityManager entityManager) {
		return null;
	}


}
