package com.lucas.workspace.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.workspace.domain.Post;

//REPOSITORIOS MONGO
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text,Date minDate,Date maxDate);
	
	//EXPLICAÇÃO DO QUERRY METHDO FULLSEARCH
	/*@Query("{ $and: [ 
    { date: {$gte: ?1} },  // Data maior ou igual a ?1
    { date: { $lte: ?2} }, // Data menor ou igual a ?2
    { $or: [               // Qualquer um dos seguintes campos pode conter o termo buscado:
        { 'title': { $regex: ?0, $options: 'i' } },   // Busca no título
        { 'body': { $regex: ?0, $options: 'i' } },    // Busca no corpo do post
        { 'comments.text': { $regex: ?0, $options: 'i' } }  // Busca dentro dos comentários
    ] } 
] }")*/
}
