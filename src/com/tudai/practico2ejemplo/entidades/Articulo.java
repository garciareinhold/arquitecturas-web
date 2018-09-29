package com.tudai.practico2ejemplo.entidades;

import javax.persistence.Entity;

@Entity
public class Articulo extends Trabajo {

	@Override
	public boolean aceptarEvaluador() {
		// TODO Auto-generated method stub
		return false;
	}



}
