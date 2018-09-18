package com.tudai.practico2ejemplo.entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Trabajo {

	List<String> palabrasClave ;
	String nombre;
	Usuario autor;
	Usuario evaluador;
	
	public Trabajo() {}
	
	public Trabajo(List<String>palabrasClave, String nombre, Usuario autor, Usuario evaluador) {
		this.palabrasClave= new ArrayList<String>(palabrasClave);
		this.nombre=nombre;
		this.autor=autor;
		this.evaluador= evaluador;
	}
	
	public abstract void aceptaEvaluador(Usuario evaluador);
}
