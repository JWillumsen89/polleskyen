package dk.poops.poopcloud.repository;

import dk.poops.poopcloud.models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListJPARepo extends JpaRepository<WishList, Integer> {


}
