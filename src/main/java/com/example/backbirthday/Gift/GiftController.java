package com.example.backbirthday.Gift;

import com.example.backbirthday.Birthday.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class GiftController {

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    BirthdayRepository birthdayRepository;

    @GetMapping("/api/gifts")
    public Iterable<Gift> findAllGifts () {
        return giftRepository.findAll ();
    }

    @GetMapping("/api/gifts/{giftId}")
    public Optional<Gift> findGiftById(@PathVariable Long giftId) {
        return giftRepository.findById(giftId);
    }

    @GetMapping("/api/{birthdayId}/gifts")
    public Optional<Gift> getAllGiftsByBirthdayId(@PathVariable (value = "birthdayId") long birthdayId) {
        return giftRepository.findByBirthdayId(birthdayId);
    }

    @DeleteMapping("api/gifts/{giftId}")
    public HttpStatus deleteGiftById(@PathVariable Long giftId) {
        giftRepository.deleteById(giftId);
        return HttpStatus.OK;
    }

    @PostMapping("/api/birthdays/{birthdayId}/gifts")
    public Optional<Gift> createNewGift(@PathVariable (value = "birthdayId") Long birthdayId, @Valid @RequestBody Gift newGift) {
        return birthdayRepository.findById(birthdayId).map(birthday-> {
            newGift.setBirthday(birthday);
            return giftRepository.save(newGift);
        });
    }

    @PutMapping("/api/gifts/{giftId}/{birthdayId}")
    public Optional<Gift> updateGift(@PathVariable (value="giftId") Long giftId, @PathVariable (value="birthdayId") Long birthdayId, @Valid @RequestBody Gift newGift) {
        return giftRepository.findById(giftId).map(gift -> {
            gift.setTitle(newGift.getTitle ());
            gift.setAmount(newGift.getAmount ());
            gift.setBirthday (gift.getBirthday ());
            return giftRepository.save(gift);
        });
    }
}



