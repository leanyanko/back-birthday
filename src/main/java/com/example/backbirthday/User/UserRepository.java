package com.example.backbirthday.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(long userId);
    HttpStatus deleteById(long userId);
}