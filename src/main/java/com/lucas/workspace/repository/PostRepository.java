package com.lucas.workspace.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucas.workspace.domain.Post;

//REPOSITORIOS MONGO
@Repository
public interface PostRepository extends MongoRepository<Post ,String>{

}
