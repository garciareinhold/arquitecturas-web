package entrega.arquitectura.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity

public abstract class Trabajo {
	@Id
	@GeneratedValue
	int id;
	@Column(nullable = true)
	String temasConocimiento ;
	@Column(nullable = false)
	String nombre;
	@ManyToMany(mappedBy="trabajos")
	List<Usuario> autores;
	@OneToMany(mappedBy="trabajo")
	List<Revision> revisiones;
	
	public Trabajo() {
		this.autores=new ArrayList<Usuario> ();
		this.revisiones=new ArrayList<Revision> ();
	}
	
	@Override
	public String toString() {
		return "Trabajo [id=" + id + ", nombre=" + nombre + ", autores=" + autores + ", revisiones=" + revisiones + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTemasConocimiento(String temas) {
		this.temasConocimiento = temas;
	}
	
	public String getTemasConocimiento(String temas) {
		return this.temasConocimiento = temas;
	}

	public abstract boolean aceptarEvaluador();
////	este metodo lo vamos a implementar en cada clase
//	
//	public boolean acreditaConocimientos(Usuario evaluador) {
//		int iter=0;
//		if(this.palabrasClave.size()>evaluador.getTemasConocimiento().size()) {
//			return false;
//		}
//		while(iter<this.palabrasClave.size()) {
//			String tema= this.palabrasClave.get(iter);
//			if(!evaluador.getTemasConocimiento().contains(tema)) {
//				return false;
//			}
//			iter++;
//		}
//		return true;
//	};
	public void addAutor(Usuario autor) {
		autores.add(autor);
	
	}	public void addReview(Revision review) {
		this.revisiones.add(review);
	}
//	public void addAutores(List <Usuario> autores) {
//		this.autores=new ArrayList<Usuario> (autores);
//	}
}
