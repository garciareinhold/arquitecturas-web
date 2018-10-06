package entrega.arquitectura.entidades;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Resumen extends Trabajo {

	@Override
	public boolean acreditaConocimientos(Usuario evaluador) {
		return this.temasConocimiento.contains(evaluador.temasConocimiento); 	
	}


}
