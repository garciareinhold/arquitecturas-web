package entrega.arquitectura.entidades;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Articulo extends Trabajo {

	@Override
	public boolean aceptaRevision(Usuario evaluador) {

		boolean retorno = true;
		List<Tema> temasTrabajo = this.getTemasConocimiento();
		List<Tema> temasEvaluador = evaluador.getTemasConocimiento();
		// este if contiene las tres condiciones que son necesarias para contemplar si
		// acredita o no los tema de conocimiento
		if (temasTrabajo.size() <= temasEvaluador.size()
				&& (this.hayCupoRevision() && (evaluador.tengoMasDeTresArt()))) {

			for (int i = 0; i < temasEvaluador.size(); i++) {
				if (!this.temasConocimiento.contains(temasEvaluador.get(i).getName()))
					retorno = false;
			}

		}

		else {

			retorno = false;

		}

		return retorno;
	}

	/**
	 * Si el Resumen tiene menos de 3 revisiones (cupo máximo permitido)
	 * 
	 * @return
	 */
	public boolean hayCupoRevision() {
		return (this.revisiones.size() <= 2);
	}

}
