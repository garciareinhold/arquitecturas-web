package com.tudai.practico2ejemplo.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="TABLA_Usuarios")
public class Usuario {
	@Id
	Long dni;
	@Column(nullable = false)
	String nombre;
	@Column(nullable = false)
	String apellido;
	@Column(nullable = false)
	boolean esExperto;
	@Column(nullable = false)
	boolean esEvaluador;
	@Column(nullable = false)
	String lugarDeTrabajo;
	@OneToMany(mappedBy="evaluador")
	List <Revision>revision;
	@ManyToMany
	List <Trabajo> trabajos;
	
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
		public List<String> getTemasConocimiento() {
			return new ArrayList<String>(this.temasConocimiento);
		}
	}
