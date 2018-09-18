package com.tudai.practico2ejemplo.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

public abstract class Trabajo {

	List<String> palabrasClave ;
	String nombre;
	@ManyToMany
	List<Usuario> autores;
	
	public Trabajo() {
		this.autores=new ArrayList<Usuario> ();
	}
	
	public Trabajo(List<String>palabrasClave, String nombre,List <Usuario> autores) {
		this.palabrasClave= new ArrayList<String>(palabrasClave);
		this.nombre=nombre;
		this.autores=new ArrayList<Usuario> (autores);

	}
	
	public abstract void aceptaEvaluador(Usuario evaluador);
	public void addAutor(Usuario autor) {
		autores.add(autor);
	}
	public void addAutores(List <Usuario> autores) {
		this.autores=new ArrayList<Usuario> (autores);
	}
}
