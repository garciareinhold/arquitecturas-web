package entrega.arquitectura.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.jandex.Main;

import entrega.arquitectura.entidades.Revision;
import entrega.arquitectura.entidades.Tema;
import entrega.arquitectura.entidades.Trabajo;
import entrega.arquitectura.entidades.Usuario;
import entrega.arquitectura.servicios.TrabajoDAO;
import entrega.arquitectura.servicios.UsuarioDAO;

public class SistemaCacic {

	private static EntityManagerFactory emf;

	public SistemaCacic() {
	};

	private void emfUP() {
		emf = Persistence.createEntityManagerFactory("TpEspecialArqWeb");
	}

	private void emfDown() {
		emf.close();
	}

	public void addTrabajosCongreso(Trabajo trabajo) {
		emfUP();
		EntityManager entityManager = emf.createEntityManager();
		TrabajoDAO.getInstance().persist(trabajo, entityManager);
		emfDown();
	}

	public void addParticipante(Usuario user) {
		emfUP();
		EntityManager entityManager = emf.createEntityManager();
		UsuarioDAO.getInstance().persist(user, entityManager);
		emfDown();
	}

	public void asignarTrabajoEvaluador(int dni, Trabajo trabajo) {
		// asigna el trabajo a un evaluador
		List<Usuario> evaluadores = this.getEvaluadoresCalificados(trabajo);
		for (int i = 0; i < evaluadores.size(); i++) {
			if (evaluadores.get(i).getDni() == dni) {
				Revision review = new Revision();
				review.setEvaluador(evaluadores.get(i));
				review.setTrabajo(trabajo);
				Calendar fechaRevision = new GregorianCalendar(2013, 0, 31);
				review.setFechaRevision(fechaRevision);
				evaluadores.get(i).addRevision(review);
			}

		}
	}

	public List<Usuario> getEvaluadoresCalificados(Trabajo trabajo) {
		List<Usuario> retorno = new ArrayList<Usuario>();
		List<Tema> temasTrabajo = trabajo.getTemasConocimiento();
		List<Usuario> participantes = getALLParticipantes();
		for (int i = 0; i < participantes.size(); i++) {
			Usuario user = participantes.get(i);
			if (trabajo.evaluadorHabilitado(user) && trabajo.aceptaRevision(user)) {
				retorno.add(user);
			}
		}
		return retorno;
	}

	private List<Usuario> getALLParticipantes() {
		List<Usuario> retorno;
		emfUP();
		EntityManager entityManager = emf.createEntityManager();
		retorno = UsuarioDAO.getInstance().findAll(entityManager);
		emfDown();
		return retorno;
	}

	public List<Trabajo> getTrabajosDisponiblesEvaluador(int dni) {
		List<Trabajo> retorno = new ArrayList<Trabajo>();
		List<Usuario> participantes = getALLParticipantes();
		List<Trabajo> trabajosCongreso = getAllTrabajos();
		Usuario evaluador = null;
		for (int i = 0; i < participantes.size(); i++) {
			if (participantes.get(i).getDni() == dni) {
				evaluador = participantes.get(i);
				for (int x = 0; x < trabajosCongreso.size(); x++) {
					Trabajo trabajo = trabajosCongreso.get(x);
					if (trabajo.evaluadorHabilitado(evaluador) && trabajo.aceptaRevision(evaluador)) {
						retorno.add(trabajo);
					}
				}
			}
		}
		return retorno;
	}

	private List<Trabajo> getAllTrabajos() {
		List<Trabajo> retorno;
		emfUP();
		EntityManager entityManager = emf.createEntityManager();
		retorno = TrabajoDAO.getInstance().findAll(entityManager);
		emfDown();
		return retorno;
	}

	public List<Trabajo> getTrabajosAsignados(int dni) {
		List<Usuario> participantes = getALLParticipantes();
		for (int i = 0; i < participantes.size(); i++) {
			if (participantes.get(i).getDni() == dni) {
				return participantes.get(i).getTrabajos();
			}
		}
		return null;
	}

	public boolean esExperto(int dni) {
		List<Usuario> participantes = getALLParticipantes();
		boolean experto = false;
		for (int i = 0; i < participantes.size(); i++) {
			if (participantes.get(i).getDni() == dni) {
				experto = participantes.get(i).esExperto();
			}
		}
		return experto;
	}

	public static Usuario getDatosUsuario(int dni, EntityManager entityManager) {
		Usuario user = UsuarioDAO.getInstance().findById(dni, entityManager);
		return user;
	}

	public static List<Trabajo> BuscarTrabajosAsignados(int dni, EntityManager entityManager) {
		List<Trabajo> trabajos = UsuarioDAO.getInstance().findTrabajos(10, entityManager);
		return trabajos;
	}

	public static List<Revision> buscarRevisiones(int dni, Calendar desde, Calendar hasta,
			EntityManager entityManager) {
		List<Revision> revisiones = UsuarioDAO.getInstance().findRevisiones(dni, desde, hasta, entityManager);
		return revisiones;
	}

	public static List<Trabajo> buscarTrabajosAutores(int dni, EntityManager entityManager) {
		List<Trabajo> trabajos = UsuarioDAO.getInstance().findTrabajosAutores(dni, entityManager);
		return trabajos;
	}

	public static Trabajo buscarTrabajoByID(int id, EntityManager entityManager) {
		Trabajo work = TrabajoDAO.getInstance().findById(id, entityManager);
		return work;
	}

	public static Trabajo buscarTrabajoByNombre(String nombre, EntityManager entityManager) {
		Trabajo work = TrabajoDAO.getInstance().findByNombre(nombre, entityManager);
		return work;
	}

	public static List<Trabajo> buscarTrabajoNombreTema(String tema, EntityManager entityManager) {
		List<Trabajo> trabajos = TrabajoDAO.getInstance().findByUserTema(tema, entityManager);
		return trabajos;
	}

}
