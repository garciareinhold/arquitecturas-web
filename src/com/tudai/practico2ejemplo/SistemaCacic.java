package com.tudai.practico2ejemplo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.tudai.practico2ejemplo.entidadesSinAnotaciones.*;
import com.tudai.practico2ejemplo.entidades.Trabajo;
import com.tudai.practico2ejemplo.entidades.Usuario;

import servicios.servicioGeneral;

public class SistemaCacic {
	List <Trabajo> trabajos;
	List<Usuario>evaluadores;
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-especial-arqWeb");
		EntityManager entitymanager = emf.createEntityManager();
//		entitymanager.getTransaction( ).begin( );


		entitymanager.close();
		emf.close();
//		System.out.println(result.getNombreEquipo());
	}
}
