package mx.unam.smaed.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;
import mx.unam.smaed.entity.Rol;
import mx.unam.smaed.repository.RolRepository;

@Named
@SessionScoped
public class RolBean implements Serializable {
	
	private static final long serialVersionUID = 4070863338326015448L;

	private String nombre;
	private String clave;
	
	private RolRepository rolRepository;
	
	public RolBean() {
		rolRepository = RolRepository.getInstance();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Rol> getRoles(){
		return rolRepository.getRoles();
	}
	
	public void agregarRolAjax(AjaxBehaviorEvent event) throws AbortProcessingException {
		Rol rol = new Rol();
		rol.setNombre(nombre);
		rol.setClave(clave);
		
		rolRepository.agregarRol(rol);
		clear();
		
		System.out.println("AGREGADO: "+ rol);
	}
		
	private void clear() {
		nombre = "";
		clave = "";
	}
	
}
