package mx.unam.smaed.repository;

import java.util.ArrayList;
import java.util.List;

import mx.unam.smaed.entity.Rol;

public class RolRepository {
	
	private List<Rol> roles = new ArrayList<Rol>();
	private static RolRepository instance;
	
	private RolRepository() {
	}
	
	public static RolRepository getInstance() {
		if(instance == null) {
			instance = new RolRepository();
			instance.inicializaDatos();
		}
		
		return instance;
	}
	
	
	public List<Rol> getRoles() {
		return roles;
	}


	public Rol getRol(Long id) {
		
		return roles.stream()
			.filter(r -> r.getId() == id)
			.findFirst().orElse(null);
	}
	
	public void agregarRol(Rol rol) {
		rol.setId((long)roles.size()+1);
		roles.add(rol);
	}

	private void inicializaDatos() {
		Rol rolAdmin = new Rol(1L);
		rolAdmin.setClave("ADMIN");
		rolAdmin.setNombre("Administrador");
		roles.add(rolAdmin);
		
		Rol rolSupervisor = new Rol(2L);
		rolSupervisor.setClave("SUPERVISOR");
		rolSupervisor.setNombre("Supervisor");
		roles.add(rolSupervisor);
		
		Rol rolResponsableTIC = new Rol(3L);
		rolResponsableTIC.setClave("RESPONSABLE_TIC");
		rolResponsableTIC.setNombre("Responsable TIC");
		roles.add(rolResponsableTIC);

	}

}
