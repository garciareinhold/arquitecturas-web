package entrega.arquitectura.test;

import org.junit.Test;

import entrega.arquitectura.entidades.Usuario;
import entrega.arquitectura.servicios.UsuarioDAO;

public class TestEntrega {
 @Test
 public void cargarUsuarios() {
	 Usuario user = new Usuario();
	 user.setDni(31702123);
	 user.setApellido("Guerra");
	 user.setNombre("Maximiliano");
	 user.setEsEvaluador(true);
	 user.setEsExperto(true);
	 user.setLugarDeTrabajo("Municipalidad De Tandil");
	 UsuarioDAO.getInstance().persist(user);
 }
}
