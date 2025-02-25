package com.lucas.workspace.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.lucas.workspace.domain.User;

//REPOSITORIOS MONGO
@Repository
public interface UserRepository extends MongoRepository<User ,String>{

}
