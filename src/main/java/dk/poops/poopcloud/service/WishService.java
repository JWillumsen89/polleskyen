package dk.poops.poopcloud.service;

import dk.poops.poopcloud.models.Wish;
import dk.poops.poopcloud.repository.WishJPARepo;
import dk.poops.poopcloud.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    WishJPARepo wishJPARepo;
    @Autowired
    WishRepo wishRepo;

    public void saveWish(Wish wish) {
        wishJPARepo.save(wish);
    }

    public List<Wish> fetchAllWishes() {
        return wishJPARepo.findAll();
    }

    public List<Wish> fetchByID(int id) {
        return wishJPARepo.findWishByList_id(id);
    }

    public void deleteWish(int id) {
        wishJPARepo.deleteById(id);
    }


    public void reserveWish(Wish wish) {
        wishRepo.reserveWish(wish);

    }

    public Wish findById(int id) {
        return wishJPARepo.getReferenceById(id);
    }


}
