package entrega.arquitectura.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="TABLA_Usuarios")
public class Usuario {
	@Id
	int dni;
	@Column(nullable = false)
	String nombre;
	@Column(nullable = false)
	String apellido;
	@Column(nullable = false)
	boolean esExperto;
	@Column(nullable = false)
	boolean esEvaluador;
	@Column(nullable = false)
	String lugarDeTrabajo;
	@OneToMany(mappedBy="evaluador", orphanRemoval=true)
	List <Revision>revision;
	@ManyToMany(cascade= CascadeType.ALL)
	List <Trabajo> trabajos;
//	
//	List<String> temasConocimiento;
	public Usuario() {
		this.revision= new ArrayList<Revision>();
		this.trabajos=new ArrayList<Trabajo>();
//		this.temasConocimiento= new ArrayList();
	}
	public Usuario(String nombre, String apellido, int dni, boolean esExperto, boolean esEvaluador,
			String lugarDeTrabajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.esExperto = esExperto;
		this.esEvaluador = esEvaluador;
		this.lugarDeTrabajo = lugarDeTrabajo;
//		this.revision= new ArrayList();
//		this.trabajos=new ArrayList();
//		this.temasConocimiento= new ArrayList();
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", esExperto=" + esExperto
				+ ", esEvaluador=" + esEvaluador + ", lugarDeTrabajo=" + lugarDeTrabajo + ", revision=" + revision
				+ ", trabajos=" + trabajos + "]";
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isEsExperto() {
		return esExperto;
	}
	public void setEsExperto(boolean esExperto) {
		this.esExperto = esExperto;
	}
	public boolean isEsEvaluador() {
		return esEvaluador;
	}
	public void setEsEvaluador(boolean esEvaluador) {
		this.esEvaluador = esEvaluador;
	}
	public String getLugarDeTrabajo() {
		return lugarDeTrabajo;
	}
	public void setLugarDeTrabajo(String lugarDeTrabajo) {
		this.lugarDeTrabajo = lugarDeTrabajo;
	}
	public void addRevision(Revision review) {
		this.revision.add(review);
	}
	public void addTrabajos(Trabajo work) {
		this.trabajos.add(work);
	}
//	public List<Revision> getRevision() {
//		return revision;
//	}
//	public void setRevision(List<Revision> revision) {
//		this.revision = revision;
//	}
//	public List<Trabajo> getTrabajos() {
//		return trabajos;
//	}
//	public void setTrabajos(List<Trabajo> trabajos) {
//		this.trabajos = trabajos;
//	}
//	public void setTemasConocimiento(List<String> temasConocimiento) {
//		this.temasConocimiento = temasConocimiento;
//	}


//		public List<String> getTemasConocimiento() {
//			return new ArrayList<String>(this.temasConocimiento);
//		}
	}
