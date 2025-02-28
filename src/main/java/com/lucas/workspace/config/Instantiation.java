package com.lucas.workspace.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucas.workspace.domain.Post;
import com.lucas.workspace.domain.User;
import com.lucas.workspace.dto.AuthorDto;
import com.lucas.workspace.repository.PostRepository;
import com.lucas.workspace.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post ps1 = new Post(null,sdf.parse("20/08/2024"),"Partiu viagem","Boa viagem mano!",new AuthorDto(maria));
		Post ps2 = new Post(null,sdf.parse("01/02/2025"),"Bom dia","Acordei feliz hoje!",new AuthorDto(maria));
		
		
		postRepository.saveAll(Arrays.asList(ps1,ps2));
		
		maria.getPosts().addAll(Arrays.asList(ps1,ps2));
		userRepository.saveAll(Arrays.asList(maria));
		
		
	}

}
