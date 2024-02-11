package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    @Override
    @Query(value = "select * from tb_review where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<Review> findById(Long id);

    @Override
    @Query(value = "select * from tb_review where status = 'ACTIVATED'", nativeQuery = true)
    List<Review> findAll();

}
