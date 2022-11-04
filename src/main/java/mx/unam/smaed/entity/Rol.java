package mx.unam.smaed.entity;

import java.util.Objects;

public class Rol {
	
	private Long id;
	
	private String clave;
	
	private String nombre;
	
	public Rol() {
	}

	public Rol(Long id) {
		this();
		setId(id);
	}
	
	public Rol(Long id, String clave, String nombre) {
		super();
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
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
	
	

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
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
		Rol other = (Rol) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
