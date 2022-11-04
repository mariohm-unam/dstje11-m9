package mx.unam.smaed.entity;

import java.util.Objects;

public class Dependencia {
	
	private Long id;
	
	private String nombre;
	
	private String siglas;
	
	private String clave;
	
	public Dependencia() {
	}

	public Dependencia(Long id, String nombre, String siglas, String clave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.siglas = siglas;
		this.clave = clave;
	}



	public Dependencia(Long id) {
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

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Dependencia [id=" + id + ", nombre=" + nombre + ", siglas=" + siglas + ", clave=" + clave + "]";
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
		Dependencia other = (Dependencia) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
