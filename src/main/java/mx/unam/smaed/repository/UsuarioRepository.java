package mx.unam.smaed.repository;

import java.util.ArrayList;
import java.util.List;

import mx.unam.smaed.entity.Usuario;

public class UsuarioRepository {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private static UsuarioRepository instance;
		
	private UsuarioRepository() {
	}
	
	public static UsuarioRepository getInstance() {
		if(instance == null) {
			instance = new UsuarioRepository();
		}
		
		return instance;
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuario.setId((long)usuarios.size()+1);
		usuarios.add(usuario);
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}

}
