package br.com.hacking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hacking.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	List<Login> findByEmail(String email);
	
//	Login findByEmail2(String email);
}
