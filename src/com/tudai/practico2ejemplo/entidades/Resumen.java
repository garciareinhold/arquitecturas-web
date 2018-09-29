package com.tudai.practico2ejemplo.entidades;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Resumen extends Trabajo {

	@Override
	public boolean aceptarEvaluador() {
		// TODO Auto-generated method stub
		return false;
	}


	
//	public Resumen(List<String>palabrasClave, String nombre,List <Usuario> autores) {
//		super(palabrasClave, nombre, autores);
//
//	}

}
