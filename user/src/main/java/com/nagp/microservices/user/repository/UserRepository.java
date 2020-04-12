package com.nagp.microservices.user.repository;

import com.nagp.microservices.user.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

}
