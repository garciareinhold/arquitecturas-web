package entrega.arquitectura.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.Main;

import entrega.arquitectura.entidades.Revision;
import entrega.arquitectura.entidades.Trabajo;
import entrega.arquitectura.entidades.Usuario;
import entrega.arquitectura.servicios.servicioGeneral;

public class SistemaCacic {

	List <Usuario> participantes;
	List <Trabajo> trabajosCongreso;

	public SistemaCacic() {
		this.participantes= new ArrayList <Usuario>();
		this.trabajosCongreso= new ArrayList <Trabajo>();
	};

	public void addTrabajosCongreso(Trabajo trabajo) {
		this.trabajosCongreso.add(trabajo);
	}

	public void addParticipante(Usuario user) {
		this.participantes.add(user);
	}

	public void asignarTrabajoEvaluador(int dni, Trabajo trabajo) {
		//asigna el trabajo a un evaluador
		List<Usuario> evaluadores= this.getEvaluadoresCalificados(trabajo);
		for (int i = 0; i < evaluadores.size(); i++) {
			if(evaluadores.get(i).getDni()==dni) {
				Revision review = new Revision();
				review.setEvaluador(evaluadores.get(i));
				review.setTrabajo(trabajo);
				Calendar fechaRevision = new GregorianCalendar(2013,0,31);
				review.setFechaRevision(fechaRevision);
				evaluadores.get(i).addRevision(review);
			}
			
		}
	}

	public List<Usuario> getEvaluadoresCalificados(Trabajo trabajo){
		List<Usuario> retorno = new ArrayList<Usuario>();
		List<String> temasTrabajo= trabajo.getTemasConocimiento();
		for (int i = 0; i < this.participantes.size(); i++) {
			Usuario user= this.participantes.get(i);
			if(trabajo.evaluadorHabilitado(user) && trabajo.aceptaRevision(user)) {
				retorno.add(user);
			}
		}
		return retorno;
	}

	public List<Trabajo> getTrabajosDisponiblesEvaluador(int dni){
		List<Trabajo> retorno = new ArrayList<Trabajo>();
		Usuario evaluador = null;
		for (int i = 0; i < this.participantes.size(); i++) {
			if(this.participantes.get(i).getDni()==dni) {
				evaluador = this.participantes.get(i);
				for (int x = 0; x < this.trabajosCongreso.size(); x++) {
					Trabajo trabajo=trabajosCongreso.get(x);
					if(trabajo.evaluadorHabilitado(evaluador) && trabajo.aceptaRevision(evaluador)) {
						retorno.add(trabajo);
					}
				}
			}
		}
		return retorno;
	}

	public List<Trabajo> getTrabajosAsignados(int dni){
		for (int i = 0; i < this.participantes.size(); i++) {
			if(this.participantes.get(i).getDni()==dni) {
				return this.participantes.get(i).getTrabajos();
			}
		}
		return null;
	}

	public boolean esExperto(int dni) {
		for (int i = 0; i < this.participantes.size(); i++) {
			if(this.participantes.get(i).getDni()==dni) {
				return this.participantes.get(i).isEsExperto();
			}
		}
		return false;
	}

}
