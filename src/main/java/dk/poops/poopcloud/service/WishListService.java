package dk.poops.poopcloud.service;

import dk.poops.poopcloud.models.WishList;
import dk.poops.poopcloud.repository.WishListJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListService {

  @Autowired
  WishListJPARepo wishListJPARepo;

  public List<WishList> fetchAllWishLists() {
    return wishListJPARepo.findAll();
  }

  public void saveWishList(WishList wishList){
    wishListJPARepo.save(wishList);

  }

  public void deleteWishList(int id){
      wishListJPARepo.deleteById(id);

  }

}
