package mx.unam.smaed.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;
import mx.unam.smaed.entity.Dependencia;
import mx.unam.smaed.repository.DependenciaRepository;

@Named
@SessionScoped
public class DependenciaBean implements Serializable {

	private static final long serialVersionUID = 8241733296573317051L;
	
	private String nombre;
	private String clave;
	private String siglas;

	private DependenciaRepository dependenciaRepository;
	
	public DependenciaBean() {
		dependenciaRepository = DependenciaRepository.getInstance();
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

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	
	public List<Dependencia> getDependencias(){
		return dependenciaRepository.getDependencias();
	}
	
	public void agregarDependenciaAjax(AjaxBehaviorEvent event) throws AbortProcessingException {
		Dependencia dependencia = new Dependencia();
		dependencia.setNombre(nombre);
		dependencia.setClave(clave);
		dependencia.setSiglas(siglas);
		
		dependenciaRepository.agregarDependencia(dependencia);
		
		clear();
		
		System.out.println("AGREGADO: "+ dependencia);
	}
	
	private void clear() {
		nombre = "";
		clave = "";
		siglas = "";
	}
	
}
