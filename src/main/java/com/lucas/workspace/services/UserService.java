package com.lucas.workspace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.workspace.domain.User;
import com.lucas.workspace.dto.UserDto;
import com.lucas.workspace.repository.UserRepository;
import com.lucas.workspace.services.exception.ObjectNotFoundException;

//INDICANDO QUE É UM SERVIÇO
@Service
public class UserService {
	//INJETANDO DEPENDÊNCIAS
	@Autowired
	UserRepository userRepository;
	
	//RETORNANDO A LISTA DE USUÁRIOS
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDto(UserDto user) {
		return new User(user.getId(),user.getEmail(),user.getEmail());
	}
}
