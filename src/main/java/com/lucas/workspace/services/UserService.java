package com.lucas.workspace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.workspace.domain.User;
import com.lucas.workspace.repository.UserRepository;

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
	
}
