package com.fgaaf.chair.repositories;


import com.fgaaf.chair.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAll();

  User findByUsername(String username);

  User findById(long id);

  User findByUsernameAndPassword(String username, String password);

}
