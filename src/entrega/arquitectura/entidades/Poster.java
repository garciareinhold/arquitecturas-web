package entrega.arquitectura.entidades;

import javax.persistence.Entity;

@Entity
public class Poster extends Trabajo{

	@Override
	public boolean acreditaConocimientos(Usuario evaluador) {
		return this.temasConocimiento.contains(evaluador.temasConocimiento); 	
	}



}
