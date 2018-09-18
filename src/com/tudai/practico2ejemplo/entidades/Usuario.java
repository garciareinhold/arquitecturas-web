package com.tudai.practico2ejemplo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	String nombre;
	String apellido;
	Long dni;
	List <Revision>revision;
	boolean esExperto;
	List <Trabajo> trabajos;
	boolean esEvaluador;
	String lugarDeTrabajo;
	List<String> temasConocimiento;
		public Usuario() {
			
		}
		public Usuario(String nombre, String apellido, Long dni, boolean esExperto, boolean esEvaluador,
				String lugarDeTrabajo) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.esExperto = esExperto;
			this.esEvaluador = esEvaluador;
			this.lugarDeTrabajo = lugarDeTrabajo;
			this.revision= new ArrayList();
			this.trabajos=new ArrayList();
			this.temasConocimiento= new ArrayList();
		}
	}
