package entrega.arquitectura.entidades;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Poster extends Trabajo {
	@Override
	public boolean aceptaRevision(Usuario evaluador) {
		List<Tema> temasEvaluador = evaluador.getTemasConocimiento();
		for (int i = 0; i < temasEvaluador.size(); i++) {
			if (this.temasConocimiento.contains(temasEvaluador.get(i).getName())) {
				return true;
			}
		}
		return false;
	}
}
