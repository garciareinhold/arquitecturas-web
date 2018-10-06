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
		if(daoUsuario==null)
			daoUsuario=new UsuarioDAO();
		return daoUsuario;
	}

	public Usuario findById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TpEspecialArqWeb");
		EntityManager entityManager= emf.createEntityManager();
		Usuario user=entityManager.find(Usuario.class, id);
		entityManager.close();
		emf.close();
		return user;
	
	}
	public Usuario persist(Usuario user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TpEspecialArqWeb");
		EntityManager entityManager= emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		emf.close();
		return user;
	}
	public List<Usuario> findAll() {
		throw new UnsupportedOperationException();
	}

	
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	


	public Usuario update(Integer id, Usuario newEntityValues) {
		// TODO Auto-generated method stub
		return null;
	}


}
