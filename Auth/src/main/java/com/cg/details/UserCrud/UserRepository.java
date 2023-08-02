package com.cg.details.UserCrud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User1, Integer>{
	
	User1 findByUsername(String username);

}
