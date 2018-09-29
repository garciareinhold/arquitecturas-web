package com.tudai.practico2ejemplo.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity

public abstract class Trabajo {
	@Id
	@GeneratedValue
	int id;
	List<String> palabrasClave ;
	String nombre;
	@ManyToMany(mappedBy="trabajos")
	List<Usuario> autores;
	@OneToMany(mappedBy="trabajo")
	List<Revision> revisiones;
	public Trabajo() {
		this.autores=new ArrayList<Usuario> ();
	}
	
	public Trabajo(List<String>palabrasClave, String nombre,List <Usuario> autores) {
		this.palabrasClave= new ArrayList<String>(palabrasClave);
		this.nombre=nombre;
		this.autores=new ArrayList<Usuario> (autores);

	}
	
	public abstract boolean aceptarEvaluador();
//	este metodo lo vamos a implementar en cada clase
	
	public boolean acreditaConocimientos(Usuario evaluador) {
		int iter=0;
		if(this.palabrasClave.size()>evaluador.getTemasConocimiento().size()) {
			return false;
		}
		while(iter<this.palabrasClave.size()) {
			String tema= this.palabrasClave.get(iter);
			if(!evaluador.getTemasConocimiento().contains(tema)) {
				return false;
			}
			iter++;
		}
		return true;
	};
	public void addAutor(Usuario autor) {
		autores.add(autor);
	}
	public void addAutores(List <Usuario> autores) {
		this.autores=new ArrayList<Usuario> (autores);
	}
}
