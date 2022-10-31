package dk.poops.poopcloud.service;

import dk.poops.poopcloud.models.WishList;
import dk.poops.poopcloud.repository.WishListJPARepo;
import dk.poops.poopcloud.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
WishListService {

  @Autowired
  WishListJPARepo wishListJPARepo;
  @Autowired
  WishListRepo wishListRepo;

  public List<WishList> fetchAllWishLists() {
    return wishListJPARepo.findAll();
  }

  public void saveWishList(WishList wishList) {
    wishListJPARepo.save(wishList);
  }

  public void deleteWishList(int id) {
    wishListRepo.deleteWishList(id);
  }

  public WishList findWishListById(int id) {
    return wishListJPARepo.getById(id);
  }

}
