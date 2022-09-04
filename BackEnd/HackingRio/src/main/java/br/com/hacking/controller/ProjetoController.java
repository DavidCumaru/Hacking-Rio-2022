package br.com.hacking.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hacking.entity.Projeto;
import br.com.hacking.repository.ProjetoRepository;

@CrossOrigin
@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping 
	public List<Projeto> listar() {
		return projetoRepository.findAll();
	}
	
	@PostMapping
	/*Adicionar*/
	public Projeto adicionar(@RequestBody Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	/*Buscar por Id*/
	public Projeto buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Projeto> projeto = projetoRepository.findById(id);
		return projeto.orElseThrow(() -> new ObjectNotFoundException(1L, "Projeto não encontrado"));
	}
	/*deletar*/
	public void deletarPorId(Integer id) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
		projetoRepository.deleteById(id);
	}
		
}
