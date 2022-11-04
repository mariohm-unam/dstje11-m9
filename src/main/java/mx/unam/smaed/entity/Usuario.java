package mx.unam.smaed.entity;

import java.util.Objects;
import java.util.regex.Pattern;

public class Usuario {

	// Un dígito + minúscula + mayúscula + símbolo , entre 8 y 16 caracteres
	private static final Pattern PATRON_CONTRASENA = 
		Pattern.compile(
			"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,16}$"
		);
	
	private Long id;
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String correo;
	
	private String clave;
	
	
	private String contrasena;
	
	private Dependencia dependencia;
	
	private Rol rol;

	
	
	public Usuario() {
	}
	
	

	public Usuario(Long id) {
		this();
		setId(id);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id >= 0) {
			this.id = id;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null) {
			this.nombre = nombre;			
		}
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		if(apellidoPaterno != null) {
			this.apellidoPaterno = apellidoPaterno;
		}
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		if(apellidoMaterno != null) {
			this.apellidoMaterno = apellidoMaterno;
		}
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
		if(contrasena != null) {
			this.contrasena = contrasena;
		}
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}	
	
	
	
	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + " " + apellidoPaterno
				+ " " + apellidoMaterno + ", correo: "+correo+", clave=" + clave + ", dependencia=" + dependencia + "]";
	}

	
	private String generaNuevaContrasena() {
		// TODO: Generar contraseña segura
		return "rxoSL>WN)7Sp0CPtT6,g";
	}
	
	public void restablecerContrasena() {
		//GenerarNuevaContrasena
		String nuevaContrasena = generaNuevaContrasena();
		setContrasena(nuevaContrasena);
	}


}