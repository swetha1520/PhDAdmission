package com.example.springboot.repository;






import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByusername(String username);

	User deleteByusername(String username);

	User findByEmailAndPassword(String email, String password);


	

}

