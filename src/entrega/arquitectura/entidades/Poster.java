package entrega.arquitectura.entidades;

import javax.persistence.Entity;

@Entity
public class Poster extends Trabajo{

//	@Override
//	public boolean acreditaConocimientos(Usuario evaluador) {
//		return this.palabrasClave.contains(evaluador.temasConocimiento); 	
//	}

	@Override
	public boolean aceptarEvaluador() {
		Revision revision = new Revision();
	
		return false;
	}


}
