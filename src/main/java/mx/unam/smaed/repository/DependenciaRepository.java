package mx.unam.smaed.repository;

import java.util.ArrayList;
import java.util.List;

import mx.unam.smaed.entity.Dependencia;

public class DependenciaRepository {
	
	List<Dependencia> dependencias = new ArrayList<Dependencia>();
	private static DependenciaRepository instance;
	
	
	private DependenciaRepository() {
	}
	
	public static DependenciaRepository getInstance() {
		if(instance == null) {
			instance = new DependenciaRepository();
			instance.inicializaDatos();
		}
		
		return instance;
	}
	
	public List<Dependencia> getDependencias() {
		return dependencias;
	}
	
	public Dependencia getDependencia(Long id) {
		return dependencias.stream()
			.filter(d -> d.getId() == id)
			.findFirst().orElse(null);
	}
	
	public void agregarDependencia(Dependencia dependencia) {
		dependencia.setId((long)(dependencias.size()+1));
		dependencias.add(dependencia);
	}

	private void inicializaDatos() {
		Dependencia fa = new Dependencia(1L);
		fa.setNombre("Facultad de Arquitectura");
		fa.setSiglas("FA");
		fa.setClave("001");
		dependencias.add(fa);
		
		Dependencia fad = new Dependencia(2L);
		fad.setNombre("Facultad de Artes y Diseño");
		fad.setSiglas("FAD");
		fad.setClave("002");
		dependencias.add(fad);

		
		Dependencia fc = new Dependencia(3L);
		fc.setNombre("Facultad de Ciencias");
		fc.setSiglas("FC");
		fc.setClave("003");
		dependencias.add(fc);
	}

}
