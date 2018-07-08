package com.example.backbirthday.Birthday;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
public class BirthdayController {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private Date dateOfCreation;

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
        dateOfCreation = birthdayRequest.getEnding();

        birthdayFromDb.setCreator (birthdayRequest.getCreator ());
        birthdayFromDb.setTotalGiven (birthdayRequest.getTotalGiven ());
        birthdayFromDb.setEnding(dateOfCreation);

        return birthdayRepository.save(birthdayFromDb);
    }
}



