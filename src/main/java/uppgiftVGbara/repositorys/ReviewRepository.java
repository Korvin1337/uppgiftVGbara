package uppgiftVGbara.repositorys;

import uppgiftVGbara.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    /*List<Review> findByAppUser_Username(String username);*/

}