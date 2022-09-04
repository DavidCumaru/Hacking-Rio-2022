package br.com.hacking.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hacking.entity.Login;
import br.com.hacking.repository.LoginRepository;

@CrossOrigin
@RestController
@RequestMapping("/logins")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping 
	public List<Login> listar() {
		return loginRepository.findAll();
	}
	
	/*Adicionar*/
	@PostMapping
	public Login adicionar(@RequestBody Login login) {
		return loginRepository.save(login);
	}
	
	@GetMapping(value = "{email}, {senha}")
//	public Login findByEmail2(@PathVariable String email) {
//		Login login = new Login();
//		return login;
//	}
	
	public ResponseEntity<List<Login>> findByEmail(@PathVariable String email) {
		Login login = new Login();
		List<Login> lista = loginRepository.findByEmail(email);
		login = lista.get(0);
		if(login.getEmail() == email) {
			login.getId();
		}
		else {
			//jogar pra rota de erro
		}
		return new ResponseEntity<List<Login>>(loginRepository.findByEmail(email), HttpStatus.OK);
	}

	
	
//	public Login buscarPorEmail(@PathVariable String email, String senha) throws ObjectNotFoundException{
//		
//		if(login.getEmail() == email & login.getSenha() == senha ) {
//			return login;
//		}
//		else {
//			new ObjectNotFoundException(1L, "Login não encontrado");
//		}
//		
//	}
	
	
	/*Buscar por Id*/
	public Login buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Login> login = loginRepository.findById(id);
		return login.orElseThrow(() -> new ObjectNotFoundException(1L, "Login não encontrado"));
	}
	/*deletar*/
	public void deletarPorId(Integer id) {
		Optional<Login> login = loginRepository.findById(id);
		loginRepository.deleteById(id);
	}
		
}

