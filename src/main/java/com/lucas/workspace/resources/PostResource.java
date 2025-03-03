package com.lucas.workspace.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.workspace.domain.Post;
import com.lucas.workspace.resources.util.URL;
import com.lucas.workspace.services.PostService;

//CONTROLADOR REST É A CLASSE RESPONSAVEL POR RECEBER AS RESPOSTAS DAS REQUISIÇÕES
@RestController
//MAPEANDO A REQUISIÇÃO
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService post;

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findbyId(@PathVariable String id){
		Post  obj = post.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//ENDPOINT PARA BUSCA
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findbyTitle(@RequestParam (value ="text",defaultValue = "")String text){
		text = URL.decodeParam(text);
		List<Post> list = post.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	//ENDPOINT PARA BUSCA
		@GetMapping(value="/fullsearch")
		public ResponseEntity<List<Post>> fullSearch(
			@RequestParam (value ="text",defaultValue ="")String text,
			@RequestParam (value ="minDate",defaultValue = "")String minDate,
			@RequestParam (value ="maxDate",defaultValue = "")String maxDate){
			text = URL.decodeParam(text);
			Date min = URL.convertDate(minDate, new Date(0L));
			Date max = URL.convertDate(maxDate, new Date());
			List<Post> list = post.fullSearch(text, min, max);
			return ResponseEntity.ok().body(list);
		}
	


}
