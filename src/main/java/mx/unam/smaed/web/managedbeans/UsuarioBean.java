package mx.unam.smaed.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import mx.unam.smaed.entity.Dependencia;
import mx.unam.smaed.entity.Rol;
import mx.unam.smaed.entity.Usuario;
import mx.unam.smaed.repository.DependenciaRepository;
import mx.unam.smaed.repository.RolRepository;
import mx.unam.smaed.repository.UsuarioRepository;

@Named
@SessionScoped
public class UsuarioBean extends AbstractBean implements Serializable {
	
	private static final long serialVersionUID = -2657214892548098614L;

	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String correo;
	
	private String clave;
	
	private String contrasena;
	
	private Long dependenciaId;
	
	private Long rolId;
	
	private UsuarioRepository usuarioRepository;
	
	private DependenciaRepository dependenciaRepository;
	
	private RolRepository rolRepository;

	
	public UsuarioBean() {
		usuarioRepository = UsuarioRepository.getInstance();
		dependenciaRepository = DependenciaRepository.getInstance();
		rolRepository = RolRepository.getInstance();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public Long getDependenciaId() {
		return dependenciaId;
	}


	public void setDependenciaId(Long dependenciaId) {
		this.dependenciaId = dependenciaId;
	}

	public Long getRolId() {
		return rolId;
	}


	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}


	public List<Usuario> getUsuarios() {
		return usuarioRepository.getUsuarios();
	}


	public SelectItem[] getDependencias() {
		List<Dependencia> dependencias = dependenciaRepository.getDependencias();
		SelectItem[] selectItems = new SelectItem[dependencias.size()];
		for(int i=0; i<dependencias.size(); i++) {
			selectItems[i] = new SelectItem(dependencias.get(i).getId(), 
					dependencias.get(i).getNombre());
		}
		
		return selectItems;
	}
	
	public SelectItem[] getRoles() {
		List<Rol> roles = rolRepository.getRoles();
		SelectItem[] selectItems = new SelectItem[roles.size()];
		for(int i=0; i<roles.size(); i++) {
			selectItems[i] = new SelectItem(roles.get(i).getId(),
				roles.get(i).getNombre());
		}
		return selectItems;
	}


	public void agregarUsuarioAjax(AjaxBehaviorEvent event) throws AbortProcessingException {
		
		System.out.println("AGREAGAR USUARIO");
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellidoPaterno(apellidoPaterno);
		usuario.setApellidoMaterno(apellidoMaterno);
		usuario.setClave(clave);
		usuario.setCorreo(correo);
		
		Dependencia dependencia = dependenciaRepository.getDependencia(dependenciaId);
		usuario.setDependencia(dependencia);
		
		System.out.println("ADDING DEP: "+dependencia);
		
		Rol rol = rolRepository.getRol(rolId);
		usuario.setRol(rol);
		
		System.out.println("Adding rol: "+rol);
		
		System.out.println("Adding usuario: "+usuario);
		
		usuarioRepository.agregarUsuario(usuario);
		clear();
		
		System.out.println("AGREGADO: "+ usuario);
	}
	
	private void clear() {
		nombre = "";
		apellidoPaterno = "";
		apellidoMaterno = "";
		clave = "";
		correo = "";
		dependenciaId = 0L;
		rolId = 0L;
	}
	
	
	
}
