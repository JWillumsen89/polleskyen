package dk.poops.poopcloud.repository;

import dk.poops.poopcloud.models.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishJPARepo extends JpaRepository<Wish, Integer> {

    @Query("SELECT t FROM Wish t where t.list_id = ?1")
    List<Wish> findWishByList_id(int id);

}
