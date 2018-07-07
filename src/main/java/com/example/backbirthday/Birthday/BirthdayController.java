package com.example.backbirthday.Birthday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BirthdayController {

    @Autowired
    private BirthdayRepository birthdayRepository;

    @GetMapping("/api/birthdays")
    public Iterable<Birthday> findAllBirthdays () {
        return birthdayRepository.findAll ();
    }

    @GetMapping("/api/birthdays/{birthdayId}")
    public Optional<Birthday> findBirthdayById(@PathVariable Long birthdayId) {
        return birthdayRepository.findById(birthdayId);
    }

    @DeleteMapping("api/birthdays/{birthdayId}")
    public HttpStatus deleteBirthdayById(@PathVariable Long birthdayId) {
        birthdayRepository.deleteById(birthdayId);
        return HttpStatus.OK;
    }

    @PostMapping("/api/birthdays")
    public Birthday createNewBirthday(@RequestBody Birthday newBirthday) {
        return birthdayRepository.save(newBirthday);
    }

    @PatchMapping("/api/birthdays/{birthdayId}")
    public Birthday updateBirthdayById(@PathVariable Long birthdayId, @RequestBody Birthday birthdayRequest) {
        Birthday birthdayFromDb = birthdayRepository.findById(birthdayId).get();

        birthdayFromDb.setBirthdayname(birthdayRequest.getBirthdayname());
        birthdayFromDb.setFirstName(birthdayRequest.getFirstName());
        birthdayFromDb.setLastName(birthdayRequest.getLastName());
        birthdayFromDb.setEmail(birthdayRequest.getEmail());
        birthdayFromDb.setAboutMe(birthdayRequest.getAboutMe());
        birthdayFromDb.setPassword(birthdayRequest.getPassword());

        return birthdayRepository.save(birthdayFromDb);
    }
}



