package entrega.arquitectura.test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entrega.arquitectura.entidades.Articulo;
import entrega.arquitectura.entidades.Poster;
import entrega.arquitectura.entidades.Resumen;
import entrega.arquitectura.entidades.Revision;
import entrega.arquitectura.entidades.Trabajo;
import entrega.arquitectura.entidades.Usuario;
import entrega.arquitectura.servicios.RevisionDAO;
import entrega.arquitectura.servicios.TrabajoDAO;
import entrega.arquitectura.servicios.UsuarioDAO;

public class TestEntrega {
	private static EntityManagerFactory emf;
	@AfterClass
	public static void closeFactory() {
		emf.close();
	}
	@BeforeClass
	public static void setEntityManeger() {
		emf= Persistence.createEntityManagerFactory("TpEspecialArqWeb");
	}
	
	/**
	 * Metodo que corresponde al inciso a, b y c.
	 */
	@Test
	public void altaUsuariosTrabajosRevisiones() {
		EntityManager entityManager= emf.createEntityManager();
		//////////////////////USUARIOS
		Usuario user = new Usuario();
		user.setDni(1);
		user.setApellido("Guerra");
		user.setNombre("Maximiliano");
		user.setEsEvaluador(true);
		user.setEsExperto(true);
		user.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user2 = new Usuario();
		user2.setDni(2);
		user2.setApellido("Guerra");
		user2.setNombre("Morena");
		user2.setEsEvaluador(true);
		user2.setEsExperto(true);
		user2.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user3 = new Usuario();
		user3.setDni(3);
		user3.setApellido("Guerra");
		user3.setNombre("Maximiliano");
		user3.setEsEvaluador(true);
		user3.setEsExperto(true);
		user3.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user4 = new Usuario();
		user4.setDni(4);
		user4.setApellido("G44erra");
		user4.setNombre("Maxi555iliano");
		user4.setEsEvaluador(true);
		user4.setEsExperto(true);
		user4.setLugarDeTrabajo("Mu444icipalidad De Tandil");

		Usuario user5 = new Usuario();
		user5.setDni(5);
		user5.setApellido("Guerra");
		user5.setNombre("Mdddddddaximiliano");
		user5.setEsEvaluador(true);
		user5.setEsExperto(true);
		user5.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user6 = new Usuario();
		user6.setDni(6);
		user6.setApellido("Guerra");
		user6.setNombre("Masddddddddddddximiliano");
		user6.setEsEvaluador(true);
		user6.setEsExperto(true);
		user6.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user7 = new Usuario();
		user7.setDni(7);
		user7.setApellido("Guerra");
		user7.setNombre("Madddddximiliano");
		user7.setEsEvaluador(true);
		user7.setEsExperto(true);
		user7.setLugarDeTrabajo("Mdddunicipalidad De Tandil");

		Usuario user8 = new Usuario();
		user8.setDni(8);
		user8.setApellido("Guerra");
		user8.setNombre("Maximiliano");
		user8.setEsEvaluador(true);
		user8.setEsExperto(true);
		user8.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user9 = new Usuario();
		user9.setDni(9);
		user9.setApellido("Guerra");
		user9.setNombre("Maximiliano");
		user9.setEsEvaluador(true);
		user9.setEsExperto(true);
		user9.setLugarDeTrabajo("Municipalidad De Tandil");

		Usuario user10 = new Usuario();
		user10.setDni(10);
		user10.setApellido("Guerra");
		user10.setNombre("Maximiliano");
		user10.setEsEvaluador(true);
		user10.setEsExperto(true);
		user10.setLugarDeTrabajo("Municipalidad De Tandil");


		/////////////////////TRABAJOS

		Trabajo poster = new Poster();
		poster.setNombre("Dinamica");
		poster.addAutor(user);
		user.addTrabajos(poster);
		poster.setTemasConocimiento("dfsdf dsggg gsgsafg dgfg Redes dfsg fgdsdfg");

		Trabajo articulo = new Articulo();
		articulo.setNombre("Derivadas");
		articulo.addAutor(user2);
		user2.addTrabajos(articulo);

		Trabajo resume = new Resumen();
		resume.setNombre("Fisica");
		resume.addAutor(user3);
		user3.addTrabajos(resume);

		Trabajo poster2 = new Poster();
		poster2.setNombre("Termodinamica");
		poster2.addAutor(user4);
		user4.addTrabajos(poster2);

		Trabajo articulo2 = new Articulo();
		articulo2.setNombre("JAVA");
		articulo2.addAutor(user5);
		user5.addTrabajos(articulo2);

		Trabajo resume2 = new Resumen();
		resume2.setNombre("JAVA");
		resume2.addAutor(user6);
		user6.addTrabajos(resume2);

		Trabajo poster3 = new Poster();
		poster3.setNombre("Eclipse");
		poster3.addAutor(user10);
		user10.addTrabajos(poster3);

		Trabajo articulo3 = new Articulo();
		articulo3.setNombre("JavaScript");
		articulo3.addAutor(user7);
		user7.addTrabajos(articulo3);

		Trabajo resume3 = new Resumen();
		resume3.setNombre("HTML5");
		resume3.addAutor(user8);
		user8.addTrabajos(resume3);

		Trabajo poster4 = new Poster();
		poster4.setNombre("JAVA");
		poster4.addAutor(user9);
		user9.addTrabajos(poster4);


		//////////////REVISIONES

		Calendar fechaRevision1 = new GregorianCalendar(2013,0,31);
		Calendar fechaRevision2 = new GregorianCalendar(2011,0,31);
		Calendar fechaRevision3 = new GregorianCalendar(2017,0,31);
		Calendar fechaRevision4= new GregorianCalendar(2018,0,31);

		Revision rev= new Revision();
		rev.setEvaluador(user);
		user.addRevision(rev);
		rev.setTrabajo(poster);
		poster.addReview(rev);
		rev.setFechaRevision(fechaRevision1);

		Revision rev10= new Revision();
		rev10.setEvaluador(user2);
		user2.addRevision(rev10);
		rev10.setTrabajo(poster2);
		poster2.addReview(rev10);
		rev10.setFechaRevision(fechaRevision2);

		Revision rev2= new Revision();
		rev2.setEvaluador(user3);
		user3.addRevision(rev2);
		rev2.setTrabajo(poster3);
		poster3.addReview(rev2);
		rev2.setFechaRevision(fechaRevision3);

		Revision rev3= new Revision();
		rev3.setEvaluador(user4);
		user4.addRevision(rev3);
		rev3.setTrabajo(poster4);
		poster4.addReview(rev3);
		rev3.setFechaRevision(fechaRevision4);

		Revision rev4= new Revision();
		rev4.setEvaluador(user5);
		user5.addRevision(rev4);
		rev4.setTrabajo(resume);
		resume.addReview(rev4);
		rev4.setFechaRevision(fechaRevision1);

		Revision rev5= new Revision();
		rev5.setEvaluador(user6);
		user6.addRevision(rev5);
		rev5.setTrabajo(resume2);
		resume2.addReview(rev5);
		rev5.setFechaRevision(fechaRevision2);

		Revision rev6= new Revision();
		rev6.setEvaluador(user7);
		user7.addRevision(rev6);
		rev6.setTrabajo(articulo);
		articulo.addReview(rev6);
		rev6.setFechaRevision(fechaRevision3);

		Revision rev7= new Revision();
		rev7.setEvaluador(user8);
		user8.addRevision(rev7);
		rev7.setTrabajo(articulo2);
		articulo2.addReview(rev7);
		rev7.setFechaRevision(fechaRevision4);

		Revision rev8= new Revision();
		rev8.setEvaluador(user10);
		user10.addRevision(rev8);
		rev8.setTrabajo(poster);
		poster.addReview(rev8);
		rev8.setFechaRevision(fechaRevision1);

		Revision rev9= new Revision();
		rev9.setEvaluador(user10);
		user10.addRevision(rev9);
		rev9.setTrabajo(poster2);
		poster2.addReview(rev9);
		rev9.setFechaRevision(fechaRevision2);


		////////// PERSIST

		UsuarioDAO.getInstance().persist(user,entityManager);
		UsuarioDAO.getInstance().persist(user2,entityManager);
		UsuarioDAO.getInstance().persist(user3,entityManager);
		UsuarioDAO.getInstance().persist(user4,entityManager);
		UsuarioDAO.getInstance().persist(user5,entityManager);
		UsuarioDAO.getInstance().persist(user6,entityManager);
		UsuarioDAO.getInstance().persist(user7,entityManager);
		UsuarioDAO.getInstance().persist(user8,entityManager);
		UsuarioDAO.getInstance().persist(user9,entityManager);
		UsuarioDAO.getInstance().persist(user10,entityManager);

		RevisionDAO.getInstance().persist(rev, entityManager);
		RevisionDAO.getInstance().persist(rev2, entityManager);
		RevisionDAO.getInstance().persist(rev3, entityManager);
		RevisionDAO.getInstance().persist(rev4, entityManager);
		RevisionDAO.getInstance().persist(rev5, entityManager);
		RevisionDAO.getInstance().persist(rev6, entityManager);
		RevisionDAO.getInstance().persist(rev7, entityManager);
		RevisionDAO.getInstance().persist(rev8, entityManager);
		RevisionDAO.getInstance().persist(rev9, entityManager);
		RevisionDAO.getInstance().persist(rev10, entityManager);

		TrabajoDAO.getInstance().persist(poster, entityManager);
		TrabajoDAO.getInstance().persist(poster2, entityManager);
		TrabajoDAO.getInstance().persist(poster3, entityManager);
		TrabajoDAO.getInstance().persist(poster4, entityManager);
		TrabajoDAO.getInstance().persist(resume, entityManager);
		TrabajoDAO.getInstance().persist(resume2, entityManager);
		TrabajoDAO.getInstance().persist(articulo, entityManager);
		TrabajoDAO.getInstance().persist(articulo2, entityManager);
		TrabajoDAO.getInstance().persist(articulo3, entityManager);
		TrabajoDAO.getInstance().persist(resume3, entityManager);
		entityManager.close();

	}


	/**
	 * Este método corresponde al inciso d-1.
	 */
	@Test
	public void getDatosUsuario() {
		EntityManager entityManager= emf.createEntityManager();
		Usuario user2= UsuarioDAO.getInstance().findById(2, entityManager);
		System.out.println(user2.getDni());
		entityManager.close();
	}
	
	/**
	 * Este método corresponde al inciso d-2.
	 */
	@Test
	public void BuscarTrabajosAsignados() {
		EntityManager entityManager= emf.createEntityManager();
		ArrayList <Trabajo> trabajos = new ArrayList <Trabajo>(UsuarioDAO.getInstance().findTrabajos(10, entityManager));
		for (int i = 0; i < trabajos.size(); i++) {
			System.out.println(trabajos.get(i).getNombre());
		}
		System.out.println("termina buscar trabajo");
		entityManager.close();

	}
	
	/**
	 * Este método corresponde al inciso d-3.
	 */
	@Test
	public void buscarRevisiones() {
		EntityManager entityManager= emf.createEntityManager();
		Calendar desde = new GregorianCalendar(2011,0,31);
		Calendar hasta = new GregorianCalendar(2013,0,31);
		ArrayList <Revision> trabajos = new ArrayList <Revision>(UsuarioDAO.getInstance().findRevisiones(10,desde,hasta, entityManager));
		for (int i = 0; i < trabajos.size(); i++) {
			System.out.println(trabajos.get(i).getId());
		}
		System.out.println("termina buscar Revisiones");
		entityManager.close();

	}
	
	/**
	 * Este método corresponde al inciso d-4.
	 */
	@Test
	public void buscarTrabajosAutores() {
		EntityManager entityManager= emf.createEntityManager();

		ArrayList <Trabajo> trabajos = new ArrayList <Trabajo>(UsuarioDAO.getInstance().findTrabajosAutores(10, entityManager));
		for (int i = 0; i < trabajos.size(); i++) {
			System.out.println(trabajos.get(i).getNombre());
		}
		System.out.println("termina buscar Trabajps Autores");
		entityManager.close();
	}
	
	/**
	 * Este método corresponde al inciso f.
	 */
	@Test
	public void buscarTrabajoByID() {
		EntityManager entityManager= emf.createEntityManager();
		Trabajo work = TrabajoDAO.getInstance().findById(7, entityManager);
		System.out.println(work.getNombre());
	}
	
	/**
	 * Este método corresponde al inciso f-v2(string).
	 */
	@Test
	public void buscarTrabajoByNombre() {
		EntityManager entityManager= emf.createEntityManager();
		Trabajo work = TrabajoDAO.getInstance().findByNombre("JavaScript", entityManager);
		System.out.println(work.getNombre());
	}
	
	/**
	 * Este método corresponde al inciso g.
	 */
	@Test
	public void buscarTrabajoNombreTema() {
		EntityManager entityManager= emf.createEntityManager();
		ArrayList <Trabajo> trabajos = new ArrayList <Trabajo>(TrabajoDAO.getInstance().findByUserTema(1, "Redes", entityManager));
		for (int i = 0; i < trabajos.size(); i++) {
			System.out.println(trabajos.get(i).getNombre() + "  Este trabajo pertenece a buscarTrabajoNombreTema!!!!!");
		}
		entityManager.close();
	}
	
}
