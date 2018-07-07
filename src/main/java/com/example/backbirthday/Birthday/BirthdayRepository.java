package com.example.backbirthday.Birthday;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

public interface BirthdayRepository extends CrudRepository<Birthday, Long> {
    Optional<Birthday> findById(long birthdayId);
    HttpStatus deleteById(long birthdayId);
}