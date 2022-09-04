package br.com.hacking.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.JoinColumn;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hacking.entity.Usuario;
import br.com.hacking.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping 
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	/*Adicionar*/
	@PostMapping
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	/*Buscar por Id*/
	public Usuario buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(1L, "Usuario não encontrado"));
	}
	/*deletar*/
	public void deletarPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		usuarioRepository.deleteById(id);
	}
		
	
}

