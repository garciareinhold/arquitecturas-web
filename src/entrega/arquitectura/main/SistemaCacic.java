package entrega.arquitectura.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.Main;

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
		return null;
	}
	
	public List<Trabajo> getTrabajosAsignados(int dni){
		return null;
	}
	
	public boolean esExperto(int dni) {
		return false;
	}
	
}
