package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BonusRepo extends JpaRepository<Bonus, Long> {

    @Override
    @Query(value = "select * from tb_bonus where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<Bonus> findById(Long id);

    @Override
    @Query(value = "select * from tb_bonus where status = 'ACTIVATED'", nativeQuery = true)
    List<Bonus> findAll();

}
