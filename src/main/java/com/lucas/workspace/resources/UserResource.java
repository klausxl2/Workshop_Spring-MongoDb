package com.lucas.workspace.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.workspace.domain.Post;
import com.lucas.workspace.domain.User;
import com.lucas.workspace.dto.UserDto;
import com.lucas.workspace.services.UserService;

//CONTROLADOR REST É A CLASSE RESPONSAVEL POR RECEBER AS RESPOSTAS DAS REQUISIÇÕES
@RestController
//MAPEANDO A REQUISIÇÃO
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService userservice;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> list = userservice.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDto> findbyId(@PathVariable String id){
		User user = userservice.findById(id);
		return ResponseEntity.ok().body(new UserDto(user));
	}
	
	//ENDPOINT PARA INSERT 
	@PostMapping
	public ResponseEntity<UserDto> findAll(@RequestBody UserDto user){
		User obj = userservice.fromDto(user);
		obj = userservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDto> delete(@PathVariable String id){
		userservice.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto user,@PathVariable String id){
		User obj = userservice.fromDto(user);
		obj.setId(id);
		obj = userservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/{id}/posts")
	public ResponseEntity<List<Post>> findPost(@PathVariable String id){
		User user = userservice.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
	
}
