package com.example.backbirthday.Gift;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

public interface GiftRepository extends CrudRepository<Gift, Long> {
    Optional<Gift> findById(long giftId);
    HttpStatus deleteById(long giftId);
    Optional<Gift> findByBirthdayId(Long birthdayId);
}