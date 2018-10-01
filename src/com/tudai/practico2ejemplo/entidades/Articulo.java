package com.tudai.practico2ejemplo.entidades;

import javax.persistence.Entity;

@Entity
public class Articulo extends Trabajo {

	@Override
	public boolean aceptarEvaluador() {
		return false;
	}

}
