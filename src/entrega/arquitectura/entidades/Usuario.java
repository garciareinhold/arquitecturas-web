package entrega.arquitectura.entidades;

import java.util.ArrayList;
import java.util.Arrays;
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
	@OneToMany(mappedBy="evaluador")
	List <Revision>revision;
	@ManyToMany(cascade= CascadeType.ALL)
	List <Trabajo> trabajos;
	@Column(nullable = true)
	String temasConocimiento;
	public Usuario() {
		this.revision= new ArrayList<Revision>();
		this.trabajos=new ArrayList<Trabajo>();
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
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", esExperto=" + esExperto
				+ ", esEvaluador=" + esEvaluador + ", lugarDeTrabajo=" + lugarDeTrabajo + ", revision=" + revision
				+ ", trabajos=" + trabajos + ", temas de conocimiento="+ temasConocimiento +"]";
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
	public List<String> getTemasConocimiento() {
		List <String> retorno= new ArrayList<String>(Arrays.asList(this.temasConocimiento.split(" ")));  
		return retorno;
	}
	public void setTemasConocimiento(String temasConocimiento) {
		this.temasConocimiento = temasConocimiento;
	}
	/**
	 * Este metodo devuelve true si en las revisiones contiene mas de tres articulos 
	 * @return 
	 */
	public boolean tengoMasDeTresArt() {
		int count=0;
		for (int i = 0; i < this.revision.size(); i++) {
			Trabajo work=revision.get(i).getTrabajo();
			if(work instanceof Articulo) {
				count++;
			}
		}
		if(count<3) {
			return true;
		}
		return false;
	}
	public List<Trabajo> getTrabajos() {
		return trabajos;
	}
	
	}
