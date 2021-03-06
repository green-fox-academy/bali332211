package com.greenfoxacademy.springstart.repositories;

import com.greenfoxacademy.springstart.models.Url;
import com.greenfoxacademy.springstart.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long> {

    List<Url> findAll();
    Url findByAlias(String alias);
    List<Url> findAllByUser(User user);

}
