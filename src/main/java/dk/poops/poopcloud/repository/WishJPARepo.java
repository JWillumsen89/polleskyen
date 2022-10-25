package dk.poops.poopcloud.repository;

import dk.poops.poopcloud.models.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishJPARepo extends JpaRepository<Wish, Integer> {
}
