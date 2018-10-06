package entrega.arquitectura.entidades;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Resumen extends Trabajo {
	@Override
	public boolean aceptaRevision(Usuario evaluador) {
		List<String> temasTrabajo= this.getTemasConocimiento();
		List <String> temasEvaluador = evaluador.getTemasConocimiento();
		//este if contiene las tres condiciones que son necesarias para contemplar si acredita o no los tema de conocimiento
		if(temasTrabajo.size()<=temasEvaluador.size()) {
			
			for (int i = 0; i < temasEvaluador.size(); i++) {
				if(!this.temasConocimiento.contains(temasEvaluador.get(i))) return false;
			}
			
		}
		return true; 	
	}
	

}
