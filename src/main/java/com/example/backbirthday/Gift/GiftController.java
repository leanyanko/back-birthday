package com.example.backbirthday.Gift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GiftController {

    @Autowired
    private GiftRepository giftRepository;

    @GetMapping("/api/gifts")
    public Iterable<Gift> findAllGifts () {
        return giftRepository.findAll ();
    }

    @GetMapping("/api/gifts/{giftId}")
    public Optional<Gift> findGiftById(@PathVariable Long giftId) {
        return giftRepository.findById(giftId);
    }

    @DeleteMapping("api/gifts/{giftId}")
    public HttpStatus deleteGiftById(@PathVariable Long giftId) {
        giftRepository.deleteById(giftId);
        return HttpStatus.OK;
    }

    @PostMapping("/api/gifts")
    public Gift createNewGift(@RequestBody Gift newGift) {
        return giftRepository.save(newGift);
    }

    @PatchMapping("/api/gifts/{giftId}")
    public Gift updateGiftById(@PathVariable Long giftId, @RequestBody Gift giftRequest) {
        Gift giftFromDb = giftRepository.findById(giftId).get();

//        giftFromDb.setGiftname(giftRequest.getGiftname());
//        giftFromDb.setFirstName(giftRequest.getFirstName());
//        giftFromDb.setLastName(giftRequest.getLastName());
//        giftFromDb.setEmail(giftRequest.getEmail());
//        giftFromDb.setAboutMe(giftRequest.getAboutMe());
//        giftFromDb.setPassword(giftRequest.getPassword());

        return giftRepository.save(giftFromDb);
    }
}



