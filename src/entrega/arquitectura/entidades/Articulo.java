package entrega.arquitectura.entidades;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Articulo extends Trabajo {



	@Override
	public boolean acreditaConocimientos(Usuario evaluador) {
		
		
		boolean retorno=true;
		List<String> temasTrabajo= this.getTemasConocimiento();
		List <String> temasEvaluador = evaluador.getTemasConocimiento();
		
		if(temasTrabajo.size()<=temasEvaluador.size()) {
			
			for (int i = 0; i < temasEvaluador.size(); i++) {
				if(!this.temasConocimiento.contains(temasEvaluador.get(i))) retorno = false;
			}
			
		}
		
		else {
			
			retorno = false;
			
		}
		
		return retorno;
	}
	
	/**
	 * Si el Resumen tiene menos de 3 revisiones (cupo máximo permitido)
	 * @return
	 */
	public boolean hayCupoRevision() {
		return (this.revisiones.size()<=2);
	}




}
