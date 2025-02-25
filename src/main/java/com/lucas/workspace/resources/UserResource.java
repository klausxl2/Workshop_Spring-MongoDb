package com.lucas.workspace.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.workspace.domain.User;
import com.lucas.workspace.services.UserService;

//CONTROLADOR REST É A CLASSE RESPONSAVEL POR RECEBER AS RESPOSTAS DAS REQUISIÇÕES
@RestController
//MAPEANDO A REQUISIÇÃO
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService userservice;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userservice.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
}
