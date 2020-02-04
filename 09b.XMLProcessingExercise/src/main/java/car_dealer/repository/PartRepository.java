package car_dealer.repository;

import car_dealer.domain.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    @Query(value = "select * from parts order by rand() limit 1", nativeQuery = true)
    Part getRandomPart();
}
