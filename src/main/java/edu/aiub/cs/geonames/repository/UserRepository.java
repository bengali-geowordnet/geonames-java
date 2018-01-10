package edu.aiub.cs.geonames.repository;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 */

import edu.aiub.cs.geonames.model.base.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query

public interface UserRepository extends CrudRepository<User, Long> {
    User findByToken(String token);
}
