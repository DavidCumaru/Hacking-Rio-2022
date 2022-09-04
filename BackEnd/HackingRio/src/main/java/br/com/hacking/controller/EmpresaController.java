package br.com.hacking.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hacking.entity.Empresa;
import br.com.hacking.repository.EmpresaRepository;

@CrossOrigin
@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping 
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}
	
	/*Adicionar*/
	public Empresa adicionar(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	/*Buscar por Id*/
	@GetMapping(value = "{id}")
	public Empresa buscarPorId(@PathVariable Integer id) throws ObjectNotFoundException{
		Optional<Empresa> empresa = empresaRepository.findById(id);
		return empresa.orElseThrow(() -> new ObjectNotFoundException(1L, "Empresa não encontrado"));
	}
	/*deletar*/
	public void deletarPorId(Integer id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		empresaRepository.deleteById(id);
	}
		
}

