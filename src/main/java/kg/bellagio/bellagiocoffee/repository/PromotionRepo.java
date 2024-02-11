package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Long> {

    @Override
    @Query(value = "select * from tb_promotion where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<Promotion> findById(Long id);

    @Override
    @Query(value = "select * from tb_promotion where status = 'ACTIVATED'", nativeQuery = true)
    List<Promotion> findAll();

}
