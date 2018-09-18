package com.tudai.practico2ejemplo.entidades;

import java.util.List;

public class Resumen extends Trabajo {

	Usuario segundoEvaluador;
	Usuario tercerEvaluador;
	
	public Resumen(List<String>palabrasClave, String nombre, Usuario autor, Usuario evaluador, Usuario segundoEvaluador, Usuario tercerEvaluador) {
		super(palabrasClave, nombre, autor, evaluador);
		this.segundoEvaluador= segundoEvaluador;
		this.tercerEvaluador= tercerEvaluador;
	}
	@Override
	public void aceptaEvaluador(Usuario evaluador) {
		// TODO Auto-generated method stub
		
	}
}
